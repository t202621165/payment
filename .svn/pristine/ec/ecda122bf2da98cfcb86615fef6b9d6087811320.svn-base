package com.cypay.common.repository.impl;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.cypay.common.entity.Merchant;
import com.cypay.common.entity.Order;
import com.cypay.common.entity.Partition;
import com.cypay.common.repository.BaseRepository;
import com.cypay.common.vo.OrderVo;
import com.cypay.common.vo.ReissueRecordVo;

import cn.hutool.core.date.DateTime;

@Repository
public interface OrderRepository extends BaseRepository<Order, Long> {
	/**
	 * 订单详情
	 * @param id
	 * @return
	 */
	@Query(value = "select "
			+ "new com.cypay.common.vo.OrderVo(o.orderNumber,o.supNumber,o.playerQQ,o.merchant.account,"
			+ "o.partition.name,o.playerAccount,o.product.name,o.orderDate,"
			+ "o.payDate,o.amount,o.payAmount,o.giveAmount,o.redPacketAmount,rr.rate,gr.rate,o.merchantProfit,o.platformProfit,"
			+ "o.gallery.name,o.state,o.playerIp,o.remarks,t.ratio,o.tailRate,o.discription) "
			+ "from Order o "
			+ "inner join o.merchant m " 
			+ "inner join m.rank r "
			+ "inner join RankRate rr on rr.rank = r "
			+ "left join o.partition p "
			+ "left join p.template t "
			+ "inner join GalleryRate gr on gr.gallery = o.gallery "
			+ "and gr.product = o.product "
			+ "and o.orderNumber = ?1 group by o.id")
	OrderVo findOrderDetail(String orderNumber);
	
	@Query(value = "SELECT a.account as agencyAccount, o.pay_date AS payDate, o.sup_number AS supNumber, o.player_ip AS playerIp, "
			+ "o.pay_amount AS payAmount,o.platform_profit AS platformProfit,o.agent_profit AS agentProfit, o.player_qq AS playerQq, o.tail_rate AS tailRate, o.red_packet_amount "
			+ "AS redPacketAmount, r.rate,ar.rate as agencyRate, gr.rate gRate, t.ratio FROM cy_order o "
			+ "LEFT JOIN cy_partition p ON p.id = o.partition_id "
			+ "LEFT JOIN cy_template t ON p.template_id = t.id "
			+ "LEFT JOIN cy_merchant m ON m.id = o.merchant_id "
			+ "LEFT JOIN cy_merchant a ON a.id = o.agent_id "
			+ "LEFT JOIN cy_rank_rate r ON r.rank_id = m.rank_id AND r.product_id = o.product_id "
			+ "LEFT JOIN cy_rank_rate ar ON ar.rank_id = a.rank_id AND ar.product_id = o.product_id "
			+ "LEFT JOIN cy_gallery_rate gr ON gr.gallery_id = o.gallery_id  AND gr.product_id = o.product_id WHERE o.id = ?1", nativeQuery = true)
	Map<String, Object> findOrderDetail(Long id);
	
	/**
	 * 查询订单详细信息
	 * @param id
	 * @return
	 */
	@Query(value = "SELECT new com.cypay.common.vo.OrderVo(o.payDate,o.payAmount,"
			+ "o.giveAmount,o.redPacketAmount,o.playerQQ,o.playerPhone,o.playerIp,o.remarks) "
			+ "FROM Order o WHERE o.id = ?1")
	OrderVo findDetail(Long id);
	
	/**
	 * 订单交易总额 利润 成交金额汇总
	 * @param startDate
	 * @param endDate
	 * @return
	 */
	@Query(value="select new com.cypay.common.vo.OrderVo(SUM(o.amount),SUM(o.platformProfit),SUM(o.payAmount)) from "
			+ "Order o where o.orderDate between ?1 and ?2")
	OrderVo findOrderSummary(Date startDate,Date endDate);
	
	/**
	 * 订单数量
	 * @param startDate
	 * @param endDate
	 * @param state
	 * @return
	 */
	@Query(value="select new com.cypay.common.vo.OrderVo(COUNT(o.id)) from "
			+ "Order o "
			+ "where o.orderDate between ?1 and ?2 "
			+ "and o.state = ?3")
	OrderVo findOrderCount(Date startDate,Date endDate,Integer state);
	
	/**
	 * 根据订单号查询订单
	 * @param orderNumber
	 * @return
	 */
	Order findByOrderNumber(String orderNumber);
	
	/**
	 * 根据分区id删除订单
	 * @param partiitonId
	 * @return
	 */
	@Transactional
	@Modifying
	@Query(value = "DELETE FROM Order o WHERE o.partition.id = ?1")
	int deleteByPartitionId(Long partiitonId);
	
	/**
	 * 根据分区Id批量删除订单
	 * @param ids
	 * @return
	 */
	@Transactional
	@Modifying
	@Query(value = "DELETE FROM Order o WHERE o.partition.id IN(?1)")
	int deleteByPartitionIds(List<Long> ids);

	/**
	 * 根据商户删除订单
	 * @param merchant
	 * @return
	 */
	@Transactional
	@Modifying
	@Query(value = "DELETE FROM Order o WHERE o.merchant = ?1")
	int deleteByMerchant(Merchant merchant);
	
	/**
	 * 订单补发-查询等待发送订单信息
	 * @param id
	 * @param merchant
	 * @return
	 */
	@Query(value = "SELECT new com.cypay.common.vo.ReissueRecordVo(o.orderNumber, o.payAmount, o.playerAccount, "
			+ "o.product.id, o.partition.id) FROM Order o WHERE o.id = ?1 AND o.merchant = ?2 AND o.state = 2")
	ReissueRecordVo findReissueRecordById(Long id, Merchant merchant);
	
	/**
	 * 整区补发-查询支付成功订单
	 * @param startDate
	 * @param endDate
	 * @param partition
	 * @param merchant
	 * @return
	 */
	@Query(value = "SELECT new com.cypay.common.vo.ReissueRecordVo(o.orderNumber, o.payAmount, o.playerAccount, "
			+ "o.product.id, o.partition.id) FROM Order o WHERE o.orderDate >= ?1 AND o.orderDate <= ?2 AND "
			+ "o.partition = ?3 AND o.merchant = ?4 AND o.state  = 1")
	List<ReissueRecordVo> findReissueRecord(Date startDate, Date endDate, Partition partition, Merchant merchant);

	/**
	 * 更新订单状态
	 * @param state
	 * @param id
	 * @return
	 */
	@Transactional
	@Modifying
	@Query(value = "UPDATE cy_order SET state = ?1 WHERE id = ?2", nativeQuery = true)
	int updateState(Integer state, Long id);

	
	@Transactional
	@Query(value = "select player_qq as qq from cy_order where order_date between ?1 and ?2 "
			+ "and player_qq is not null and player_qq != ''",nativeQuery = true)
	List<String> findQQByDate(Date startDate,Date endDate);


	@Transactional
	@Modifying
	@Query(value = "UPDATE cy_order SET state = 1, give_amount = ?2, red_packet_amount = ?3, remarks = ?4 "
			+ "WHERE order_number = ?1", nativeQuery = true)
	int updateOrderRemarks(String orderNumber, BigDecimal giveAmount, BigDecimal redPacketAmount, String remarks);
	
	@Transactional
	@Modifying
	@Query(value = "DELETE FROM Order o WHERE o.orderDate between ?1 and ?2")
	int deleteOrderByDate(Date startDate,Date endDate);

	@Query(value = "SELECT SUM(o.merchantProfit) FROM Order o WHERE o.merchant = ?1 AND o.orderDate BETWEEN ?2 AND ?3 AND o.state IN(1, 2)")
	BigDecimal getTodayOrderMerchantProfit(Merchant merchant, DateTime start, Date end);

}
