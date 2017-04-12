package com.gys.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.gys.pojo.RoleBean;

@Repository
public interface IRoleDao {
	int insertRole(RoleBean role);
	int updateRole(RoleBean role);
	int deleteRole(RoleBean role);
	RoleBean getRole(Integer id);
	List<RoleBean> findRoles(String roleName);
}
