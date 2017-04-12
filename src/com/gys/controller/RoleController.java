package com.gys.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.gys.pojo.RoleBean;
import com.gys.service.IRoleService;

@Controller
public class RoleController {
	@Autowired
	private IRoleService iRoleService;
	
	@RequestMapping("/role/getRole")
	public RoleBean getRole(@RequestParam("id") int id){
		long start=System.currentTimeMillis();
		RoleBean role=iRoleService.getRole(id);
		long end=System.currentTimeMillis();
		System.out.println(end-start);
		return role;
	}
}
