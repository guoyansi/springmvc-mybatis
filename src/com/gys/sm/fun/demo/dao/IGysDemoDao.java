package com.gys.sm.fun.demo.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.gys.sm.fun.demo.bean.GysBean;


@Repository
public interface IGysDemoDao {
	int insertRole(GysBean role) throws Exception;
	int updateRole(GysBean role) throws Exception;
	int deleteRole(int id) throws Exception;
	List<GysBean> getRole() throws Exception;
	GysBean getRoleById(int id) throws Exception;
	List<GysBean> findRoles(String roleName) throws Exception;
	/**
	 * dao层传递多参数的情况
	 * @param id
	 * @param roleName
	 * @return
	 * @throws Exception
	 */
	List<GysBean> findRoleByMultParam(@Param("id") int id,@Param("roleName") String roleName) throws Exception;
}	
