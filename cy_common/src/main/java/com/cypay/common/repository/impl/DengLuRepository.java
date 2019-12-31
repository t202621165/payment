package com.cypay.common.repository.impl;

import java.util.Date;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.cypay.common.entity.DengLu;
import com.cypay.common.repository.BaseRepository;
@Repository
public interface DengLuRepository extends BaseRepository<DengLu,Long>{
	/**
	 * 保存或更新自行输入访问记录
	 * @param count
	 * @param date
	 * @param time
	 * @param merchantId
	 * @param ips
	 * @param selfCount
	 * @return
	 */
	@Transactional
	@Modifying
	@Query(value="INSERT INTO cy_denglu(count,dl_date,dl_time,v_time,merchant_id,ips,self_count)values(?1,?2,DATE_SUB(NOW(),INTERVAL 30 minute),?3,?4,?5,?6) ",nativeQuery=true)
	int saveSelfVisit(Long count,Date date,Date time,Long merchantId,String ips,Long selfCount);
	
	@Transactional
	@Modifying
	@Query(value="update cy_denglu set self_count = self_count + 1,v_time = ?1 "
			+ "where dl_date = ?2 and merchant_id = ?3 and ips = ?4",nativeQuery=true)
	int updateSelfVisit(String time,String date,Long merchantId,String ips);
	
	
	/**
	 * 保存或更新自行登陆记录
	 * @param count
	 * @param date
	 * @param time
	 * @param merchantId
	 * @param ips
	 * @param selfCount
	 * @return
	 */
	@Transactional
	@Modifying
	@Query(value="INSERT INTO cy_denglu(count,dl_date,dl_time,merchant_id,ips,self_count,v_time)values(?1,?2,?3,?4,?5,?6,DATE_SUB(NOW(),INTERVAL 30 minute ))",nativeQuery=true)
	int saveSelfCount(Long count,Date date,Date time,Long merchantId,String ips,Long selfCount);
	
	@Transactional
	@Modifying
	@Query(value = "update cy_denglu set count = count + 1,dl_time = ?1 "
			+ "where dl_date = ?2 and merchant_id = ?3 and ips = ?4",nativeQuery = true)
	int updateSelfCount(String time,String date,Long merchantId,String ips);
	
	/**
	 * 查询最新登陆记录的时间
	 * @param merchantId
	 * @param ip
	 * @param date
	 * @return
	 */
	@Query(value="select dl.dl_time as dlTime from cy_denglu dl "
			+ "where dl.merchant_id = ?1 "
			+ "and dl.ips = ?2 "
			+ "and dl.dl_date = ?3 "
			+ "order by dl.dl_time desc limit 1",nativeQuery=true)
	Date findCurrentDengLuTime(Long merchantId,String ip,String date);
	
	/**
	 * 查询最新访问记录的时间
	 * @param merchantId
	 * @param ip
	 * @param date
	 * @return
	 */
	@Query(value="select dl.v_time as vTime from cy_denglu dl "
			+ "where dl.merchant_id = ?1 "
			+ "and dl.ips = ?2 "
			+ "and dl.dl_date = ?3 "
			+ "order by dl.v_time desc limit 1",nativeQuery=true)
	Date findCurrentDengLuVTime(Long merchantId,String ip,String date);
	
	@Transactional
	@Modifying
	@Query(value = "delete from cy_denglu where dl_date < ?1",nativeQuery = true)
	int deleteDengLuByDate(Date date);
	
	@Query(value = "select count(1) from cy_denglu",nativeQuery = true)
	Integer dengluCount();
}
