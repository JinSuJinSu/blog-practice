<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<Link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/user.css">
<script type="text/javascript" src="${pageContext.request.contextPath}/assets/jquery/jquery-3.6.0.js"></script>
</head>
<body>

<div id="container">
	<c:import url="/WEB-INF/views/includes/header.jsp"/>
	<c:import url="/WEB-INF/views/includes/navigation.jsp"/>
	

	<div id="content">
	
		<div id="user-login">
			<form id="login-form" action="${pageContext.request.contextPath }/user/auth" method="post">
				<input placeholder="아이디" name="id" type="text" value=""><br>
				<input placeholder="비밀번호" name="password" type="text" value=""><br>
				<input type="submit" value="로그인하기">
			</form>
		</div>
		
	</div>
	
	<c:import url="/WEB-INF/views/includes/footer.jsp"/>
	
</div>
</body>
</html>