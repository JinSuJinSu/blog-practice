package com.poscoict.jinblog.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.poscoict.jinblog.repository.BoardRepository;
import com.poscoict.jinblog.vo.BoardVo;

@Service
public class BoardService {
	
	@Autowired
	private BoardRepository boardRepository;
	
	// 게시판 리스트 가져오기
	public List<BoardVo> getBoardList() {
		List<BoardVo> list = boardRepository.findAll();
		return list;
	}
	
	// 게시판 글 추가하기
	public boolean insert(BoardVo boardVo) {
		boolean result = boardRepository.insert(boardVo);
		return result;
	}

}
