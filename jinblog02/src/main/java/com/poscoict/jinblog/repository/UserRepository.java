package com.poscoict.jinblog.repository;

import java.util.HashMap;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.poscoict.jinblog.vo.UserVo;



@Repository
public class UserRepository {
	
	@Autowired
	private SqlSession sqlSession;
	
	// 유저 데이터 추가
	public boolean insert(UserVo vo) {
		int count = sqlSession.insert("user.insert",vo);
		return count==1;
	}
	
	// 블로그 데이터 추가
	public boolean insertBlog(UserVo vo) {
		int count = sqlSession.insert("user.insertBlog",vo);
		return count==1;
	}
	
	// 카테고리 데이터 추가
	public boolean insertCategory(UserVo vo) {
		int count = sqlSession.insert("user.insertCategory",vo);
		return count==1;
	}
	
	// 유저 등급 데이터 추가
	public boolean insertRating(UserVo vo) {
		int count = sqlSession.insert("user.insertRating",vo);
		return count==1;
	}
	
	// 회원가입 유저 중복 체크
	public String checkUser(String id){
		String userId = sqlSession.selectOne("user.checkUser",id);
		return userId;
	}
	
	// 유저 로그인
	public UserVo findUser(String id, String password){
		Map<String, Object> map = new HashMap<>();
		map.put("id", id);
		map.put("password", password);
		UserVo vo = sqlSession.selectOne("user.findUser",map);
		return vo;
	}

}
