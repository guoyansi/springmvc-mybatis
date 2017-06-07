package com.fun.gys.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.fun.gys.bean.GysBean;


@Repository
public interface IGysDao {
	int insertRole(GysBean role);
	int updateRole(GysBean role);
	int deleteRole(GysBean role);
	GysBean getRole(Integer id);
	List<GysBean> findRoles(String roleName);
}
