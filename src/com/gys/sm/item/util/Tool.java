package com.gys.sm.item.util;

import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Properties;


/**
 * 工具函数
 * @author gys
 *
 */
public class Tool {
	
	/**
	 * 读取properties
	 * @param url 相对路径
	 * @return
	 */
	public Map<String, String> readProperties(String url) throws Exception{
		Properties prop=new Properties();
		Map<String, String> map=new HashMap<String, String>();
		InputStream in=this.getClass().getResourceAsStream(url);
		BufferedReader bf=new BufferedReader(new InputStreamReader(in,"UTF-8"));
		prop.load(bf);
		Iterator<String> it=prop.stringPropertyNames().iterator();
		while(it.hasNext()){
			String key=it.next();
			//System.out.println(key+":"+prop.getProperty(key));
			map.put(key, prop.getProperty(key));
		}
		in.close();
		return map;
	}
	/**
	 * 创建properties
	 * @param url 绝对路径 src/prop/b.properties
	 * @param map 需要存入的参数
	 * @param b true:追加;false:清空重写
	 */
	public void makeProperties(String url,Map<String, Object> map,boolean b) throws Exception{
		Properties prop=new Properties();
		///保存属性到b.properties文件
		FileOutputStream out = new FileOutputStream(url, false);//true表示追加打开
		Iterator<Map.Entry<String, Object>> it=map.entrySet().iterator();
		while (it.hasNext()) {
			Map.Entry<String,Object> entry=it.next();
			prop.setProperty(entry.getKey(), entry.getValue().toString());
		}
		prop.store(new OutputStreamWriter(out,"utf-8"), "配置文件");
		out.close();
		System.out.println(url+"生成成功");
	}
	
	
	public static void main(String[] args) throws Exception{
		Tool tool=new Tool();
		//生成properties
		Map<String, Object> map=new HashMap<String, Object>();
		map.put("age",26);
		map.put("name","郭延思");
		tool.makeProperties("src/com/item/util/a.properties", map, false);
		
		//读取properties
		Map<String, String> resMap=tool.readProperties("a.properties");
		Iterator<Map.Entry<String, String>> it=resMap.entrySet().iterator();
		while (it.hasNext()) {
			Map.Entry<String,String> entry=it.next();
			System.out.println(entry.getKey()+":"+entry.getValue());
		}
	}
}
