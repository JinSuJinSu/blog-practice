package com.poscoict.jinblog.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.poscoict.jinblog.security.Auth;
import com.poscoict.jinblog.security.AuthUser;
import com.poscoict.jinblog.service.JsonService;
import com.poscoict.jinblog.vo.BoardVo;
import com.poscoict.jinblog.vo.JsonResult;
import com.poscoict.jinblog.vo.UserVo;

@Controller
@RequestMapping("/json")
public class JsonController {
	
	@Autowired
	private JsonService jsonService;
	
	@Auth
	@RequestMapping({""})
	public String index(@AuthUser UserVo authUser, Model model) {
		return "json/index";
	}
	
	@Auth
	@RequestMapping(value="/active", method=RequestMethod.GET)
	public JsonResult json(@AuthUser UserVo authUser, Model model) {
		BoardVo jsonVo = jsonService.getJson(authUser.getId());
		return JsonResult.success(jsonVo);
	}
}
	

