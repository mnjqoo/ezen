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
		<% //PersonalInfo pinfo = new PersonalInfo(); %>
		<jsp:useBean id="pinfo2" class="ch08.PersonalInfo"/>
		<jsp:setProperty name="pinfo2" property="name" value="희동이"/>
		<jsp:setProperty name="pinfo2" property="gender" value="남"/>
		<jsp:setProperty name="pinfo2" property="age" value="5"/>
		<h1>회원 정보</h1>
		<hr/>
		<h2>이름: <jsp:getProperty property="name" name="pinfo2"/></h2>
		<h2>성별: <jsp:getProperty property="gender" name="pinfo2"/></h2>
		<h2>나이: <jsp:getProperty property="age" name="pinfo2"/></h2>
		
	</body>
</html>