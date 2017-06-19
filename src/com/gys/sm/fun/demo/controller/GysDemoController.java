package com.gys.sm.fun.demo.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.gys.sm.fun.demo.bean.GysBean;
import com.gys.sm.fun.demo.service.IGysDemoService;
import com.gys.sm.item.bean.SysDictionaryBean;
import com.gys.sm.item.cache.DictionaryCache;
import com.gys.sm.item.constant.ReturnRes;

@Controller
@RequestMapping("/gysDemo")
public class GysDemoController {
	@Autowired
	private IGysDemoService iGysDemoService;
	@RequestMapping("/page")
	public ModelAndView goPage(ModelAndView view,HttpServletRequest request){
		Map<String, Object> map=ReturnRes.getMap();
		ReturnRes.addResToMap(map, "返回成功");
		try {
			GysBean bean=new GysBean();
			bean.setRoleName("roleName12");
			bean.setNote("Note3423");
			//int i=iGysDemoService.insertRole(bean);
			//System.out.println("影响行数:>>>>>>>>>>>"+i);
			List<GysBean> list=iGysDemoService.getRole();
			view.addObject("list",list);
			int id=Integer.parseInt(request.getParameter("id"));
			GysBean gys=iGysDemoService.getRoleById(id);
			view.addObject("bean",gys);
			view.setViewName("gysDemo/demo");
			List<SysDictionaryBean> beans=DictionaryCache.getDictList("1001");
			view.addObject("dictList",beans);
		} catch (Exception e) {
			e.printStackTrace();
		}
		view.addObject("res",map);
		return view;
	}
}
