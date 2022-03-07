package com.poscoict.jinblog.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.poscoict.jinblog.repository.JsonRepository;
import com.poscoict.jinblog.vo.BoardVo;


@Service
public class JsonService {
	
	@Autowired
	private JsonRepository jsonRepository;
	
	// json용 객체 선택
	public BoardVo getJson(String userId) {
		BoardVo boardVo = jsonRepository.findJson(userId);
		return boardVo;
	}
	
	// json용 객체 리스트 선택
	public List<BoardVo> getJsonList(String userId) {
		List<BoardVo> list = jsonRepository.findAllJson(userId);
		return list;
	}

}
