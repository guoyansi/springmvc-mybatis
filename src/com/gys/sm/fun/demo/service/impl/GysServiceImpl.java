package com.gys.sm.fun.demo.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.gys.sm.fun.demo.service.IGysDemoService;

@Service
public class GysServiceImpl{
	public List<String> getStrList(){
		List<String> list=new ArrayList<String>(); 
		list.add("a");
		list.add("b");
		list.add("c");
		return list;
	}
}
