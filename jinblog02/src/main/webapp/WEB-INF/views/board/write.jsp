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
				<form id="write-form" action="${pageContext.servletContext.contextPath}/board/write" method="post">
					<input id="write-title" placeholder="제목을 작성하세요" name="title" type="text" required><br>
					<textarea id="write-content" placeholder="내용을 작성하세요" name="content" required></textarea><br>
					
						<div class="bottom">
							<a href="${pageContext.servletContext.contextPath}/board">글쓰기 취소</a>
							<input type="submit" value="작성완료">	
						</div>
						
				</form>
			</div>
		</div>
	
	<c:import url="/WEB-INF/views/includes/footer.jsp"/>
	
</div>
<%-- <script type="text/javascript" src="${pageContext.request.contextPath}/assets/js/jinblog.js"></script> --%>
<script type="text/javascript" src="${pageContext.request.contextPath}/assets/jquery/jquery-jinblog.js"></script>
</body>
</html>