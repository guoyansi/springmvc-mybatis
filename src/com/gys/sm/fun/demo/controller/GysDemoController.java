package com.gys.sm.fun.demo.controller;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import net.sf.json.JSONObject;

import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.servlet.ModelAndView;

import sun.management.resources.agent;

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
	
	@ResponseBody
	@RequestMapping(value = "/uploadM2", method = RequestMethod.POST)
	public String doUploadFile1(@RequestParam("files") CommonsMultipartFile[] files,HttpServletRequest request)
			throws IOException {
				//List<Map<String,String>> list=new ArrayList<Map<String,String>>();
				List<String> list=new ArrayList<String>();
				for(CommonsMultipartFile file:files){
					String oldFileName=file.getOriginalFilename();
					System.out.println("文件名:" + oldFileName);
					//String dex = oldFileName.substring(oldFileName.lastIndexOf(".")).toLowerCase();
					//String curProjectPath=request.getServletContext().getRealPath("/");
					String saveDirectoryPath = request.getContextPath() + "/upload/";
					File saveFile=new File(saveDirectoryPath);
					if(!saveFile.exists()&&!saveFile.isDirectory()){
						saveFile.mkdir();
					}
					//String newFileName=UUID.randomUUID()+dex;
					File pathFile=new File(saveDirectoryPath, oldFileName);
					FileUtils.copyInputStreamToFile(file.getInputStream(),pathFile);
					String newPath=saveDirectoryPath+oldFileName;
					list.add(newPath);
				}
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("status", 1);
			map.put("msg", "success");
			map.put("list", list);
			//返回字符串,返回map会有低版本的ie兼容问题
			return JSONObject.fromObject(map).toString();
	}
	
	@ResponseBody
	@RequestMapping("/ajaxHttp1")
	public Map<String, Object> ajaxHttp1(@RequestBody JSONObject json){
		Map<String, Object> map=ReturnRes.getMap();
		try {
			String name=json.getString("name");
			int age=json.getInt("age");
			System.out.println("name:"+name+";age:"+age);
			ReturnRes.addResToMap(map, ReturnRes.success, "请求成功");
			map.put("name", name);
			map.put("age", age);
		} catch (Exception e) {
			e.printStackTrace();
		}
			return map;
	}
	
	@ResponseBody
	@RequestMapping("/ajaxHttp2")
	public String ajaxHttp2(@RequestBody JSONObject json){
		Map<String, Object> map=ReturnRes.getMap();
		try {
			String name=json.getString("name");
			int age=json.getInt("age");
			System.out.println("name:"+name+";age:"+age);
			ReturnRes.addResToMap(map, ReturnRes.success, "请求成功");
			map.put("name", name);
			map.put("age", age);
		} catch (Exception e) {
			e.printStackTrace();
		}
		String res=JSONObject.fromObject(map).toString();
		System.out.println(res);
		return res;
	}
}
