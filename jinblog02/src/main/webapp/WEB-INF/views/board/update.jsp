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
<script type="text/javascript" src="${pageContext.request.contextPath}/assets/jquery/jquery-3.6.0.js"></script>>
</head>
<body>

<div id="container">
	<c:import url="/WEB-INF/views/includes/header.jsp"/>
	<c:import url="/WEB-INF/views/includes/navigation.jsp"/>
	

	<div id="content">
		<div id="board">
				<form id="board-form" action="${pageContext.servletContext.contextPath}/board/update/${updateVo.no}" method="post">
					<input id="board-title" name="title" type="text" value="${updateVo.title}"><br>
					<textarea id="board-content" name="content">${updateVo.content}</textarea><br>
					
						<div class="bottom">
							<a href="${pageContext.servletContext.contextPath}/board/view/${updateVo.no}">글수정 취소</a>
							<input type="submit" value="작성완료">	
						</div>
						
				</form>
			</div>
		</div>
	
	<c:import url="/WEB-INF/views/includes/footer.jsp"/>
	
</div>
</body>
</html>