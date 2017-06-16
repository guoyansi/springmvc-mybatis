package com.gys.sm.fun.demo.service;

import java.util.List;

import com.gys.sm.fun.demo.bean.GysBean;


public interface IGysDemoService {
	int insertRole(GysBean role) throws Exception;
	int updateRole(GysBean role) throws Exception;
	int deleteRole(GysBean role) throws Exception;
	GysBean getRoleById(Integer id) throws Exception;
	List<GysBean> getRole() throws Exception;
	List<GysBean> findRoles(String roleName) throws Exception;
}
