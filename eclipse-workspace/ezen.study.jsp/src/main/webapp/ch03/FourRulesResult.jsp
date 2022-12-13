<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
	</head>
	<body>
		<h1><%= request.getParameter("NUM1") %>, <%= request.getParameter("NUM2") %>의 사칙연산 결과</h1>
		<h2>덧셈의 결과 : <%= request.getAttribute("PLUSE") %></h2>
		<h2>뺄셈의 결과 : <%= request.getAttribute("MINUS") %></h2>
		<h2>곱셈의 결과 : <%= request.getAttribute("MULTIPLY") %></h2>
		<h2>나눗셈의 결과 : <%= request.getAttribute("DIVIDE") %></h2>
		
	</body>
</html>