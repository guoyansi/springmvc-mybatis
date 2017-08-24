package com.gys.sm.fun.demo.service;

import java.util.List;

import com.gys.sm.fun.demo.bean.Grade;
import com.gys.sm.fun.demo.bean.GysBean;
import com.gys.sm.fun.demo.bean.Student;


public interface IGysDemoService {
	int insertRole(GysBean role) throws Exception;
	int updateRole(GysBean role) throws Exception;
	int deleteRole(GysBean role) throws Exception;
	GysBean getRoleById(Integer id) throws Exception;
	List<GysBean> getRole() throws Exception;
	List<GysBean> findRoles(String roleName) throws Exception;
	List<GysBean> findRoleByMultParam(int id,String roleName) throws Exception;
	List<Student> getStudentList () throws Exception;
	List<Student> getStudentList1 () throws Exception;
}
