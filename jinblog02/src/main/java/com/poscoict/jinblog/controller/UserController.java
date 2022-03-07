package com.poscoict.jinblog.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.poscoict.jinblog.security.Auth;
import com.poscoict.jinblog.security.AuthUser;
import com.poscoict.jinblog.service.UserService;
import com.poscoict.jinblog.vo.UserVo;

@Controller
@RequestMapping("/user")
public class UserController {
	
	
	@Autowired
	private UserService userService;
	
	// 회원가입 페이지 이동
	@RequestMapping(value="/join", method=RequestMethod.GET)
	public String join() {
		return "user/join";
	}
	
	// 회원가입 
	@RequestMapping(value="/join", method=RequestMethod.POST)
	public String join(UserVo userVo) {
//		if(userService.checkUser(userVo.getId())!=null){
//			return "user/join"; // 기존 아이디가 존재할 경우
//		}
//		
//		if(userVo.getId().equals("") || userVo.getName().equals("") || userVo.getPassword().equals("") || userVo.getEmail().equals("")) {
//			return "user/join"; // 회원가입 입력을 똑바로 하지 않았을 시
//		}
		userService.join(userVo);
		return "redirect:/user/joinsuccess";
	}
	
	// 회원가입 성공페이지 이동
	@RequestMapping(value="/joinsuccess", method=RequestMethod.GET)
	public String joinsuccess() {
		return "user/joinsuccess";
	}
	
	// 로그인 페이지 이동
	@RequestMapping(value="/login", method=RequestMethod.GET)
	public String login() {
		return "user/login";
	}

	

	
	
	


}
