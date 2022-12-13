<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
response.addCookie(new Cookie("NAME", "Dooley"));
response.addCookie(new Cookie("GENDER", "여자"));
response.addCookie(new Cookie("AGE", "5000"));
%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
	</head>
	<body>
		<h1>쿠키 데이터가 저장되었습니다.</h1>
	</body>
</html>