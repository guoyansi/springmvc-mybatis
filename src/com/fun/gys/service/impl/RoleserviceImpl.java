package com.fun.gys.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.fun.gys.bean.RoleBean;
import com.fun.gys.dao.IRoleDao;
import com.fun.gys.service.IRoleService;


@Service
public class RoleserviceImpl implements IRoleService{

	@Autowired
	private IRoleDao iRoleDao;
	
	@Transactional(propagation=Propagation.REQUIRED)
	@Override
	public int insertRole(RoleBean role) {
		return iRoleDao.insertRole(role);
	}
	@Transactional(propagation=Propagation.REQUIRED)
	@Override
	public int updateRole(RoleBean role) {
		
		return 0;
	}

	@Transactional(propagation=Propagation.REQUIRED)
	@Override
	public int deleteRole(RoleBean role) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Transactional(propagation=Propagation.SUPPORTS)
	@Override
	public RoleBean getRole(Integer id) {
		return iRoleDao.getRole(id);
	}
	@Transactional(propagation=Propagation.SUPPORTS)
	@Override
	public List<RoleBean> findRoles(String roleName) {
		return iRoleDao.findRoles(roleName);
	}

}
