package com.poscoict.jinblog.repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.poscoict.jinblog.vo.BoardVo;

@Repository
public class BoardRepository {
	
	@Autowired
	private SqlSession sqlSession;
	
	// 게시판 조회하기
	public BoardVo findOne(int no) {
		BoardVo boardVo = sqlSession.selectOne("board.findOne",no);
		return boardVo;
	}
	
	// 게시판 전체 개수 구하기
	public int findAll(String value, String kwd){
		Map<String, Object> map = new HashMap<>();
		map.put("kwd", kwd);
		map.put("value", value);
		int cnt = sqlSession.selectOne("board.findAll", map);
		return cnt;			
	}
	
	// 특정 범위의 글을 페이징 처리해서보여줌(검색 포함)
	public List<BoardVo> limitFind(String value, String kwd, int currentPage){
		Map<String, Object> map = new HashMap<>();
		map.put("kwd", kwd);
		map.put("value", value);
		map.put("page", (currentPage-1)*5);
		List<BoardVo> list=sqlSession.selectList("board.limitFind", map);
		return list;			
	}
	
	// 게시판 글 추가하기
	public boolean insert(BoardVo boardVo) {
		int cnt = sqlSession.insert("board.insert", boardVo);
		return cnt==1;
	}
	
	// 게시판 글 삭제하기
	public boolean delete(int no) {
		int cnt = sqlSession.delete("board.delete", no);
		return cnt==1;
	}
	
	// 게시판 글 수정하기
	public boolean update(BoardVo boardVo) {
		int cnt = sqlSession.delete("board.update", boardVo);
		return cnt==1;
	}
	
	// 게시판 조회수 증가시키기
	public boolean update(int no) {
		int cnt = sqlSession.update("board.hitUpdate", no);
		return cnt==1;
	}
	
	

}
