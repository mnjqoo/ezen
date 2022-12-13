<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
	</head>
	<body>
		<%
			int result = 1;
			for(int i = 1; i <= 10; i++){
				result *= i;
			}
		%>
		<h1>1부터 10까지 곱한 결과는 <%= result %></h1>
	</body>
</html>