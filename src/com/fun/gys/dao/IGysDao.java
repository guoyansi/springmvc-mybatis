package com.fun.gys.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.fun.gys.bean.GysBean;


@Repository
public interface IGysDao {
	int insertRole(GysBean role) throws Exception;
	int updateRole(GysBean role) throws Exception;
	int deleteRole(int id) throws Exception;
	List<GysBean> getRole() throws Exception;
	GysBean getRoleById(int id) throws Exception;
	List<GysBean> findRoles(String roleName) throws Exception;
}
