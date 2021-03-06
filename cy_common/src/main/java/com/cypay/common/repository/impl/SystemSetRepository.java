package com.cypay.common.repository.impl;

import java.math.BigDecimal;
import java.util.Map;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.cypay.common.entity.SystemSet;
import com.cypay.common.repository.BaseRepository;

@Repository
public interface SystemSetRepository extends BaseRepository<SystemSet, Long> {

	Optional<SystemSet> findByMark(String mark);

	@Query(value = "SELECT game_engine FROM cy_system_set WHERE mark = ?1", nativeQuery = true)
	String findGameEngineByMark(String mark);
	
	@Query(value = "SELECT settlement_bank FROM cy_system_set WHERE mark = ?1", nativeQuery = true)
	String findSettlementBankByMark(String mark);
	
	@Query(value = "SELECT version FROM cy_system_set WHERE mark = ?1",nativeQuery = true)
	String findVersionByMark(String mark);
	
	@Query(value = "SELECT ty_version FROM cy_system_set WHERE mark = ?1",nativeQuery = true)
	String findTyVersionByMark(String mark);
	
	@Query(value = "SELECT cq3version FROM cy_system_set WHERE mark = ?1",nativeQuery = true)
	String findCq3VersionByMark(String mark);
	
	@Query(value = "select is_open_tail_amount from cy_system_set where mark = ?1",nativeQuery = true)
	Boolean findIsOpenTailAmount(String mark);
	
	@Query(value = "select tail_amount_scope from cy_system_set where mark = ?1",nativeQuery = true)
	Double findTailAmountScope(String mark);
	
	@Query(value = "select tail_amount_ratio from cy_system_set where mark = ?1 and is_open_tail_amount = 1",nativeQuery = true)
	int findTailAmountRatio(String mark);
	
	@Query(value="select visit_time from cy_system_set where mark = ?1",nativeQuery = true)
	int findVisitTimeByMark(String mark);
	
	@Query(value="select login_time from cy_system_set where mark = ?1",nativeQuery = true)
	int findLoginTimeByMark(String mark);
	
	@Query(value="select is_ips as isIps, is_login as isLogin from cy_system_set where mark = ?1",nativeQuery = true)
	Map<String, Object> findIpsAndLoginState(String mark);
	
	@Query(value="select count(id) < (select task_count from cy_system_set where mark = ?1) "
			+ "from cy_scheduler_job where merchant_id = ?2 and state = 0",nativeQuery = true)
	int findTaskCount(String mark, Long merchantId);
	
	@Transactional
	@Modifying
	@Query(value = "update cy_system_set set version = ?1 where mark = ?2",nativeQuery = true)
	int updateVersionByMark(String version,String mark);
	
	@Transactional
	@Modifying
	@Query(value = "update cy_system_set set ty_version = ?1 where mark = ?2",nativeQuery = true)
	int updateTyVersionByMark(String version,String mark);
	
	@Transactional
	@Modifying
	@Query(value = "update cy_system_set set cq3version = ?1 where mark = ?2",nativeQuery = true)
	int updateCq3VersionByMark(String version,String mark);
	
	@Transactional
	@Modifying
	@Query(value="update cy_system_set set is_ips = ?1 where mark = ?2",nativeQuery = true)
	int updateIsIps(Boolean state,String mark);
	
	@Transactional
	@Modifying
	@Query(value="update cy_system_set set is_login = ?1 where mark = ?2",nativeQuery = true)
	int updateIsLogin(Boolean state,String mark);
	
	@Transactional
	@Modifying
	@Query(value = "update cy_system_set set is_open_tail_amount = ?1 where mark = ?2",nativeQuery = true)
	int updateIsOpenTailAmount(Boolean state,String mark);
	
	@Query(value="select new com.cypay.common.entity.SystemSet(s.registerState, s.settlementType,s.defaultFee) from SystemSet s where s.mark = ?1")
	SystemSet findRegisterData(String mark);
	
	@Query(value = "SELECT new com.cypay.common.entity.SystemSet(s.webName,s.servicePhone,s.copyright,"
			+ "s.companyAddress,s.feeStandard,s.about,s.serviceQQ) FROM SystemSet s WHERE s.mark = ?1")
	SystemSet findWebInfo(String mark);
	
	@Transactional
	@Modifying
	@Query(value = "update cy_system_set set visit_time = ?1 where mark = ?2",nativeQuery = true)
	int updateVisitTime(int time,String mark);
	
	@Transactional
	@Modifying
	@Query(value = "update cy_system_set set login_time = ?1 where mark = ?2",nativeQuery = true)
	int updateLoginTime(int time,String mark);

	@Transactional
	@Modifying
	@Query(value = "update cy_system_set set settlement_type = ?1 where mark = ?2",nativeQuery = true)
	int updateSettlementType(Integer settlementType, String mark);

	@Transactional
	@Modifying
	@Query(value = "update cy_system_set set register_state = ?1 where mark = ?2",nativeQuery = true)
	int updateRegisterState(Integer registerState, String mark);

	@Query(value = "select t1min_amount from cy_system_set where mark = ?1",nativeQuery = true)
	BigDecimal findT1MinAmount(String mark);
}
