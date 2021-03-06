package com.cypay.common.repository.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.cypay.common.entity.Role;
import com.cypay.common.repository.BaseRepository;

@Repository
public interface RoleRepository extends BaseRepository<Role, Long> {
	/**
	 * 开启/关闭角色
	 * @param id
	 * @return
	 */
	@Transactional
	@Query(value = "UPDATE cy_role SET state = CASE WHEN  state=0 then 1 "
			+ "when state=1 then 0 else 0 end WHERE id=?1", nativeQuery = true)
	@Modifying
	int updateState(Long id);
	
	@Query(value="select r from Role r where r.id in (?1)")
	List<Role> findByIds(List<Long> ids);
	
	@Query(value = "select r.mark from cy_role r inner join cy_role_user cru on "
			+ "r.id = cru.role_id and cru.user_id = ?1",nativeQuery = true)
	String findRoleMarkByUserId(Long id);
}
