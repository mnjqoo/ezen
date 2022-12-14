<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page isErrorPage="true" %>
<% response.setStatus(200); %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>산술 연산 에러</title>
	</head>
	<body>
		<h1>산술 연산 에러</h1>
		<h2>산술 연산 도중에 에러가 발생하였습니다.</h2>
		<h2>상세 에러 메시지: <%= exception.getMessage() %></h2>
	</body>
</html>