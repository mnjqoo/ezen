<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="ch08.PersonalInfo" %>
<!DOCTYPE html>
<html> 
	<head>
		<meta charset="UTF-8">
		<title>회원 정보</title>
	</head>
	<body>
		<jsp:useBean id="pinfo" class="ch08.PersonalInfo" scope="request"/> 
		<!-- jsp:useBean 주어진 scope 영역에 id값에 해당하는 자바빈 객체가 없을 경우에만 새로운 객체를 생성하고, 그런 객체가 있으면 그 객체를 가져다 사용한다. -->
		<h1>회원 정보</h1>
		<hr/>
		<h2>이름: <jsp:getProperty property="name" name="pinfo"/></h2>
		<h2>성별: <jsp:getProperty property="gender" name="pinfo"/></h2>
		<h2>나이: <jsp:getProperty property="age" name="pinfo"/></h2>
		
	</body>
</html>