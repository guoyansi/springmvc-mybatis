package com.gys.sm.item.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CrossFilter implements Filter{

	@Override
	public void destroy() {
		
		
	}

	@Override
	public void doFilter(ServletRequest req, ServletResponse res,
			FilterChain doChain) throws IOException, ServletException {
		HttpServletRequest request=(HttpServletRequest) req;
		HttpServletResponse response=(HttpServletResponse)res;
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/plain;charset=utf-8");
		//response.setHeader("Access-Control-Allow-Origin", "http://127.0.0.1:8020");或者
		response.setHeader("Access-Control-Allow-Origin", "*");
		response.setHeader("Access-Control-Allow-Headers","content-type");
		doChain.doFilter(req,res);
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		
	}

}
