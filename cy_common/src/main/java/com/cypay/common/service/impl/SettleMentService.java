package com.cypay.common.service.impl;

import java.math.BigDecimal;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Future;
import java.util.function.Function;
import java.util.stream.Collectors;

import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONObject;
import com.cypay.common.entity.Bank;
import com.cypay.common.entity.SettleMent;
import com.cypay.common.pattern.template.settlement.SettlementTemplate;
import com.cypay.common.repository.impl.BankRepository;
import com.cypay.common.repository.impl.SettleMentRepository;
import com.cypay.common.service.CriteriaData;
import com.cypay.common.util.PageData;
import com.cypay.common.vo.Result;
import com.cypay.common.vo.SettleMentVo;

@Service
public class SettleMentService extends BaseServiceImpl<SettleMentRepository, SettleMent,SettleMentVo>{

	private final static String UPDATE_OVER_MONEY = "UPDATE cy_bank b SET b.over_money = b.over_money - ?, b.all_pay = b.all_pay + ? WHERE b.id = ?";
	
	private final static String INSERT_SETTLEMENT = "INSERT INTO cy_settle_ment(amount, apply_date, bank_id, cost, discription, merchant_id, serial_number, state, type, version) values (?, ?, ?, ?, ?, ?, ?, ?, ?, 0)";
	
	@Autowired
	private BankRepository bankRepository;
	
	private Map<String, SettlementTemplate> settlementTemplates = new HashMap<>();
	
	public SettleMentService(List<SettlementTemplate> list) {
		this.settlementTemplates = list.parallelStream().collect(Collectors.toMap(SettlementTemplate::mark, Function.identity()));
	}
	
	public JSONObject findSettlementDData(SettleMentVo v, PageData pageData) {
		JSONObject json = new JSONObject();
		try {
			// 查询当天充值统计
			Future<SettleMentVo> task1 = futureTaskPool.submit(() -> {
				return findSettleMentTotalData(v);
			});
			// 查询前一天充值统计
			Future<Page<SettleMentVo>> task2 = futureTaskPool.submit(() -> {
				return findVoPageList(v, pageData);
			});
			json.put("page", task2.get());
			json.put("total", task1.get());
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
		return json;
	}
	
	@SuppressWarnings("unchecked")
	public SettleMentVo findSettleMentTotalData(SettleMentVo v) {
		CriteriaData<SettleMent, SettleMentVo> cd = getCriteriaData();
		CriteriaBuilder cb = cd.getCriteriaBuilder();
		Root<SettleMent> root = cd.getRoot();
		cd.getCriteriaQuery().multiselect(cb.sum(root.get("amount")), cb.sum(root.get("cost")).alias("fee"));
		dynamicWhele(cd, v);
		TypedQuery<SettleMentVo> query = (TypedQuery<SettleMentVo>) entityManager.createQuery(cd.getCriteriaQuery());
		return query.getSingleResult();
	}
	
	/**
	 * 金额结算
	 * banks 银行账户列表 存储变动后的账户数据
	 * settleMents 结算列表 存储要结算商户的数据
	 * @return
	 */
	@Transactional
	public Result settlement(List<SettleMentVo> list,String flag){
		Map<Long, SettleMentVo> data = list.stream().collect(Collectors.toMap(SettleMentVo::getBankId, v -> v));
		
		List<Bank> banks = bankRepository.findByIdIn(new ArrayList<Long>(data.keySet()));
		Iterator<Bank> iterator = banks.iterator();
		while (iterator.hasNext()) {
			Bank bank = iterator.next();
			SettleMentVo v = data.get(bank.getId());
			BigDecimal useAmount = v.getUseAmount();
			BigDecimal fee = v.getFee().compareTo(BigDecimal.ZERO) == 1 ? v.getFee() : BigDecimal.ZERO;
			BigDecimal amount = useAmount.add(fee);
			if (useAmount.compareTo(BigDecimal.ZERO) == 1 && bank.getOverMoney().compareTo(amount) > -1) {
				bank.setOverMoney(amount);
				bank.setFee(fee);
			} else {
				iterator.remove();
			}
		}
		
		if (!banks.isEmpty()) {
			// 插入结算记录
			batchInsertSettlement(banks, 2, 0, flag + "结算", "F");
			// 更新账户余额
			batchUpdateBankOverMoney(banks);
			
			return Result.success("请前往‘资金管理 ->提现业务->待付款’列表完成结算！");
		}
		
//		List<SettleMent> settleMents = new ArrayList<SettleMent>();
//		for (Bank bank : banks) {
//			Long bankId = bank.getId();
//			for (SettleMentVo v : list) {
//				if (v.getBankId().compareTo(bankId) == 0) {
//					BigDecimal useAmount = v.getUseAmount();
//					BigDecimal amount = useAmount.add(v.getFee());
//					if (v.getFee().compareTo(BigDecimal.ZERO) > -1 && useAmount.compareTo(BigDecimal.ZERO) > 0 && bank.getOverMoney().compareTo(amount) > -1) {
//						bank.setOverMoney(bank.getOverMoney().subtract(amount));
//						bank.setAllPay(bank.getAllPay().add(amount));
//						SettleMent settleMent = new SettleMent();
//						settleMent.setAmount(useAmount);
//						settleMent.setCost(v.getFee());
//						settleMent.setBank(bank);
//						settleMent.setDiscription(flag + "结算");
//						
//						settleMent.setMerchant(bank.getMerchant());
//						settleMent.setSerialNumber("F" + snowflakeIdWorker.nextId());
//						settleMent.setState(2);
//						settleMents.add(settleMent);
//					}
//					break;
//				}
//			}
//		}
//		if (!settleMents.isEmpty()) {
//			baseRepository.saveAll(settleMents);
//			return Result.success("请前往‘资金管理 ->提现业务->待付款’列表完成结算！");
//		}
		return Result.error("没有符合条件的结算记录");				
	}
	
	/**
	 * 结算业务
	 * @param list
	 * @param mark
	 * @return
	 */
	@Transactional
	public Result payment(List<Long> ids, String mark, String disc) {
		return settlementTemplates.get(mark).settlement(ids, disc);
	}
	
	public List<SettleMentVo> findGalleryFunds(Long merchantId) throws ParseException{
		return baseRepository.findGalleryFunds(merchantId);
	}
	
	public Result clear(SettleMentVo v){
		int i = baseRepository.deleteSettleMentByDate(v.getStartDate(), v.getEndDate());
		if (i > 0)
			return Result.success("结算信息清除成功");
		return Result.error("结算信息清除失败");
	}
	
	public Map<String,BigDecimal> findTotalAmountByState(Integer state){
		return baseRepository.findByTotalAmountByState(state);
	}
	
	public int updateStateById(Integer state,Long id,Date date,String discription){
		return baseRepository.updateStateById(state, id, date,discription);
	}
	
	public SettleMent findBySerialNumber(String serialNumber){
		return baseRepository.findBySerialNumber(serialNumber);
	}

	/**
	 * 批量更新帐户余额
	 * @param list
	 */
	public void batchUpdateBankOverMoney(List<Bank> list) {
		jdbcTemplate.batchUpdate(UPDATE_OVER_MONEY, new BatchPreparedStatementSetter() {
			
			@Override
			public void setValues(PreparedStatement ps, int i) throws SQLException {
				Bank bank = list.get(i);
				BigDecimal amount = bank.getOverMoney();
				ps.setBigDecimal(1, amount);
				ps.setBigDecimal(2, amount);
				ps.setLong(3, bank.getId());
			}
			
			@Override
			public int getBatchSize() {
				return list.size();
			}
		});
	}
	
	/**
	 * 批量插入结算记录
	 * @param list
	 * @param state
	 * @param type
	 */
	public void batchInsertSettlement(List<Bank> list, Integer state, Integer type, String discription, String flag) {
		jdbcTemplate.batchUpdate(INSERT_SETTLEMENT, new BatchPreparedStatementSetter() {
			
			@Override
			public void setValues(PreparedStatement ps, int i) throws SQLException {
				Bank bank = list.get(i);
				ps.setBigDecimal(1, bank.getOverMoney().subtract(bank.getFee()));
				ps.setTimestamp(2, new Timestamp(System.currentTimeMillis()));
				ps.setLong(3, bank.getId());
				ps.setBigDecimal(4, bank.getFee());
				ps.setString(5, discription);
				ps.setLong(6, bank.getMerchantId());
				ps.setString(7, flag + snowflakeIdWorker.nextId());
				ps.setInt(8, state);
				ps.setInt(9, type);
			}
			
			@Override
			public int getBatchSize() {
				return list.size();
			}
		});
	}
}
