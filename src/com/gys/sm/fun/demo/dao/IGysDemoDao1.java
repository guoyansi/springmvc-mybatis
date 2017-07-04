package com.gys.sm.fun.demo.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.gys.sm.fun.demo.bean.GysBean;


@Repository
public interface IGysDemoDao1 {
	List<GysBean> getRole() throws Exception;
}	
