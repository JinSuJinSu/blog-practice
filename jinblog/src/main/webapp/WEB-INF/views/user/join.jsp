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
</head>
<body>

<div id="container">
	<c:import url="/WEB-INF/views/includes/header.jsp"/>
	<c:import url="/WEB-INF/views/includes/navigation.jsp"/>
	

	<div id="content">
	
		<div id="user-join">
			<form id="join-form">
				<input placeholder="아이디" name="id" type="text" value="">
				<input placeholder="비밀번호" name="password" type="text" value="">
				<input placeholder="이름" name="name" type="text" value="">
				<input placeholder="이메일" name="email" type="text" value="">
				<input type="submit" value="가입하기">
			</form>
		</div>
		
	</div>
	
	<c:import url="/WEB-INF/views/includes/footer.jsp"/>
	
</div>

</body>
</html>