<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
Cookie cookie = new Cookie("NAME", "희동이");
response.addCookie(cookie);

%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>쿠키 데이터 저장</title>
	</head>
	<body>
		<h1>쿠키의 값이 설정되었습니다.</h1>
	</body>
</html>