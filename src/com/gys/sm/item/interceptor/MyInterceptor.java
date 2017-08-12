package com.gys.sm.item.interceptor;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

import org.apache.log4j.Logger;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;


public class MyInterceptor extends HandlerInterceptorAdapter {
	private static Logger logger=Logger.getLogger(MyInterceptor.class);
	
    public boolean preHandle(HttpServletRequest request,HttpServletResponse response, Object handler) throws Exception {
    	//System.out.println("经过拦截器....");
        String url = request.getRequestURI();
        logger.info("请求路径:>>>>"+url);
        boolean session=true;
        if(session){//session未失效
        	
        }else{//session失效
        	String requestType = request.getHeader("X-Requested-With"); 
        	if(requestType==null){//普通请求
        		response.setContentType("text/html;charset=utf-8");
                response.getWriter().print("<script language='javascript'>");
                response.getWriter().print("window.location.href='" + request.getContextPath() + "/out.jsp';");
                response.getWriter().print("</script>");
        	}else{//ajax请求
        		response.setContentType("text/plain;charset=utf-8");
        		Map<String, Object> map=new HashMap<String, Object>();
        		map.put("status", 3);
        		map.put("msg", "登录信息失效，请从登录页重新登录！");
        		response.getWriter().print(JSONObject.fromObject(map).toString());
        	}
        	return false;
        }
        return true;
    }
}
