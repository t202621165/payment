package com.cypay.common.repository.impl;

import java.util.Date;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.cypay.common.entity.Merchant;
import com.cypay.common.entity.MerchantLog;
import com.cypay.common.repository.BaseRepository;

@Repository
public interface MerchantLogRepository extends BaseRepository<MerchantLog, Long> {

	@Transactional
	@Modifying
	@Query(value = "DELETE FROM MerchantLog m WHERE m.merchant = ?1 AND m.dateTime < ?2")
	int deleteLog(Merchant merchant, Date beforeOrAfterDateByDate);

}
