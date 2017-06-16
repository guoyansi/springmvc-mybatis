package com.fun.gys.service;

import java.util.List;

import com.fun.gys.bean.GysBean;


public interface IGysService {
	int insertRole(GysBean role) throws Exception;
	int updateRole(GysBean role) throws Exception;
	int deleteRole(GysBean role) throws Exception;
	GysBean getRoleById(Integer id) throws Exception;
	List<GysBean> getRole() throws Exception;
	List<GysBean> findRoles(String roleName) throws Exception;
}
