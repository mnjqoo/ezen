<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
	</head>
	<body>
		<h1>나의 이름은?</h1>
		<h2>안녕하십니까? <%=request.getParameter("YOURNAME") %> 님, 방문해주셔서 감사합니다.</h2>
	</body>
</html>