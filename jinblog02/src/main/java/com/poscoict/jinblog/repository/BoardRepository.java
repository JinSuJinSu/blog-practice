package com.poscoict.jinblog.repository;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.poscoict.jinblog.vo.BoardVo;

@Repository
public class BoardRepository {
	
	@Autowired
	private SqlSession sqlSession;
	
	// 게시판 전체 선택
	public List<BoardVo> findAll() {
		List<BoardVo> list = sqlSession.selectList("board.findAll");
		return list;
	}
	
	// 게시판 글 추가하기
	public boolean insert(BoardVo boardVo) {
		int cnt = sqlSession.insert("board.insert", boardVo);
		return cnt==1;
	}
	

}
