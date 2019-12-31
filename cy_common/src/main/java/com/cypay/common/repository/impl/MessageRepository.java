package com.cypay.common.repository.impl;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.EntityGraph.EntityGraphType;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Repository;

import com.cypay.common.entity.Merchant;
import com.cypay.common.entity.Message;
import com.cypay.common.repository.BaseRepository;

@Repository
public interface MessageRepository extends BaseRepository<Message, Long> {

	@Override
	@EntityGraph(value = "messageWithReplies", type = EntityGraphType.FETCH)
	Page<Message> findAll(@Nullable Specification<Message> spec, Pageable pageable);
	
	@Transactional
	@Modifying
	@Query(value = "DELETE FROM Message m WHERE m.id = ?1 AND m.merchant = ?2")
	int deleteByIdAndMerchant(Long id, Merchant merchant);
	
	@Transactional
	@Modifying
	@Query(value = "DELETE FROM Message m WHERE m.id IN(?1) AND m.merchant = ?2")
	int deleteByIdsAndMerchant(List<Long> ids, Merchant merchant);

	@Transactional
	@Query(value = "UPDATE Message m SET m.state = true WHERE m.id=?1 AND m.merchant = ?2")
	@Modifying
	int updateMessageState(Long id, Merchant merchant);
	
	@Transactional
	@Query(value = "UPDATE Message m SET m.state = true WHERE m.id=?1")
	@Modifying
	int updateMessageState(Long id);

	@Transactional
	@Query(value = "UPDATE Message m SET m.isSubscribe = true, m.openid = ?2 WHERE m.id=?1")
	@Modifying
	int updateSubscribeAndOpenid(Long id, String openid);

	@EntityGraph(value = "messageWithReplies", type = EntityGraphType.FETCH)
	Optional<Message> findByIdAndMerchant(Long id, Merchant merchant);
	
	@EntityGraph(value = "messageWithReplies", type = EntityGraphType.FETCH)
	Optional<Message> findMessageRecodeById(Long msgId);

}
