package com.gys.sm.item.cache;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import com.gys.sm.item.bean.SysDictionaryBean;

/**
 * 字典缓存
 * @author gys
 *
 */
public class DictionaryCache {
	private static Map<String, List<SysDictionaryBean>> map=new LinkedHashMap<String, List<SysDictionaryBean>>();
	private static List<SysDictionaryBean> dictList=null;
	/**
	 * 添加缓存
	 * @param bean
	 */
	public static void put(SysDictionaryBean bean) throws Exception{
		//map.put(bean.getDict_code(), bean);
		if(map.containsKey(bean.getDict_code())){
			List<SysDictionaryBean> list=map.get(bean.getDict_code());
			boolean b=false;
			for(SysDictionaryBean d:list){
				if(d.getDict_code().equals(bean.getDict_code())){
					b=true;
					break;
				}
			}
			if(!b){
				list.add(bean);
			}
		}else{
			List<SysDictionaryBean> list=new ArrayList<SysDictionaryBean>();
			list.add(bean);
			map.put(bean.getDict_code(),list);
		}
	}
	/**
	 * 添加缓存
	 * @param bean
	 */
	public static void putAll(List<SysDictionaryBean> list) throws Exception{
		dictList=(list==null?new ArrayList<SysDictionaryBean>():list);
		for(SysDictionaryBean d:list){
			put(d);
		}
	}
	public static String getName(String code,String value) throws Exception{
		 Iterator<Map.Entry<String, List<SysDictionaryBean>>> it = map.entrySet().iterator();
		  while (it.hasNext()) {
		   Map.Entry<String, List<SysDictionaryBean>> entry = it.next();
		   if()
		  }
	}
}
