package com.gys.sm.fun.demo.controller;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.gys.sm.fun.demo.bean.GysBean;
import com.gys.sm.fun.demo.bean.Student;
import com.gys.sm.fun.demo.result.List3Result;
import com.gys.sm.fun.demo.service.IGysDemoService;
import com.gys.sm.fun.demo.service.impl.GysServiceImpl;
import com.gys.sm.item.bean.SysDictionaryBean;
import com.gys.sm.item.cache.DictionaryCache;
import com.gys.sm.item.constant.ReturnRes;
import com.gys.sm.item.ex.MyException;

@Controller
@RequestMapping("/gysDemo")
public class GysDemoController {
	/**
	 * 日志打印
	 */
	private static Logger logger=Logger.getLogger(GysDemoController.class);
	
	@Autowired
	private IGysDemoService iGysDemoService;
	@Autowired
	private GysServiceImpl si;
	
	@RequestMapping("/page")
	public ModelAndView goPage(ModelAndView view,HttpServletRequest request,String html){
		
		String curProjectPath=request.getServletContext().getRealPath("/upload");
		System.out.println("curProjectPath:"+curProjectPath);
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
			String ids=request.getParameter("id");
			int id=0;
			if(ids==null){
				id=2;
			}else{
				id=Integer.parseInt(ids);
			}
			GysBean gys=iGysDemoService.getRoleById(id);
			view.addObject("bean",gys);
			view.setViewName("gysDemo/demo");
			List<SysDictionaryBean> beans=DictionaryCache.getDictList("1001");
			view.addObject("dictList",beans);
			view.addObject("htmlTag",html);
		} catch (Exception e) {
			e.printStackTrace();
		}
		view.addObject("res",map);
		return view;
	}
	/**
	 * 多个上传
	 * @param files
	 * @param request
	 * @return
	 * @throws IOException
	 */
	@ResponseBody
	@RequestMapping(value = "/uploadM2", method = RequestMethod.POST)
	public String doUploadFile2(@RequestParam("files") CommonsMultipartFile[] files,HttpServletRequest request)
			throws IOException {
				//List<Map<String,String>> list=new ArrayList<Map<String,String>>();
				List<String> list=new ArrayList<String>();
				for(CommonsMultipartFile file:files){
					String oldFileName=file.getOriginalFilename();
					System.out.println("文件名:" + oldFileName);
					//String dex = oldFileName.substring(oldFileName.lastIndexOf(".")).toLowerCase();
					String curProjectPath=request.getServletContext().getRealPath("/upload");
					System.out.println("curProjectPath:"+curProjectPath);
					//String saveDirectoryPath = request.getContextPath() + "/upload/";
					File saveFile=new File(curProjectPath);
					if(!saveFile.exists()&&!saveFile.isDirectory()){
						saveFile.mkdir();
					}
					//String newFileName=UUID.randomUUID()+dex;
					File pathFile=new File(curProjectPath, oldFileName);
					FileUtils.copyInputStreamToFile(file.getInputStream(),pathFile);
					String saveDirectoryPath = request.getContextPath() + "/upload/";
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
	/**
	 * 单个上传
	 * @param file
	 * @param request
	 * @return
	 * @throws IOException
	 */
	@ResponseBody
	@RequestMapping(value = "/uploadM1", method = RequestMethod.POST)
	public String doUploadFile1(@RequestParam("file") CommonsMultipartFile file,HttpServletRequest request)
			throws IOException {
			Map<String, Object> map=ReturnRes.getMap();
			String oldFileName=file.getOriginalFilename();
			//System.out.println("文件名:" + oldFileName);
			//扩展名
			//String dex = oldFileName.substring(oldFileName.lastIndexOf(".")).toLowerCase();
			//绝对路径
			String curProjectPath=request.getServletContext().getRealPath("/upload");
			
			File saveFile=new File(curProjectPath);
			if(!saveFile.exists()&&!saveFile.isDirectory()){
				saveFile.mkdir();
			}
			//String newFileName=UUID.randomUUID()+dex;
			File pathFile=new File(curProjectPath, oldFileName);
			if(!file.isEmpty()){
				FileUtils.copyInputStreamToFile(file.getInputStream(),pathFile);
			}else{
				logger.info("上传数据为空.......");
				ReturnRes.addResToMap(map, "上传数据为空");
				return JSONObject.fromObject(map).toString();
			}
			String saveDirectoryPath = request.getContextPath() + "/upload/";
			String newPath=saveDirectoryPath+oldFileName;
			map.put("status", 1);
			map.put("msg", "success");
			map.put("path", newPath);
			//返回字符串,返回map会有低版本的ie兼容问题
			return JSONObject.fromObject(map).toString();
	}
	
	/**
	 * ajax返回map
	 * @param json
	 * @return
	 */
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
	/**
	 * ajax返回string字符串
	 * @param json
	 * @return
	 */
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
	
	@ResponseBody
	@RequestMapping("/getStr")
	public List<String> test(){
		return si.getStrList();
	}
	
	@ResponseBody
	@RequestMapping("/findRoleByMultParam")
	public List<GysBean> findRoleByMultParam(Integer id,String roleName){
		List<GysBean> list=null;
		try {
			list=iGysDemoService.findRoleByMultParam(id, roleName);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	@ResponseBody
	@RequestMapping("/getstulist")
	public List<Student> getstulist(){
		List<Student> list=null;
		try {
			list=iGysDemoService.getStudentList();
			System.out.println("==========");
			System.out.println(JSONArray.fromObject(list).toString());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	
	
	//TODO 执行不了
	@ResponseBody
	@RequestMapping("/getstulist1")
	public List<Student> getstulist1(){
		List<Student> list=null;
		try {
			list=iGysDemoService.getStudentList1();
			System.out.println("===========");
			System.out.println(JSONArray.fromObject(list).toString());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	
	@ResponseBody
	@RequestMapping("/getstulist2")
	public List<Student> getstulist2(){
		List<Student> list=null;
		try {
			list=iGysDemoService.getStudentList2();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	@ResponseBody
	@RequestMapping(value="/getstulist3")
	public List<Student> getstulist3(){
		List<Student> list=null;
		try {
			list=iGysDemoService.getStudentList3();
			System.out.println(JSONArray.fromObject(list).toString());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	
	@ResponseBody
	@RequestMapping(value="/getstulist4")
	public List3Result getstulist4(){
		List3Result l3=null;
		try {
			List<Student> list=iGysDemoService.getStudentList3();
			l3=new List3Result(1,"消息成功");
			l3.setList(list);
			System.out.println(JSONArray.fromObject(list).toString());
		} catch (Exception e) {
			e.printStackTrace();
			l3=new List3Result(1,"程序异常");
		}
		return l3;
	}
	
	/**
	 * forward和redirect区别
	 * forward:可以将参数带到另一个页面,而redirect不可以
	 * forward后路径不变,而redirect后路径会变化
	 * 
	 * 
	 * @param model
	 * @return
	 */
	@RequestMapping("/redirectPage")
	public String redirectPage(Model model){
		return "gysDemo/redirect";
	}
	@RequestMapping("/forwardPage")
	public String forwardPage(Model model){
		return "gysDemo/forward";
	}
	
	
	@RequestMapping("/redirect")
	public String redirect(Model model){
		model.addAttribute("name", "gys");
		return "redirect:/gysDemo/redirectPage";
	}
	@RequestMapping("/forward")
	public String forward(Model model){
		model.addAttribute("name", "gys");
		return "forward:/gysDemo/forwardPage";
	}
	
	/**
	 * 测试事务和异常的关系
	 * 第一步插入数据返回数据理论上是1
	 * 第二部判断插入数据是否是1
	 * 如果是1继续执行,否则终止执行,返回map
	 * 第三部继续插入数据
	 * 第四部返回执行结果
	 * 第1,3同属一个事务,如果在2中断了,第一步是否插入成功
	 * 如果2中通过异常来中断,第一步是否插入成功
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/ttae")
	public Map<String, Object> testTranstationAndException(){
		Map<String, Object> map=new HashMap<String, Object>();
		map.put("status", 2);
		try {
			map=iGysDemoService.insertTestTranstationAndException();
		}catch(MyException e){
			map.put("msg", "我的异常:"+e.getMessage()+";"+System.currentTimeMillis());
		}catch (Exception e) {
			e.printStackTrace();
			map.put("msg", "程序异常:"+System.currentTimeMillis());
		}
		return map;
	}
	
}
