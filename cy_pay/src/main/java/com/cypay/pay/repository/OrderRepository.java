package com.cypay.pay.repository;

import java.math.BigDecimal;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.cypay.common.entity.Order;
import com.cypay.common.repository.BaseRepository;
import com.cypay.pay.vo.NotifyVo;
import com.cypay.pay.vo.ReturnVo;

@Repository("pOrderRepository")
public interface OrderRepository extends BaseRepository<Order, Long> {
	
	@Query(value = "SELECT new com.cypay.pay.vo.NotifyVo(o.id, o.orderDate, m.id, a.id, o.product.id, o.partition.id, o.playerIp, "
			+ "o.playerAccount, gr.rate, r.rate, rr.rate, o.state, COALESCE(gr.gallery.md5Key, gr.gallery.privateKey), "
			+ "m.uuid,o.amount,o.tailAmount) FROM Order o INNER JOIN o.merchant m LEFT JOIN GalleryRate gr ON gr.product = o.product AND "
			+ "gr.gallery = o.gallery LEFT JOIN RankRate r ON r.product = o.product AND r.rank = m.rank LEFT JOIN "
			+ "o.agent a LEFT JOIN RankRate rr ON rr.product = o.product AND rr.rank = a.rank WHERE o.orderNumber = ?1")
	NotifyVo findNotifyData(String orderNumber);
	
	@Query(value = "SELECT new com.cypay.pay.vo.ReturnVo(o.orderNumber, o.payAmount, o.tailAmount, o.product.name, o.partition.name, "
			+ "o.playerAccount, o.state, COALESCE(g.md5Key, g.privateKey), m.serviceQQ, m.servicePhone, o.remarks) FROM "
			+ "Order o INNER JOIN o.merchant m LEFT JOIN o.gallery g WHERE o.orderNumber = ?1")
	ReturnVo findReturnData(String orderNumber);

	@Transactional
	@Modifying
	@Query(value = "UPDATE Order o SET o.payDate = now(), o.state = 2, o.payAmount = ?2, o.supNumber = ?3, "
			+ "o.merchantProfit = ?4, o.platformProfit = ?5, o.agentProfit = ?6, o.tailRate = ?7,o.tailAmountProfit = ?8, o.version = 1 WHERE o.id = ?1 "
			+ "AND o.version = 0 AND o.state = 0")
	int updateOrderAmountAndProfit(Long orderId, BigDecimal payAmount, String supNumber, BigDecimal merchantProfit,
			BigDecimal platformProfit, BigDecimal agentProfit, BigDecimal tailRate,BigDecimal tailAmountProfit);

	@Query(value = "SELECT COUNT(o.id) FROM Order o WHERE o.orderNumber = ?1 AND o.state IN(1, 2)")
	Long countByOrderNumber(String orderNumber);

	Order findByOrderNumber(String orderNumber);
}
