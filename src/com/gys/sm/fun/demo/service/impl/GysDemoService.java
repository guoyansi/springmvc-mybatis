package com.gys.sm.fun.demo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gys.sm.fun.demo.bean.GysBean;
import com.gys.sm.fun.demo.dao.IGysDemoDao;
import com.gys.sm.fun.demo.service.IGysDemoService;

@Service
public class GysDemoService implements IGysDemoService{
	@Autowired
	private IGysDemoDao IGysDemoDao;
	
	//@Transactional(propagation=Propagation.REQUIRED)
	@Override
	public int insertRole(GysBean role) throws Exception {
		int num= IGysDemoDao.insertRole(role);
		int c=0;
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
		// TODO Auto-generated method stub
		return 0;
	}
	//@Transactional(propagation=Propagation.SUPPORTS)
	@Override
	public List<GysBean> getRole() throws Exception{
		return IGysDemoDao.getRole();
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
}
