package com.fun.gys.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.fun.gys.bean.GysBean;
import com.fun.gys.dao.IGysDao;
import com.fun.gys.service.IGysService;


@Service
public class GysServiceImpl implements IGysService{

	@Autowired
	private IGysDao iGysDao;
	
	//@Transactional(propagation=Propagation.REQUIRED)
	@Override
	public int insertRole(GysBean role) throws Exception {
		int num= iGysDao.insertRole(role);
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
		return iGysDao.getRole();
	}
	//@Transactional(propagation=Propagation.SUPPORTS)
	@Override
	public GysBean getRoleById(Integer id) throws Exception{
		return iGysDao.getRoleById(id);
	}
	//@Transactional(propagation=Propagation.SUPPORTS)
	@Override
	public List<GysBean> findRoles(String roleName) throws Exception{
		return iGysDao.findRoles(roleName);
	}

}
