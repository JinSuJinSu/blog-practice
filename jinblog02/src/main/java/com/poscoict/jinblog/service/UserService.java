package com.poscoict.jinblog.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.poscoict.jinblog.repository.UserRepository;
import com.poscoict.jinblog.vo.UserVo;


@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepository;
	
	// 회원가입
	public void join(UserVo userVo) {
		userRepository.insert(userVo);
		userRepository.insertBlog(userVo); // 회원가입시 디폴트 블로그 제목, 블로그 사진 데이터를 추가해준다.
		userRepository.insertCategory(userVo); // 회원가입시 디폴트 카테고리 제목, 카테고리 내용 데이터를 추가해준다.
		userRepository.insertRating(userVo); // 회원가입시 디폴트 회원 등급 데이터를 추가해준다.
	}
	
	// 회원가입 중복체크
	public String checkUser(String id) {
		String userId = userRepository.checkUser(id);
		return userId;
	}
	
	// 로그인 시 아이디, 비번 확인
	public UserVo getUser(String id, String password) {
		UserVo user = userRepository.findUser(id,password);
		return user;
	}
	
	
	
	
	
	

}
