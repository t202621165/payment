package com.cypay.common.service.impl;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.Future;

import javax.persistence.criteria.Join;
import javax.persistence.criteria.JoinType;
import javax.persistence.criteria.Predicate;
import javax.transaction.Transactional;

import org.apache.shiro.crypto.hash.Md5Hash;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;
import org.springframework.util.StringUtils;

import com.alibaba.fastjson.JSONObject;
import com.cypay.common.entity.Bank;
import com.cypay.common.entity.Merchant;
import com.cypay.common.entity.Message;
import com.cypay.common.entity.Notice;
import com.cypay.common.entity.Partition;
import com.cypay.common.entity.Product;
import com.cypay.common.entity.Rank;
import com.cypay.common.entity.SystemSet;
import com.cypay.common.entity.WechatInfo;
import com.cypay.common.enums.Edition;
import com.cypay.common.repository.impl.BankRepository;
import com.cypay.common.repository.impl.MerchantRepository;
import com.cypay.common.repository.impl.NoticeRepository;
import com.cypay.common.repository.impl.OrderRepository;
import com.cypay.common.repository.impl.PartitionRepository;
import com.cypay.common.repository.impl.ProductRepository;
import com.cypay.common.repository.impl.RankRepository;
import com.cypay.common.repository.impl.TemplateRepository;
import com.cypay.common.repository.impl.WechatInfoRepository;
import com.cypay.common.service.CriteriaData;
import com.cypay.common.shiro.ShiroManager;
import com.cypay.common.util.CommonUtil;
import com.cypay.common.util.PageData;
import com.cypay.common.vo.MerchantVo;
import com.cypay.common.vo.OrderVo;
import com.cypay.common.vo.Result;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.date.DateUtil;
import cn.hutool.core.util.IdUtil;

@Service
public class MerchantService extends BaseServiceImpl<MerchantRepository, Merchant, MerchantVo> {
	
	@Autowired
	private MessageService messageService;
	@Autowired
	private OrderService orderService;
	@Autowired
	private BankRepository bankRepository;
	@Autowired
	private NoticeRepository noticeRepository;
	@Autowired
	private RankRepository rankRepository;
	@Autowired
	private OrderRepository orderRepository;
	@Autowired
	private PartitionRepository partitionRepository;
	@Autowired
	private TemplateRepository templateRepository;
	@Autowired
	private SystemSetService systemSetService;
	@Autowired
	private ProductRepository productReporitory;
	@Autowired
	private WechatInfoRepository wechatInfoRepository;
	
	
	/**
	 * 根据商户帐号查询商户(商户登录)
	 * @param account
	 * @return
	 */
	public Merchant findByAccount(String account) {
		return baseRepository.findByAccount(account);
	}
	
	public Map<String, Object> findHomePageData() {
		Merchant merchant = ShiroManager.getMerchant();
		Map<String, Object> map = new HashMap<>();
		map.put("qqNumbers", CommonUtil.getQQNumbers(merchant.getServiceQQ()));
		map.put("merchant",merchant);
		try {
			Future<Bank> bank = futureTaskPool.submit(() -> {
				Bank b = bankRepository.findOverMoneyAndSettlementMoney(merchant);
				BigDecimal settlementable = b.getOverMoney().subtract(merchant.getFee());
				if (settlementable.doubleValue() > 0) {
					b.setSettlementable(settlementable);
				}
				if (!b.getState()) {
					b.setFrozen(b.getOverMoney());
				}
				return b;
			});
			
			Future<Long> count = futureTaskPool.submit(() -> {
				return messageService.count(new Message(merchant));
			});
			
			Future<Long> agentCount = futureTaskPool.submit(() -> {
				MerchantVo v = new MerchantVo();
				v.setParent(merchant);
				return count(v);
			});
			
			Future<List<Notice>> notice = futureTaskPool.submit(() -> {
				return noticeRepository.findByState(Boolean.TRUE);
			});
			
			Future<OrderVo> order = futureTaskPool.submit(() -> {
				OrderVo ov = new OrderVo();
				Date d = new Date();
				ov.setOrderDate(DateUtil.beginOfDay(d));
				ov.setPayDate(DateUtil.endOfDay(d));
				ov.setIsAdmin(false);
				ov.setMerchant(merchant);
				return orderService.orderTatalData(ov);
			});
			
			Future<OrderVo> agentOrder = futureTaskPool.submit(() -> {
				OrderVo ov = new OrderVo();
				Date d = new Date();
				ov.setOrderDate(DateUtil.beginOfDay(d));
				ov.setPayDate(DateUtil.endOfDay(d));
				ov.setIsAdmin(false);
				ov.setAgent(merchant);
				return orderService.orderTatalData(ov);
			});
			Future<List<OrderVo>> orders = futureTaskPool.submit(() -> {
				OrderVo ov = new OrderVo();
				Date d = new Date();
				ov.setOrderDate(DateUtil.beginOfDay(d));
				ov.setPayDate(DateUtil.endOfDay(d));
				ov.setState(1);
				ov.setIsAdmin(false);
				ov.setPayAmount(null);
				ov.setMerchant(merchant);
				return orderService.findVoPageList(ov, new PageData(0, 10)).getContent();
			});
			if (merchant.getIsWxBind() == null) {
				WechatInfo wechatInfo = wechatInfoRepository.findByMerchantId(merchant.getId());
				merchant.setWechatInfo(wechatInfo);
				merchant.setIsWxBind(wechatInfo != null);
			}
			
			map.put("bank", bank.get());
			map.put("message", count.get());
			map.put("notice", notice.get());
			map.put("order", order.get());
			map.put("orders", orders.get());
			map.put("agentOrder", agentOrder.get());
			map.put("agentCount", agentCount.get());
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
		return map;
	}
	
	/**
	 * 查询下属商户
	 * @param merchant
	 * @return
	 */
	public List<Merchant> findByParent(Merchant merchant) {
		return baseRepository.findByParent(merchant);
	}
	
	/**
	 * 添加下属商户
	 * @param t
	 * @return
	 */
	@Transactional
	public Result saveAgent(Merchant t) {
		// 非商业版
		if (Edition.current_edition != Edition.BUSINESS) {
			// 个人版-注册商户数不能超过最大允许注册数
			if (baseRepository.count() >= Edition.current_edition.getMax_allowed_regist_number()) {
				return Result.error("注册失败，当前程序版本用户注册数已达上限！");
			}
		}
		Merchant m = baseRepository.findByAccount(t.getAccount());
		if (m != null)
			return Result.error("账号【"+t.getAccount()+"】已存在", "account");
		
		String uuid = IdUtil.fastSimpleUUID();
		t.setUuid(uuid);
		t.setSecretKey(IdUtil.fastSimpleUUID());
		t.setSettlementType(0);
		t.setState(1);
		t.setPassword(new Md5Hash(t.getPassword(), uuid).toHex());
		t.setParent(ShiroManager.getMerchant());
		baseRepository.save(t);
		// 添加商户产品信息
		saveMerchantProduct(t.getId());
		// 添加商户银行账户
		saveMerchantBank(t);
		return Result.success("添加成功");
	}
	
	/**
	 * 商户注册
	 * @param merchant
	 * @return
	 */
	@Transactional
	public Result register(Merchant merchant) {
		// 非商业版
		try{
			if (Edition.current_edition != Edition.BUSINESS) {
				// 个人版-注册商户数不能超过最大允许注册数
				if (baseRepository.count() >= Edition.current_edition.getMax_allowed_regist_number()) {
					return Result.error("注册失败，当前程序版本用户注册数已达上限！");
				}
			}
			
			SystemSet sys = systemSetService.findRegisterData();

			if (sys.getRegisterState() == 0) { // 关闭注册
				return Result.error("注册功能已关闭");
			}
			
			Merchant m = baseRepository.findByAccount(merchant.getAccount());
			if (m != null)
				return Result.error("当前账号不可用", "account");
			
			String parent_uuid = merchant.getUuid();
			boolean isProxyRank = false;
			if (parent_uuid != null && parent_uuid.length() == 32) { // 代理
				Map<String, BigInteger> parent = baseRepository.findByUuid(parent_uuid);
				if (parent != null) {
					merchant.setParent(new Merchant(parent.get("merchantId").longValue()));
					if (parent.get("rankId") != null) {
						merchant.setRank(new Rank(parent.get("rankId").longValue()));
						isProxyRank = true;
					}
				}
			}
			
			if (!isProxyRank) {
				List<Rank> ranks = rankRepository.findDefaultRank();
				if (CollUtil.isNotEmpty(ranks)) {
					merchant.setRank(ranks.get(0)); // 设置默认级别
				}
			}

			String uuid = IdUtil.fastSimpleUUID();
			merchant.setUuid(uuid);
			merchant.setSettlementType(sys.getSettlementType()); // 系统默认结束类型
			merchant.setState(sys.getRegisterState());// 1：开启注册 2：开启商户注册审核
			merchant.setPassword(new Md5Hash(merchant.getPassword(), uuid).toHex());
			merchant.setSecretKey(IdUtil.fastSimpleUUID());
			merchant.setFee(sys.getDefaultFee());
			// 保存商户信息
			baseRepository.save(merchant);
			// 添加商户产品信息
			saveMerchantProduct(merchant.getId());
			// 添加商户银行账户
			saveMerchantBank(merchant);
			return Result.success("注册成功");
		}catch (Exception e) {
			e.printStackTrace();
		}
		return Result.error("注册失败");
	}
	
	/**
	 * 添加商户产品信息
	 * @param merchantId
	 */
	private void saveMerchantProduct(Long merchantId) {
		List<Product> products = productReporitory.findAll();
		if (CollUtil.isNotEmpty(products)) {
			String sql = "insert into cy_merchant_product(merchant_id,product_id,state) values("+merchantId+",?,1)";
			jdbcTemplate.batchUpdate(sql, new BatchPreparedStatementSetter() {
				
				@Override
				public void setValues(PreparedStatement ps, int i) throws SQLException {
					Product p = products.get(i);
					ps.setLong(1, p.getId());
				}
				
				@Override
				public int getBatchSize() {
					return products.size();
				}
			});
		}
	}
	
	/**
	 * 添加商户银行账户（未激活状态）
	 * @param merchant
	 */
	private void saveMerchantBank(Merchant merchant) {
		Bank bank = Bank.unactivate();
		bank.setMerchant(merchant);
		bankRepository.save(bank);
	}
	
	/**
	 * 商户-更新资料
	 */
	@Override
	public Result save(Merchant t) {
		Merchant merchant = ShiroManager.getMerchant();
		Merchant m = baseRepository.findByAccount(t.getAccount());
		if (m != null && m.getId().compareTo(merchant.getId()) != 0) {
			return Result.error("当前账号不可用", "account");
		}
		
		merchant.setNickname(t.getNickname());
		merchant.setAccount(t.getAccount());
		merchant.setQqNumber(t.getQqNumber());
		merchant.setPhoneNumber(t.getPhoneNumber());
		merchant.setServiceQQ(t.getServiceQQ());
		merchant.setServicePhone(t.getServicePhone());
		Merchant ob = baseRepository.save(merchant);
		return Result.success("操作成功",ob.getId());
	}
	
	public Result updateServiceInfo(String serviceQQ, String servicePhone) {
		Merchant merchant = ShiroManager.getMerchant();
		merchant.setServicePhone(servicePhone);
		merchant.setServiceQQ(serviceQQ);
		
		baseRepository.save(merchant);
		return Result.success("更新成功");
	}
	
	public int updateMerchantRank(Long rankId,Long merchantId){
		return baseRepository.updateMerchantRank(rankId, merchantId);
	}
	
	@Override
	protected CriteriaData<Merchant, MerchantVo> getCriteriaData(String name, MerchantVo v) {
		CriteriaData<Merchant, MerchantVo> cd = super.getCriteriaData(name, v);
		cd.getCriteriaQuery().groupBy(cd.getRoot().get("id"));
		Join<Merchant, Partition> partition = cd.getRoot().join("partitions", JoinType.LEFT);
		cd.getRoot().join("rank", JoinType.LEFT);
		cd.getRoot().join("parent",JoinType.LEFT);
		if (!cd.isCache()) {
			cd.addSelection(cd.getCriteriaBuilder().count(partition.get("id")));
		}
		return cd;
	}
	
	@Override
	protected List<Predicate> additionalWhele(CriteriaData<Merchant, MerchantVo> cd, List<Predicate> wheles, MerchantVo v){
		if (v.getType()){
			wheles.add(cd.getCriteriaBuilder().isNotNull(cd.getRoot().get("parent")));
		}
		return wheles;
	}
	
	public Result updateState(Integer type) {
		Assert.notNull(type, "The Type cannot be null.");
		
		Merchant merchant = ShiroManager.getMerchant();
		Long id = merchant.getId();
		String sql = "UPDATE cy_merchant SET @FIELD@ = CASE WHEN @FIELD@ = 0 THEN 1 ELSE 0 END WHERE id = " + id;
		int i = 0;
		switch (type) {
		case 1:
			i = jdbcTemplate.update(sql.replace("@FIELD@", "service_state"));
			Boolean serviceState = merchant.getServiceState();
			
			if (i == 1)
				merchant.setServiceState(!serviceState);
			return Result.success((serviceState?"关闭":"开启")+"：【在线客服】", !serviceState);
			
		case 2:
			i = jdbcTemplate.update(sql.replace("@FIELD@", "leave_state"));
			Boolean leaveState = merchant.getLeaveState();
			
			if (i == 1)
				merchant.setLeaveState(!leaveState);
			return Result.success((leaveState?"关闭":"开启")+"：【玩家留言】", !leaveState);
			
		case 3:
			i = jdbcTemplate.update(sql.replace("@FIELD@", "is_ips"));
			Boolean isIps = merchant.getIsIps();
			
			if (i == 1)
				merchant.setIsIps(!isIps);
			return Result.success((isIps?"关闭":"开启")+"：【发布站来源统计】", !isIps);
			
		case 4:
			i = jdbcTemplate.update(sql.replace("@FIELD@", "is_logger"));
			Boolean isLogger = merchant.getIsLogger();
			
			if (i == 1)
				merchant.setIsLogger(!isLogger);
			return Result.success((isLogger?"关闭":"开启")+"：【登录器访问】", !isLogger);
			
		case 5:
			i = jdbcTemplate.update(sql.replace("@FIELD@", "phone_state"));
			Boolean phoneState = merchant.getPhoneState();
			
			if (i == 1)
				merchant.setPhoneState(!phoneState);
			return Result.success((phoneState?"关闭":"开启")+"：【玩家手机号码】", !phoneState);
			
		case 6:
			if (merchant.getIsWxBind() && merchant.getWechatInfo() != null) {
				i = jdbcTemplate.update(sql.replace("@FIELD@", "order_to_wx"));
				Boolean orderToWx = merchant.getOrderToWx();
				
				if (i == 1)
					merchant.setOrderToWx(!orderToWx);
				return Result.success((orderToWx?"关闭":"开启")+"：【订单-微信通知】", !orderToWx);
			} else {
				return Result.error("您的账号未绑定微信，请前往【个人中心】完成绑定！");
			}
			
		case 7:
			if (merchant.getIsWxBind() && merchant.getWechatInfo() != null) {
				
				i = jdbcTemplate.update(sql.replace("@FIELD@", "message_to_wx"));
				Boolean messageToWx = merchant.getMessageToWx();
				
				if (i == 1)
					merchant.setMessageToWx(!messageToWx);
				return Result.success((messageToWx?"关闭":"开启")+"：【留言-微信通知】", !messageToWx);
			} else {
				return Result.error("您的账号未绑定微信，请前往【个人中心】完成绑定！");
			}

		default:
			return Result.error("操作失败");
		}
	}
	
	/**
	 * 更新商户
	 * @param v
	 * @return
	 */
	public Result merUpdate(Merchant v){
		Merchant merchant = this.findById(v.getId());
		if (StringUtils.isEmpty(v.getParent().getId())){
			merchant.setParent(null);
		}else{
			Merchant parent = this.findById(v.getParent().getId());
			if (!StringUtils.isEmpty(parent)){
				merchant.setParent(parent);
			}else{
				return Result.error("所属代理上级商户不存在,更新失败");
			}
		}
		Rank rank = new Rank(v.getRank().getId());
		merchant.setRank(rank);
		merchant.setNickname(v.getNickname());
		merchant.setAccount(v.getAccount());
		merchant.setType(v.getType());
		merchant.setServicePhone(v.getServicePhone());
		merchant.setQqNumber(v.getQqNumber());
		merchant.setFee(v.getFee());
		merchant.setServiceQQ(v.getServiceQQ());
		merchant.setSettlementType(v.getSettlementType());
		merchant.setIsIps(v.getIsIps());
		merchant.setState(v.getState());
		merchant.setIsLogger(v.getIsLogger());
		merchant.setLeaveState(v.getLeaveState());
		merchant.setServiceState(v.getServiceState());
		merchant.setPhoneNumber(v.getPhoneNumber());
		Merchant mer = this.update(merchant);
		if (!StringUtils.isEmpty(mer))
			return Result.success("商户基本信息修改成功");
		else
			return Result.error("商户基本信息修改失败");
	}
	
	public MerchantVo findMerchantIdAndKeyAndUUIDByKey(String key){
		return baseRepository.findMerchantIdAndKeyAndUUIDByKey(key);
	}
	
	public Result updateKeyAndUuidByKey(String newKey,String uuid,String oldKey){
		int i = baseRepository.updateKeyAndUuidByKey(newKey, uuid, oldKey);
		if (i > 0)
			return Result.success("更新成功");
		else
			return Result.error("更新失败");
	}

	public Result updateAgentState(Long id, Long parentId) {
		baseRepository.updateAgentState(id, parentId);
		return Result.error("操作成功");
	}
	
	@Transactional
	public Result deleteByIdAndParentId(Long id) {
		Optional<Merchant> optional = baseRepository.findByIdAndParent(id, ShiroManager.getMerchant());
		
		if (!optional.isPresent())
			return Result.error("当前商户不存在或已被删除！");
		Merchant m = optional.get();
		
		orderRepository.deleteByMerchant(m);
		partitionRepository.deleteByMerchant(m);
		templateRepository.deleteByMerchant(m);
		bankRepository.deleteByMerchant(m);
		baseRepository.delete(m);
		return Result.success("商户【"+m.getNickname()+"】已删除！");
	}
	
	public Optional<Merchant> findByIdAndParent(Long id, Merchant parent) {
		return baseRepository.findByIdAndParent(id, parent);
	}

	public Result updatePassword(MerchantVo v) {
		Merchant m = ShiroManager.getMerchant();
		
		Result result = v.newPassword(m.getPassword(), m.getUuid());
		if (!result.getState())
			return result;
		
		m.setPassword(v.getnPassword());
		baseRepository.updatePassword(m, v.getnPassword());
		return Result.success("修改成功！");
	}

	public Result updateSecretKey() {
		String secretKey = IdUtil.fastSimpleUUID();
		Merchant m = ShiroManager.getMerchant();
		m.setSecretKey(secretKey);
		int i = baseRepository.updateSecretKey(m, secretKey);
		if (i == 0)
			return Result.error("更换失败！");
		
		return Result.success("更换成功！请手动复制新的通讯密钥至充值网关！", secretKey);
	}
	
	public Map<String,Object> findIpsLoggerByMerchantId(String uuid){
		return baseRepository.findIpsLoggerByMerchantId(uuid);
	}

	public Result updateAgentRank(Merchant merchant) {
		baseRepository.updateAgentRank(merchant.getId(), merchant.getRankId(), ShiroManager.getMerchant().getId());
		return Result.success("设置成功！");
	}

	public Result updateState(Long id) {
		baseRepository.updateState(id);
		return Result.success();
	}

	public Map<String, Object> getLoginInfo() {
		Map<String, Object> map = new HashMap<>();
		Merchant merchant = ShiroManager.getMerchant();
		map.put("qqNumbers", CommonUtil.getQQNumbers(merchant.getServiceQQ()));
		map.put("merchant", merchant);
		Bank bank = bankRepository.findBankByMerchantId(merchant.getId());
		map.put("bank", bank != null?bank.replace():new Bank());
		String banks = systemSetService.findSettlementBankByMark();
		map.put("banks", JSONObject.parseArray(banks));
		if (merchant.getIsWxBind() == null) {
			WechatInfo wechatInfo = wechatInfoRepository.findByMerchantId(merchant.getId());
			merchant.setWechatInfo(wechatInfo);
			merchant.setIsWxBind(wechatInfo != null);
		}
		return map;
	}

	public Result updateAuthorizeIp(String ips) {
		Merchant merchant = ShiroManager.getMerchant();
		int i = baseRepository.updateAuthorizeIp(merchant.getId(), ips);
		if (i == 1) {
			String oldIp = merchant.getAuthorizeIp();
			merchant.setAuthorizeIp(ips);
			return Result.success(String.format("'%s' -> '%s'", oldIp, ips));
		}
		return Result.error();
	}

}
