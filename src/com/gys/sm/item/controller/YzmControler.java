package com.gys.sm.item.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.gys.sm.item.util.RandomValidateCode;


@Controller
public class YzmControler {
	
	@ResponseBody
	@RequestMapping(value = "/yzm", method = RequestMethod.GET)
    public void captcha(HttpSession session,HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException{
		session.removeAttribute("RANDOMCODEKEY");
		RandomValidateCode randomValidateCode = new RandomValidateCode();
        String yzm=randomValidateCode.getRandcode(request, response);//输出图片方法
        session.setAttribute("yzm", yzm);
    }
}
