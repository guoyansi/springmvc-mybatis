package com.fun.gys.service;

import java.util.List;

import com.fun.gys.bean.RoleBean;


public interface IRoleService {
	int insertRole(RoleBean role);
	int updateRole(RoleBean role);
	int deleteRole(RoleBean role);
	RoleBean getRole(Integer id);
	List<RoleBean> findRoles(String roleName);
}
