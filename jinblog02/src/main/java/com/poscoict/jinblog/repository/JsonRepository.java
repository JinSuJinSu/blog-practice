package com.poscoict.jinblog.repository;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.poscoict.jinblog.vo.BoardVo;

@Repository
public class JsonRepository {
	
	@Autowired
	private SqlSession sqlSession;
	
	// json용 객체 선택
	public BoardVo findJson(String userId) {
		BoardVo boardVo = sqlSession.selectOne("json.findJson",userId);
		return boardVo;
	}

}
