package com.cypay.common.repository.impl;


import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.EntityGraph.EntityGraphType;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.cypay.common.entity.SettleMent;
import com.cypay.common.entity.SettleMentReply;
import com.cypay.common.repository.BaseRepository;
import com.cypay.common.vo.SettleMentVo;
import com.cypay.common.vo.SettlementExcel;
@Repository
public interface SettleMentRepository extends BaseRepository<SettleMent,Long>{
	
	/**
	 * 根据批复id更新结算状态
	 * @param state
	 * @param id
	 * @return
	 */
	@Transactional
	@Modifying
	@Query("update SettleMent sm set sm.state = ?1,sm.complateDate=?3 where sm.settleMentReply.id = ?2")
	int updateStateBySettlementReplyId(Integer state,Long id,Date complateDate);
	
	@Transactional
	@Modifying
	@Query("update SettleMent sm set sm.state = ?1,sm.complateDate=?3,sm.discription = ?4 where sm.id = ?2")
	int updateStateById(Integer state,Long id,Date complateDate,String discription);
	
	@Query(value="select new com.cypay.common.vo.SettleMentVo(sum(o.merchantProfit),p.typeMark) from Order o right join Product p "
			+ "on o.product.id = p.id "
			+ "and o.merchant.id = ?1 "
			+ "group by p.typeMark")
	List<SettleMentVo> findGalleryFunds(Long merchantId);
	
	/**
	 * 
	 * @param ids 结算id集合
	 * @return 返回结算集合
	 */
	@EntityGraph(value = "settleMentWithBank", type = EntityGraphType.FETCH)
	List<SettleMent> findByStateAndIdIn(Integer state, List<Long> ids);

	@Query(value = "SELECT new com.cypay.common.vo.SettleMentVo(s.id,s.amount,s.discription,"
			+ "s.serialNumber,b.bankMark,b.realName,b.bankNumber,w.openid) FROM SettleMent "
			+ "s LEFT JOIN s.bank b LEFT JOIN WechatInfo w On w.merchantId = s.merchant.id "
			+ "WHERE s.state = ?1 AND s.id IN(?2)")
	List<SettleMentVo> findPayeeRecords(int state, List<Long> ids);

	@Transactional
	@Modifying
	@Query(value = "UPDATE SettleMent s SET s.settleMentReply = ?1, s.state = ?2 WHERE s.id IN(?3)")
	int updateByIds(SettleMentReply reply, Integer state, List<Long> ids);

	@Transactional
	@Modifying
	@Query(value = "UPDATE SettleMent s SET s.state = ?2 WHERE s.id IN(?1)")
	int updateStateByIds(List<Long> ids, Integer state);

	@Query(value = "SELECT new com.cypay.common.vo.SettlementExcel(s.serialNumber, s.applyDate, m.nickname, "
			+ "s.amount, s.cost, b.realName, b.bankName, b.bankNumber, b.bankBranch, s.discription, s.complateDate) from "
			+ "SettleMent s left join s.bank b left join s.merchant m where s.settleMentReply.id = ?1")
	List<SettlementExcel> findBySettleMentReplyId(Long id);
	
	@Transactional
	@Modifying
	@Query(value = "DELETE from SettleMent sm where sm.applyDate between ?1 and ?2 and sm.state = 1")
	int deleteSettleMentByDate(Date startDate,Date endDate);
	
	@Query(value = "select sum(sm.amount) as totalAmount,sum(sm.cost) as totalFee from cy_settle_ment sm where sm.state = ?1",nativeQuery = true)
	Map<String,BigDecimal> findByTotalAmountByState(Integer state);
	
	SettleMent findBySerialNumber(String serialNumber);
	
}