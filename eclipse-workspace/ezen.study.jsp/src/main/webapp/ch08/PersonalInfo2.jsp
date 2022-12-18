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
		<jsp:useBean id="pinfo" class="ch08.PersonalInfo">
			<jsp:setProperty name="pinfo" property="name" value="희동이"/>
			<jsp:setProperty name="pinfo" property="gender" value="남"/>
			<jsp:setProperty name="pinfo" property="age" value="5"/>
		</jsp:useBean>
		<h1>회원 정보</h1>
		<h2>${ pinfo }</h2>
		<hr/>
		<h2>이름: <jsp:getProperty property="name" name="pinfo"/></h2>
		<h2>성별: <jsp:getProperty property="gender" name="pinfo"/></h2>
		<h2>나이: <jsp:getProperty property="age" name="pinfo"/></h2>
		
	</body>
</html>