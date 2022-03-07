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
<script type="text/javascript" src="${pageContext.request.contextPath}/assets/jquery/jquery-3.6.0.js"></script>
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
						<td><a href="${pageContext.servletContext.contextPath}/board/view/${vo.no}">${vo.title}</a></td>				
						<td>${vo.hit}</td>
						<td>${vo.regDate}</td>
					</c:forEach>
				</table>
				
				<div class="pager">
					<ul>
						<c:if test = "${map.startPage!=1}">
						<li><a href="${pageContext.servletContext.contextPath}/board?page=${map.startPage-5}&kwd=${map.kwd}&value=${map.value}&arrow=arrow">◀</a></li>
						</c:if>
						<c:forEach  begin="${map.startPage}" end="${map.endPage}"  step="1" var="page">
							<c:choose>
								<c:when test="${map.currentPage==page}">
									<li class="selected">
									<a href="${pageContext.servletContext.contextPath}/board?page=${page}&kwd=${map.kwd}&value=${map.value}">${page}</a></li>
								</c:when>
								<c:otherwise>
								<li>
								<a href="${pageContext.servletContext.contextPath}/board?&page=${page}&kwd=${map.kwd}&value=${map.value}">${page}</a></li>
								</c:otherwise>	
							</c:choose>		
						</c:forEach>
						<c:if test = "${map.endPage!=Math.ceil(map.size/5)}">
						<li><a href="${pageContext.servletContext.contextPath}/board?page=${map.startPage+5}&kwd=${map.kwd}&value=${map.value}&arrow=arrow">▶</a></li>
						</c:if>
					</ul>
				</div>					
			
				<!-- 글쓰기 버튼 추가-->			
				<div class="bottom">
					<button onclick="location.href='${pageContext.servletContext.contextPath}/board/write'">글쓰기</button>
				</div>				
			</div>
		</div>
	
	<c:import url="/WEB-INF/views/includes/footer.jsp"/>
	
</div>
</body>
</html>