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
<script>
$(function(){
	// json 단일 객체 받아오기
	$("#jsonBtn").click(function(){
		$.ajax({
			url:"${pageContext.request.contextPath}/json/active",
			async:true,
			type:"GET",
			dataType:"json",
			success:function(response){
				if(response.result!=="success"){
					console.log(response.message);
					return;
					}
				
				let html="";
				html+=("<p>" + response.data.no + ", " +  response.data.userId + ", " + response.data.title + ", " + 
						response.data.content + ", " + response.data.hit  + "</p>");
				$("#data").append(html);				
				}
			
		});
	});
	
	// json 리스트 객체 받아오기
	$("#jsonListBtn").click(function(){
		$.ajax({
			url:"${pageContext.request.contextPath}/json/jsonActive",
			async:true,
			type:"GET",
			dataType:"json",
			success:function(response){
				if(response.result!=="success"){
					console.log("실패한거야???");
					console.log(response.message);
					return;
					}
				let html="";
				html+="<p>";
				let dataList = response.data
				dataList.forEach(element => html+=(element.no + ", " +  element.userId + ", " + element.title + ", " + 
						element.content + ", " + element.hit + "<br>"));
				html+="</p>";
				$("#data").append(html);				
				}
			
		});
	});
});
</script>
</head>
<body>

<div id="container">
	<c:import url="/WEB-INF/views/includes/header.jsp"/>
	<c:import url="/WEB-INF/views/includes/navigation.jsp"/>
	

	<div id="content">
		<button id="jsonBtn">클릭을 하셈!!!</button>
		<button id="jsonListBtn">클릭을 하셈!!!!!!!!!</button>
<%-- 		<p>${jsonVo.no}, ${jsonVo.userId}, ${jsonVo.title}, ${jsonVo.content}, ${jsonVo.hit}</p> --%>
			<p id="data"></p>
	</div>
	
	<c:import url="/WEB-INF/views/includes/footer.jsp"/>
	
</div>
</body>
</html>