package com.poscoict.jinblog.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

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
	
	@ResponseBody
	@RequestMapping(value="/active", method=RequestMethod.GET)
	public JsonResult json(@AuthUser UserVo authUser, Model model) {
		BoardVo jsonVo = jsonService.getJson(authUser.getId());
		return JsonResult.success(jsonVo);
	}
	
	@ResponseBody
	@RequestMapping(value="/jsonActive", method=RequestMethod.GET)
	public JsonResult jsonActive(@AuthUser UserVo authUser, Model model) {
		List<BoardVo> jsonVoList = jsonService.getJsonList(authUser.getId());
		return JsonResult.success(jsonVoList);
	}
}
	

