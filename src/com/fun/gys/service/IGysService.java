package com.fun.gys.service;

import java.util.List;

import com.fun.gys.bean.GysBean;


public interface IGysService {
	int insertRole(GysBean role);
	int updateRole(GysBean role);
	int deleteRole(GysBean role);
	GysBean getRole(Integer id);
	List<GysBean> findRoles(String roleName);
}
