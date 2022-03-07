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
<script>
$(function(){
	
	let idCheck="no";
	
	$("#join-form").submit(function(event){
		event.preventDefault();
		
		// 아이디 유효성 체크(empty) 체크
		if($("#id").val()==""){
			alert("아이디가 비어있습니다.");
			$("#id").focus();
			return;
		}
		
		// 중복체크 유무
		if(idCheck==="no"){
			alert("아이디 중복체크가 안되어있습니다.");
			$("#id").focus();
			return;
		}
		
		// 비밀번호 유효성(empty) 체크
		if($("#password").val()==""){
			alert("패스워드가 비어있습니다.");
			$("#password").focus();
			return;
		}
		
		// 이름 유효성 체크(empty) 체크
		if($("#name").val()==""){
			alert("아이디가 비어있습니다.");
			$("#name").focus();
			return;
		}
		
		// 이메일 유효성(empty) 체크
		if($("#email").val()==""){
			alert("이메일이 비어있습니다.");
			$("#email").focus();
			return;
		}
		
		// 유효성 OK
		console.log("OK!!");
		$("#join-form")[0].submit();
	})
	
	
	$("#id").change(function(){
		$("#img-checkid").hide();
		$("#btn-checkid").show();
		idCheck="no";
	});
	
	$("#btn-checkid").click(function(){
		let id = $("#id").val();
		if(id==""){
			return;
		}
		$.ajax({
			url: "${pageContext.request.contextPath }/user/api/checkid?id=" + id,
			type: "get",
			dataType: "json",
			success: function(response) {
				if(response.result!=="success"){
					console.error(response.message);
					console.log("작전 실패!!!!")
					return;
				}
				if(response.data){
					alert("존재하는 아이디입니다. 다른 아이디를 사용하세요");
					$("#id")
					.val("")
					.focus();
					return ;
				}
				
				$("#img-checkid").show();
				$("#btn-checkid").hide();
				idCheck="yes";
				
			},
			error: function(xhr, status, e) {
				console.error(status, e);
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
	
		<div id="user-join">
			<form id="join-form" action="${pageContext.request.contextPath }/user/join" method="post">
				<input placeholder="아이디" id="id" name="id" type="text" value="">
				<button id="btn-checkid" >중복체크</button>
				<img id="img-checkid" src="${pageContext.request.contextPath }/assets/images/check.png" width="16px" style="display:none"><br>
				<input placeholder="비밀번호" id="password" name="password" type="text" value=""><br>
				<input placeholder="이름" id="name" name="name" type="text" value=""><br>
				<input placeholder="이메일" id = "email" name="email" type="text" value=""><br>
				<input type="submit" value="가입하기">
			</form>
		</div>
		
	</div>
	
	<c:import url="/WEB-INF/views/includes/footer.jsp"/>
	
</div>
</body>
</html>