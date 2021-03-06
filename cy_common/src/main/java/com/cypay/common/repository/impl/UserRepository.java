package com.cypay.common.repository.impl;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.cypay.common.entity.User;
import com.cypay.common.repository.BaseRepository;

@Repository
public interface UserRepository extends BaseRepository<User, Long> {

	/**
	 * 根据用户名查询用户
	 * @param username
	 * @return
	 */
	@Override
	@Query(value = "SELECT u FROM User u WHERE u.username = ?1")
	User findByAccount(String username);

	/**
	 * 开启/关闭用户
	 * @param id
	 * @return
	 */
	@Transactional
	@Query(value = "UPDATE cy_user SET state = CASE WHEN  state=0 then 1 "
			+ "when state=1 then 0 else 0 end WHERE id=?1", nativeQuery = true)
	@Modifying
	int updateState(Long id);
}
