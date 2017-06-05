package com.fun.gys.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.fun.gys.bean.RoleBean;
import com.fun.gys.service.IRoleService;
import com.item.constant.ReturnRes;
import com.item.util.Tool;


@Controller
@RequestMapping("/role")
public class RoleController {
	@Autowired
	private IRoleService iRoleService;
	
	@RequestMapping("/page")
	public ModelAndView goPage(ModelAndView view){
		Map<String, Object> map=ReturnRes.getMap();
		ReturnRes.addResToMap(map, "返回成功");
		try {
			/*RoleBean role=new RoleBean();
			role.setRoleName("roleName12");
			role.setNote("Note3423");
			int i=iRoleService.insertRole(role);
			System.out.println("影响行数:>>>>>>>>>>>"+i);*/
			view.setViewName("role");
		} catch (Exception e) {
			e.printStackTrace();
		}
		view.addObject("res",map);
		return view;
	}
	
	@RequestMapping("/getRole")
	public RoleBean getRole(@RequestParam("id") int id){
		long start=System.currentTimeMillis();
		RoleBean role=iRoleService.getRole(id);
		long end=System.currentTimeMillis();
		System.out.println(end-start);
		return role;
	}
}
