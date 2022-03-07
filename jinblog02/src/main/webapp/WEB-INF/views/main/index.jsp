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
		<img src="/jinblog02/assets/images/image1.jpg" alt="시험이미지"/>
		<img src="/jinblog02/assets/images/image2.jpg" alt="시험이미지"/>
		<img src="/jinblog02/assets/images/image3.jpg" alt="시험이미지"/>
		<img src="/jinblog02/assets/images/image4.jpg" alt="시험이미지"/>
		<img src="/jinblog02/assets/images/image1.jpg" alt="시험이미지"/>
		<img src="/jinblog02/assets/images/image2.jpg" alt="시험이미지"/>
		<img src="/jinblog02/assets/images/image3.jpg" alt="시험이미지"/>
		<img src="/jinblog02/assets/images/image4.jpg" alt="시험이미지"/>
		<img src="/jinblog02/assets/images/image1.jpg" alt="시험이미지"/>
		<img src="/jinblog02/assets/images/image2.jpg" alt="시험이미지"/>
		<img src="/jinblog02/assets/images/image3.jpg" alt="시험이미지"/>
		<img src="/jinblog02/assets/images/image4.jpg" alt="시험이미지"/>
	</div>
	
	<c:import url="/WEB-INF/views/includes/footer.jsp"/>
	
</div>
<script type="text/javascript" src="${pageContext.request.contextPath}/assets/jquery/jquery-jinblog.js"></script>
</body>
</html>