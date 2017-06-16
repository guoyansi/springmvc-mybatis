package com.gys.sm.item.constant;

import java.util.HashMap;
import java.util.Map;


public class ReturnRes {
	public final static String status="status";
	public final static String msg="msg";
	public final static int success=1;
	public final static int error=2;
	public final static int sessionNothing=3;
	//public final static String sessionNothingMsg="session失效";
	public final static String exception="程序异常";
	
	public static Map<String, Object> getMap(){
		Map<String, Object> map=new HashMap<String, Object>();
		map.put(ReturnRes.status, error);
		return map;
	}
	public static void addResToMap(Map<String, Object> map,int status){
		map.put(ReturnRes.status, status);
	}
	public static void addResToMap(Map<String, Object> map,String msg){
		map.put(ReturnRes.msg, msg);
	}
	public static void addResToMap(Map<String, Object> map,int status,String msg){
		map.put(ReturnRes.status, status);
		map.put(ReturnRes.msg, msg);
	}
			
}
