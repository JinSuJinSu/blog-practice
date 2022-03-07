package com.poscoict.jinblog.controller.api;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.poscoict.jinblog.service.UserService;
import com.poscoict.jinblog.vo.JsonResult;
import com.poscoict.jinblog.vo.UserVo;



@RestController("userApiController")
@RequestMapping("/user/api")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@GetMapping("/checkid")
	public Object checkid(@RequestParam(value="id", required=true, defaultValue="") String id) {
		UserVo userVo = userService.checkUser(id);
		System.out.println("userVo:"+userVo);
		return JsonResult.success(userVo!=null);
	}

}
