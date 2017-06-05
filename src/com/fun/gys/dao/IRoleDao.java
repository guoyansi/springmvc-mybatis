package com.fun.gys.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.fun.gys.bean.RoleBean;


@Repository
public interface IRoleDao {
	int insertRole(RoleBean role);
	int updateRole(RoleBean role);
	int deleteRole(RoleBean role);
	RoleBean getRole(Integer id);
	List<RoleBean> findRoles(String roleName);
}
