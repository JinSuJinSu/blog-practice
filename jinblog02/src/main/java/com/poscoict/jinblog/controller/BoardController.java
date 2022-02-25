package com.poscoict.jinblog.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.poscoict.jinblog.security.Auth;
import com.poscoict.jinblog.security.AuthUser;
import com.poscoict.jinblog.service.BoardService;
import com.poscoict.jinblog.vo.BoardVo;
import com.poscoict.jinblog.vo.UserVo;

@Controller
@RequestMapping("/board")
public class BoardController {
	
	@Autowired
	private BoardService boardService;
	
	@RequestMapping({""})
	public String index(Model model) {
		List<BoardVo> list = boardService.getBoardList();
		model.addAttribute("list", list);
		return "board/list";
	}
	
	// 게시판 글작성 페이지 이동
	@Auth
	@RequestMapping(value="/write", method=RequestMethod.GET)
	public String write() {
		return "board/write";
	}
	
	// 게시판 글 작성하기
	@Auth
	@RequestMapping(value="/write", method=RequestMethod.POST)
	public String write(@AuthUser UserVo authUser, BoardVo boardVo) {
		String userId = authUser.getId();
		boardVo.setUserId(userId);
		boardService.insert(boardVo);
		return "redirect:/board";
	}
	
	// 게시판 정보 가져오기(ajax 연습용)
	
	@RequestMapping("/json")
	public String json() {
		return "board/json";
	}
	
//	@Auth
//	@RequestMapping(value="/json", method=RequestMethod.GET)
//	public String json(@AuthUser UserVo authUser, BoardVo boardVo) {
//		String userId = authUser.getId();
//		boardVo.setUserId(userId);
//		boardService.insert(boardVo);
//		return "redirect:/board";
//	}
	
	

}
