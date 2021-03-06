package com.cypay.common.service.impl;

import java.math.BigDecimal;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.concurrent.locks.ReentrantLock;

import javax.servlet.http.HttpServletRequest;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.cypay.common.entity.DengLu;
import com.cypay.common.entity.Merchant;
import com.cypay.common.entity.Visit;
import com.cypay.common.repository.impl.DengLuRepository;
import com.cypay.common.repository.impl.MerchantRepository;
import com.cypay.common.repository.impl.VisitRepository;
import com.cypay.common.shiro.ShiroManager;
import com.cypay.common.util.CommonUtil;
import com.cypay.common.util.DUtil;
import com.cypay.common.vo.Result;

import cn.hutool.core.date.DateUtil;

@Service
public class VisitService extends BaseServiceImpl<VisitRepository, Visit, Visit> {
	
	@Autowired
	private DengLuRepository dengLuRepository;
	
	@Autowired
	private MerchantRepository merchantRepository;
	
	@Autowired
	private VisitRepository visitRepository;
	
	private ReentrantLock lock = new ReentrantLock();

	/**
	 * ips统计结果集
	 * @param merchantId
	 * @param startDate
	 * @param endDate
	 * @param pageSize
	 * @return
	 */
	public List<Map<String,Object>> findVisitList(Visit v){
		Merchant merchant = ShiroManager.getMerchant();
		List<Map<String,Object>> data = new ArrayList<Map<String,Object>>();
		/**IPS统计结果集*/
		data = baseRepository.findVisitList(merchant.getId(), v.getVisitDate(), v.getEndDate(), v.getPageSize());
		/**将自行输入结果集封装到IPS统计结果集中*/
		data.add(0, baseRepository.findSelfVistList(v.getVisitDate(), v.getEndDate(), merchant.getId()));
		return data;
	}

	/***
	 * 流量统计
	 * 
	 * @param request
	 * @throws ParseException
	 */
	public void visit(HttpServletRequest request,Integer visitTime) {
		Date currentDate = DUtil.currentDate(new Date(),"yyyy-MM-dd");
		Long currentMillionSeconds = DUtil.currentDate(new Date(), "HH:mm:ss").getTime();
		Visit visit = new Visit();
		/**获取参数 */
		String uuid = request.getParameter("u");
		String url = request.getParameter("c");
		try {
			Map<String, Object> open = merchantRepository.findIpsLoggerByMerchantId(uuid);
			/** 判断商户是否开启流量统计 */
			if (open.get("isIps").equals(true)) {
				String ip = CommonUtil.getIpAddr(request);
				String domain = this.unescape(url);
				Long merchantId = Long.valueOf(open.get("id").toString());
				/**如果域名不为空则说明访问记录来源为发布站,否则为自行输入*/
				if (!StringUtils.isEmpty(domain)) {
					visit.setDomain(domain.split("[?]")[0]);
					visit.setIps(ip);
					visit.setMerchantId(merchantId);
					visit.setDlTime(DateUtil.offsetMinute(visit.getDlTime(), -30));
					/**如果time为空则直接保存记录*/
					Date time = baseRepository.findCurrentVisitTime(merchantId, ip, DateUtil.formatDate(currentDate));
					/** 同一个ip在某个时间段内不允许重复记录 */
					if (StringUtils.isEmpty(time)) {
						baseRepository.save(visit);
					} else {
						if (currentMillionSeconds - time.getTime() > 60000 * visitTime)
							baseRepository.save(visit);
					}
				} else {
					/** 自行输入访问次数 */
					DengLu denglu = new DengLu();
					/**如果time为空则直接保存或更新记录*/
					Date vTime = dengLuRepository.findCurrentDengLuVTime(merchantId, ip, DateUtil.formatDate(currentDate));
					if (StringUtils.isEmpty(vTime)) {
						dengLuRepository.saveSelfVisit(denglu.getCount(), denglu.getDlDate(), denglu.getvTime(),
								merchantId, ip, denglu.getSelfCount() + 1L);
					} else {
						/** 同一个ip在某个时间段内不允许重复记录 */
						if (currentMillionSeconds - vTime.getTime() > 60000 * visitTime)
							dengLuRepository.updateSelfVisit(DateUtil.formatTime(denglu.getvTime()), DateUtil.formatDate(denglu.getDlDate()), merchantId, ip);
					}
				}
			}
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
	}
	
	/**
	 * 进入游戏人数统计
	 * @param request
	 */
	public void game(HttpServletRequest request,Integer loginTime){
		Date currentDate = DUtil.currentDate(new Date(), "yyyy-MM-dd");
		Long currentMillionSeconds = DUtil.currentDate(new Date(), "HH:mm:ss").getTime();
		/**获取参数*/
		String uuid = request.getParameter("u");
		Map<String, Object> open = merchantRepository.findIpsLoggerByMerchantId(uuid);
		try{
			/**判断商户是否开启游戏登陆统计*/
			if(open.get("isLogger").equals(true)){
				String ip = CommonUtil.getIpAddr(request);
				Long merchantId = Long.valueOf(open.get("id").toString());
				Date visitDlTime = baseRepository.findCurrentVisitDlTime(merchantId, ip, DateUtil.formatDate(currentDate));
				/**更新登陆游戏记录数,如果time是空则说明当天没有从发布站访问网站的记录,做自行登陆处理。否则直接更新visit表中相应ip的登陆次数*/
				if(StringUtils.isEmpty(visitDlTime)){
					/**更新自行登陆游戏记录数*/
					DengLu denglu = new DengLu();
					/**如果time是空则直接保存或更新记录*/
					Date time = dengLuRepository.findCurrentDengLuTime(merchantId, ip, DateUtil.formatDate(currentDate));
					if (StringUtils.isEmpty(time)){
						dengLuRepository.saveSelfCount(denglu.getCount() + 1L, denglu.getDlDate(), denglu.getDlTime(),
								merchantId, ip, denglu.getSelfCount());
					}else{
						/**一个时间段内不允许重复记录*/
						if(currentMillionSeconds - time.getTime() > 60000 * loginTime){
							dengLuRepository.updateSelfCount(DateUtil.formatTime(denglu.getDlTime()), DateUtil.formatDate(denglu.getDlDate()), merchantId, ip);
						}
					}
				}else{ 
					/**一个时间段内不允许重复记录*/
					if (currentMillionSeconds - visitDlTime.getTime() > 60000 * loginTime){
						/**更新游戏登陆记录*/
						baseRepository.updateCountRecord(merchantId, ip,DateUtil.formatDate(currentDate),DateUtil.formatTime(new Date()));
					}
				}
			}
		}catch (Exception e) {
			logger.error(e.getMessage());
		}
	}
	
	/**
	 * 更新统计数据订单信息
	 * @param orderMoney
	 * @param profit
	 * @param ip
	 * @param merchantId
	 * @return
	 */
	public int updateOrderRecord(BigDecimal orderMoney,BigDecimal profit,String ip,Long merchantId){
		try{
			lock.lock();
			return baseRepository.updateOrderRecord(orderMoney, profit, ip, merchantId);
		}finally {
			lock.unlock();
		}
	}
	
	@Transactional
	public Result clearIps(Date date){
		int i,j = 0;
		i = dengLuRepository.deleteDengLuByDate(date);
		j = baseRepository.deleteVisitByDate(date);
		if( i > 0 && j > 0){
			return Result.success("数据清理成功");
		}else{
			return Result.error("数据清理失败");
		}
	}
	
	/**
	 * unescape 解密
	 * @param src
	 * @return
	 */
	private String unescape(String src) {
		StringBuilder tmp = new StringBuilder();
		tmp.ensureCapacity(src.length());
		int lastPos = 0, pos = 0;
		char ch;
		while (lastPos < src.length()) {
			pos = src.indexOf('%', lastPos);
			if (pos == lastPos) {
				if (src.charAt(pos + 1) == 'u') {
					ch = (char) Integer.parseInt(src.substring(pos + 2, pos + 6), 16);
					tmp.append(ch);
					lastPos = pos + 6;
				} else {
					ch = (char) Integer.parseInt(src.substring(pos + 1, pos + 3), 16);
					tmp.append(ch);
					lastPos = pos + 3;
				}
			} else {
				if (pos == -1) {
					tmp.append(src.substring(lastPos));
					lastPos = src.length();
				} else {
					tmp.append(src.substring(lastPos, pos));
					lastPos = pos;
				}
			}
		}
		if (tmp.toString().contains("=")){
			return tmp.toString().split("=")[0];
		}
		return tmp.toString();
	}
	
	public Result ipsTotal(){
		Integer ips = visitRepository.ipsCount();
		Integer denglu = dengLuRepository.dengluCount();
		if (StringUtils.isEmpty(ips))
			ips = 0;
		if (StringUtils.isEmpty(denglu))
			denglu = 0;
		return Result.success("查询成功",ips+denglu);
	}
}
