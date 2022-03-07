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
				<form id="board-form" action="${pageContext.servletContext.contextPath}/board/write" method="post">
					<input id="board-title" name="title" type="text" value = "${readVo.title}" readonly><br>
					<textarea id="board-content" name="content" readonly>${readVo.content}</textarea><br>
					
						<div class="bottom">
							<a href="${pageContext.servletContext.contextPath}/board">게시판목록</a>
							<a href="${pageContext.servletContext.contextPath}/board">답글달기</a>
							<c:if test = "${authUser.id == readVo.userId}">
								<a href="${pageContext.servletContext.contextPath}/board/update/${readVo.no}">수정하기</a>
								<a href="${pageContext.servletContext.contextPath}/board/delete/${readVo.no}">삭제하기</a>
							</c:if>
						</div>
				</form>
			</div>
		</div>
	
	<c:import url="/WEB-INF/views/includes/footer.jsp"/>
	
</div>
</body>
</html>