<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<Link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/board.css">
<script type="text/javascript" src="jquery/jquery-3.6.0.js"></script>
</head>
<body>

<div id="container">
	<c:import url="/WEB-INF/views/includes/header.jsp"/>
	<c:import url="/WEB-INF/views/includes/navigation.jsp"/>
	

	<div id="content">
		<div id="board">
				<form id="search-form" action="${pageContext.servletContext.contextPath}/board" method="post">
				<select name="kwd">
				    <option value="" disabled>검색</option>
				    <option value="title">제목</option>
				    <option value="content">내용</option>
				</select>
					<input type="text" id="value" name="value" value="">
					<input type="submit" value="찾기">
				</form>
				<table class="table">
					<tr>
						<th>번호</th>
						<th>글쓴이</th>
						<th>제목</th>
						<th>조회수</th>
						<th>작성일</th>
						<th>&nbsp;</th>
					</tr>
					
					<c:forEach items="${list}" var="vo" varStatus="status">
					<tr>
						<td>${list.size()-status.index}</td>
						<td>${vo.userId}</td>
						<td>${vo.title}</td>				
						<td>${vo.hit}</td>
						<td>${vo.regDate}</td>
					</c:forEach>
				</table>
			
				<!-- 글쓰기 버튼 추가-->			
				<div class="bottom">
					<button onclick="location.href='${pageContext.servletContext.contextPath}/board/write'">글쓰기</button>
				</div>				
			</div>
		</div>
	
	<c:import url="/WEB-INF/views/includes/footer.jsp"/>
	
</div>
<%-- <script type="text/javascript" src="${pageContext.request.contextPath}/assets/js/jinblog.js"></script> --%>
<script type="text/javascript" src="${pageContext.request.contextPath}/assets/jquery/jquery-jinblog.js"></script>
</body>
</html>