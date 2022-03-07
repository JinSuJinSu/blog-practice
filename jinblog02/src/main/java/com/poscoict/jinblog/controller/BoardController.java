package com.poscoict.jinblog.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

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
	
	// 게시판 메인 페이지
	@RequestMapping({""})
	public String index(Model model, @RequestParam(value="page", required=true, defaultValue="1") int page,
			@RequestParam(value="kwd", required=true, defaultValue="title") String kwd,
			@RequestParam(value="value", required=true, defaultValue="") String value,
			@RequestParam(value="arrow", required=true, defaultValue="") String arrow)
	{
		
	Map<String, Object> map = boardService.getBoardList(value, kwd ,page, arrow); // 검색 값이 비어 있을 경우는 전체 조회가 된다.
	System.out.println(map);
	model.addAttribute("map", map);
	return "board/list";	
	}
	
	// 특정 게시판 조회
	@RequestMapping(value="/view/{no}", method=RequestMethod.GET)
	public String value(@PathVariable("no") int no, Model model) {
		boardService.updateHit(no);
		BoardVo boardVo = boardService.getBoard(no);
		model.addAttribute("readVo", boardVo);
		return "board/view";
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
		boardService.insertBoard(boardVo);
		return "redirect:/board";
	}
	
	// 게시판 글 삭제하기
	@Auth
	@RequestMapping(value="/delete/{no}", method=RequestMethod.GET)
	public String delete(@PathVariable("no") int no) {
		boardService.deleteBoard(no);
		return "redirect:/board";
	}
	
	// 게시판 글수정 페이지 이동
	@Auth
	@RequestMapping(value="/update/{no}", method=RequestMethod.GET)
	public String update(@PathVariable("no") int no, Model model) {
		BoardVo boardVo = boardService.getBoard(no);
		model.addAttribute("updateVo", boardVo);
		return "board/update";
	}
	
	// 게시판 글 수정하기
	@Auth
	@RequestMapping(value="/update/{no}", method=RequestMethod.POST)
	public String update(@PathVariable("no") int no, BoardVo boardVo) {
		boardVo.setNo(no);
		boardService.updateBoard(boardVo);
		return "redirect:/board";
	}

}
