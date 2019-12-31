package com.cypay.common.repository.impl;

import java.util.Date;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.cypay.common.entity.SettleMentReply;
import com.cypay.common.repository.BaseRepository;
import com.cypay.common.vo.SettleMentReplyVo;
@Repository
public interface SettleMentReplyRepository extends BaseRepository<SettleMentReply,Long>{
	
	/**
	 * 根据id更新状态
	 * @param state
	 * @param id
	 * @return
	 */
	@Transactional
	@Modifying
	@Query("update SettleMentReply smr set smr.state = ?1 where smr.id = ?2")
	int updateStateById(Boolean state,Long id);
	
	@Query(value="select new com.cypay.common.vo.SettleMentReplyVo(sum(sm.amount)) from SettleMent sm inner join SettleMentReply smr "
			+ "on sm.settleMentReply.id = smr.id and "
			+ "smr.replyDate between ?1 and ?2")
	SettleMentReplyVo findTotalAmount(Date startDate,Date endDate);
	
	SettleMentReply findBySerialNumber(String serialNumber);
}
