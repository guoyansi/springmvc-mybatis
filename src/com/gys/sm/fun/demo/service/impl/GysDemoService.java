package com.gys.sm.fun.demo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gys.sm.fun.demo.bean.GysBean;
import com.gys.sm.fun.demo.bean.Student;
import com.gys.sm.fun.demo.dao.IGysDemoDao;
import com.gys.sm.fun.demo.dao.IGysDemoDao1;
import com.gys.sm.fun.demo.service.IGysDemoService;

@Service
public class GysDemoService implements IGysDemoService{
	@Autowired
	private IGysDemoDao IGysDemoDao;
	@Autowired
	private IGysDemoDao1 iGysDemoDao1;
	
	//@Transactional(propagation=Propagation.REQUIRED)
	@Override
	public int insertRole(GysBean role) throws Exception {
		int num= IGysDemoDao.insertRole(role);
		//int c=0;
		//int a=num/c;
		//iGysDao.deleteRole(role.getId());
		//num= iGysDao.insertRole(role);
		return num;
	}
	//@Transactional(propagation=Propagation.REQUIRED)
	@Override
	public int updateRole(GysBean role) throws Exception{
		
		return 0;
	}

	//@Transactional(propagation=Propagation.REQUIRED)
	@Override
	public int deleteRole(GysBean role) throws Exception{
		return 0;
	}
	//@Transactional(propagation=Propagation.SUPPORTS)
	@Override
	public List<GysBean> getRole() throws Exception{
		//return IGysDemoDao.getRole();
		return iGysDemoDao1.getRole();
	}
	//@Transactional(propagation=Propagation.SUPPORTS)
	@Override
	public GysBean getRoleById(Integer id) throws Exception{
		return IGysDemoDao.getRoleById(id);
	}
	//@Transactional(propagation=Propagation.SUPPORTS)
	@Override
	public List<GysBean> findRoles(String roleName) throws Exception{
		return IGysDemoDao.findRoles(roleName);
	}
	@Override
	public List<GysBean> findRoleByMultParam(int id, String roleName)
			throws Exception {
		return IGysDemoDao.findRoleByMultParam(id, roleName);
	}
	@Override
	public List<Student> getStudentList() throws Exception {
		return IGysDemoDao.getStudentList();
	}
	@Override
	public List<Student> getStudentList1() throws Exception {
		return IGysDemoDao.getStudentList1();
	}
	@Override
	public List<Student> getStudentList2() throws Exception {
		return IGysDemoDao.getStudentList2();
	}
	
	
}
