package com.poscoict.jinblog.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.poscoict.jinblog.repository.BoardRepository;
import com.poscoict.jinblog.vo.BoardVo;

@Service
public class BoardService {
	
	@Autowired
	private BoardRepository boardRepository;
	
	@Autowired
	private HttpSession session;
	
	// 게시판 조회하기
	public BoardVo getBoard(int no) {
		BoardVo boardVo = boardRepository.findOne(no);
		return boardVo;
	}

	// 게시판 리스트 가져오기(검색 포함)
	public Map<String, Object> getBoardList(String value, String kwd, int currentPage, String arrow){
	int size = boardRepository.findAll(value,kwd); // 전체 개시글 가져오기
	List<BoardVo> list = boardRepository.limitFind(value,kwd,currentPage); // 현제 패이지 개시글
	
	if((int[])session.getAttribute("read")!=null) {
		session.removeAttribute("read"); // 조회가 끝나면 해당 세션을 제거해준다.
	}	
	
	int startPage = 1 + 5*((currentPage-1)/5); // 시작페이지는 1, 6, 11 이런식으로 되고 페이징 시작점이 5개씩이다.
	int endPage = startPage + 4; // 화살표 양옆으로 5개씩 페이지가 존재하므로 첫페이지가 1이면 마지막 페이지는 5가 된다.
	if (endPage >= Math.ceil((double) size / 5)) {
		endPage = (int) Math.ceil((double) size / 5); // 예들 들어 게시글의 개수가 36개일 때 최대 페이지 번호는 8이고 그보다 크면 범위를 벗어나므로 최대페이지 번호로 고정시킨다.
	}
	if(arrow.equals("arrow")) {
		currentPage=startPage; // 화살표를 클릭했을 때 1,6,11로 시작하므로 현재 페이지를 시작 페이지와 같게 해준다.
	}
	
	Map<String, Object> map = new HashMap<>();

	map.put("list", list);
	map.put("size", size);
	map.put("startPage", startPage);
	map.put("currentPage", currentPage);
	map.put("endPage", endPage);
	map.put("value", value);
	map.put("kwd", kwd);
	return map;		
	}
	
	// 게시판 글 추가하기
	public boolean insertBoard(BoardVo boardVo) {
		boolean result = boardRepository.insert(boardVo);
		return result;
	}
	
	// 게시판 글 삭제하기
	public boolean deleteBoard(int no) {
		boolean result = boardRepository.delete(no);
		return result;
	}
	
	// 게시판 글 수정하기
	public boolean updateBoard(BoardVo boardVo) {
		boolean result = boardRepository.update(boardVo);
		return result;
	}
	
	// 게시판 조회수 증가시키기
	public boolean updateHit(int no) {
		
		boolean result=true;
		if(session.getAttribute("read") == null) { // 세션이 없을 경우 추가해준다.
			session.setAttribute("read", new int[1]);
		}
		
		int[] readList = (int[])session.getAttribute("read");
		if(readList[0]!=no) {
			readList[0]=no;
			result = boardRepository.update(no); 
			session.setAttribute("read", readList);
		}
		return result;
	}

}
