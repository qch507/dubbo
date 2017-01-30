package com.qiuch.dubbo.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import com.qiuch.dubbo.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class UserController {
	
	@Resource
	private UserService userService;

	@RequestMapping("/userinfo")
	public ModelAndView userinfo(HttpServletRequest request) {
		ModelAndView mov = new ModelAndView();
		mov.setViewName("userinfo");
		mov.addObject("userInfo", userService.getUser());
		return mov;
	}
}
