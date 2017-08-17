package com.gys.sm.test;

import net.sf.json.JSONObject;

import com.gys.sm.item.util.HttpClientUtils;
/**
 * 用于测试
 * @author gys
 *
 */
public class Test {
	public static void main(String[] args) {
		JSONObject res2=HttpClientUtils.httpGet("http://192.168.6.234:8080/eva/jk/getStudentList?address_id=57");
		System.out.println("===========");
		System.out.println(res2.toString());
	}
}
