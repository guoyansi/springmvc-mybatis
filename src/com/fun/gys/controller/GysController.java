package com.fun.gys.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.fun.gys.bean.GysBean;
import com.fun.gys.service.IGysService;
import com.item.constant.ReturnRes;


@Controller
@RequestMapping("/gys")
public class GysController {
	@Autowired
	private IGysService iGysService;
	
	@RequestMapping("/page")
	public ModelAndView goPage(ModelAndView view,HttpServletRequest request){
		Map<String, Object> map=ReturnRes.getMap();
		ReturnRes.addResToMap(map, "返回成功");
		try {
			GysBean bean=new GysBean();
			bean.setRoleName("roleName12");
			bean.setNote("Note3423");
			int i=iGysService.insertRole(bean);
			//System.out.println("影响行数:>>>>>>>>>>>"+i);
			List<GysBean> list=iGysService.getRole();
			view.addObject("list",list);
			int id=Integer.parseInt(request.getParameter("id"));
			GysBean gys=iGysService.getRoleById(id);
			view.addObject("bean",gys);
			view.setViewName("gys/gys");
		} catch (Exception e) {
			e.printStackTrace();
		}
		view.addObject("res",map);
		return view;
	}
	
	@RequestMapping("/getRoleById")
	public GysBean getRole(@RequestParam("id") int id){
		GysBean role=null;
		try {
			long start=System.currentTimeMillis();
			role=iGysService.getRoleById(id);
			long end=System.currentTimeMillis();
			System.out.println(end-start);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return role;
	}
}
