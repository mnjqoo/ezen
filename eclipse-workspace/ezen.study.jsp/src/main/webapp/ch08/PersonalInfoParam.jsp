<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html> 
<html>
	<head>
		<meta charset="UTF-8">
		<title>회원정보</title>
	</head>
	<body>
		<jsp:useBean class="ch08.PersonalInfo" id="pinfo">
			<jsp:setProperty property="name" name="pinfo" param="NAME"/>
			<jsp:setProperty property="age" name="pinfo" param="AGE"/>
			<jsp:setProperty property="gender" name="pinfo" param="GENDER"/>
		</jsp:useBean>
		<h1>회원 정보</h1>
		<hr/>
		<h2>이름: <jsp:getProperty property="name" name="pinfo"/></h2>
		<h2>성별: <jsp:getProperty property="gender" name="pinfo"/></h2>
		<h2>나이: <jsp:getProperty property="age" name="pinfo"/></h2>
		
	</body>
</html>