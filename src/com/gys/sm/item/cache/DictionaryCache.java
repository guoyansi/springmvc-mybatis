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
	/**
	 * 添加缓存
	 * @param bean
	 */
	public static void put(SysDictionaryBean bean) throws Exception{
		if(map.containsKey(bean.getDict_code())){
			map.get(bean.getDict_code()).add(bean);
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
		if(list==null){
			list=new ArrayList<SysDictionaryBean>();
		}
		for(SysDictionaryBean d:list){
			put(d);
		}
	}
	/**
	 * 获取字典表中的dict_name
	 * @param code
	 * @param value
	 * @return
	 * @throws Exception
	 */
	public static String getName(String code,String value) throws Exception{
		  Iterator<Map.Entry<String, List<SysDictionaryBean>>> it = map.entrySet().iterator();
		  while (it.hasNext()) {
			  Map.Entry<String, List<SysDictionaryBean>> entry = it.next();
			  if(entry.getKey().equals(code)){
				   List<SysDictionaryBean> beans=entry.getValue();
				   for(SysDictionaryBean b:beans){
					   if(b.getDict_value().equals(value)){
						   return b.getDict_name();
					   }
				   }
			  }
		  }
		  return null;
	}
	/**
	 * 获取同一code的字典list
	 * @param code
	 * @return
	 * @throws Exception
	 */
	public static List<SysDictionaryBean> getDictList(String code) throws Exception{
		if(map.containsKey(code)){
			return map.get(code);
		}else{
			return new ArrayList<SysDictionaryBean>();
		}
	}
}
