package com.cypay.common.repository.impl;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.cypay.common.entity.Visit;
import com.cypay.common.repository.BaseRepository;
@Repository
public interface VisitRepository extends BaseRepository<Visit,Long>{
	/**
	 * 查询最新访问记录的时间
	 * @param merchantId
	 * @param ip
	 * @param date
	 * @return
	 */
	@Query(value="select v.visit_time as visitTime from cy_visit v "
			+ "where v.merchant_id = ?1 "
			+ "and v.ips = ?2 "
			+ "and v.visit_date = ?3 "
			+ "order by v.visit_time desc limit 1",nativeQuery=true)
	Date findCurrentVisitTime(Long merchantId,String ip,String date);
	
	/**
	 * 查询最新登陆记录的时间
	 * @param merchantId
	 * @param ip
	 * @param date
	 * @return
	 */
	@Query(value="select v.dl_time as dlTime from cy_visit v "
			+ "where v.merchant_id = ?1 "
			+ "and v.ips = ?2 "
			+ "and v.visit_date = ?3 "
			+ "order by v.dl_time desc limit 1",nativeQuery=true)
	Date findCurrentVisitDlTime(Long merchantId,String ip,String date);
	
	/**
	 * 更新登陆游戏记录数
	 * @param merchantId
	 * @param ip
	 * @return
	 */
	@Transactional
	@Modifying
	@Query(value="update cy_visit set count = count + 1,dl_time = ?4 "
			+ "where merchant_id = ?1 "
			+ "and ips = ?2 "
			+ "and visit_date = ?3 "
			+ "order by dl_time desc limit 1",nativeQuery=true)
	int updateCountRecord(Long merchantId,String ip,String date,String time);
	
	/**
	 * 更新统计数据订单信息
	 * @param orderMoney 下单金额
	 * @param profit	订单利润
	 * @param ip	下单ip
	 * @param merchantId
	 * @return
	 */
	@Transactional
	@Modifying
	@Query(value="update cy_visit set order_count = order_count + 1,"
			+ "order_money = order_money + ?1,"
			+ "profit = profit + ?2 "
			+ "where ips = ?3 "
			+ "and merchant_id = ?4 "
			+ "order by visit_time desc limit 1",nativeQuery=true)
	int updateOrderRecord(BigDecimal orderMoney,BigDecimal profit,String ip,Long merchantId);
	
	/**
	 * 查询ips统计结果集(前100条记录)
	 * visitCount 访问次数
	 * count 登陆次数
	 * domain 发布站域名
	 * orderCount 订单数量
	 * orderMoney 下单金额
	 * profit 订单利润
	 * visitDate 访问日期
	 * @return
	 */
	@Query(value="select "
			+ "id,"
			+ "ifnull(count(id),0) as visitCount,"
			+ "ifnull(sum(count),0) as count,"
			+ "domain,"
			+ "ifnull(sum(order_count),0) as orderCount,"
			+ "ifnull(sum(order_money),0.00) as orderMoney,"
			+ "ifnull(sum(profit),0.00) as profit,"
			+ "visit_date as visitDate "
			+ "from cy_visit "
			+ "where merchant_id = ?1 "
			+ "and visit_date between ?2 and ?3 "
			+ "group by domain "
			+ "order by orderMoney desc "
			+ "limit ?4",nativeQuery=true)
	List<Map<String,Object>> findVisitList(Long merchantId,Date startDate,Date endDate,Integer pageSize);
	
	/**
	 * ips 自行输入统计
	 * @param startDate
	 * @param endDate
	 * @param merchantId
	 * @return
	 */
	@Query(value="select "
			+ "id,COALESCE(sum(visitCount),0) as visitCount,COALESCE(sum(count),0) as count,"
			+ "COALESCE(domain,'自行输入') as domain,COALESCE(orderCount,0) as orderCount,orderMoney,profit,visitDate from("
			+ "select "
			+ "dl.id,"
			+ "dl.merchant_id as merchantId,"
			+ "dl.self_count as visitCount,"
			+ "dl.count as count,"
			+ "'自行输入' as domain,"
			+ "ifnull(count(o.id),0) as orderCount,"
			+ "ifnull(sum(o.pay_amount),0.00) as orderMoney,"
			+ "ifnull(sum(o.merchant_profit),0.00) as profit,"
			+ "dl.dl_date as visitDate "
			+ "from cy_denglu dl "
			+ "left join cy_order o "
			+ "on o.merchant_id = dl.merchant_id "
			+ "and not exists("
			+ "select 1 from cy_visit where visit_date between ?1 and ?2 and merchant_id = ?3 and o.player_ip = cy_visit.ips"
			+ ")"
			+ "where (o.state = 1 or o.state = 2) "
			+ "and o.order_date between ?1 and ?2 "
			+ "and o.merchant_id = ?3 "
			+ "group by dl.id,o.merchant_id)T where merchantId = ?3 and visitDate between ?1 and ?2",nativeQuery=true)
	Map<String,Object> findSelfVistList(Date startDate,Date endDate,Long merchantId);
	
	@Transactional
	@Modifying
	@Query(value = "delete from cy_visit where visit_date < ?1",nativeQuery = true)
	int deleteVisitByDate(Date date);
	
	@Query(value = "select count(1) from cy_visit",nativeQuery = true)
	Integer ipsCount();
}
