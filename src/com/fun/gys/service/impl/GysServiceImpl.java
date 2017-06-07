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
	
	@Transactional(propagation=Propagation.REQUIRED)
	@Override
	public int insertRole(GysBean role) {
		return iGysDao.insertRole(role);
	}
	@Transactional(propagation=Propagation.REQUIRED)
	@Override
	public int updateRole(GysBean role) {
		
		return 0;
	}

	@Transactional(propagation=Propagation.REQUIRED)
	@Override
	public int deleteRole(GysBean role) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Transactional(propagation=Propagation.SUPPORTS)
	@Override
	public GysBean getRole(Integer id) {
		return iGysDao.getRole(id);
	}
	@Transactional(propagation=Propagation.SUPPORTS)
	@Override
	public List<GysBean> findRoles(String roleName) {
		return iGysDao.findRoles(roleName);
	}

}
