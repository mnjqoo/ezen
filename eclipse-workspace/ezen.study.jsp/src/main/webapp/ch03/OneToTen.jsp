<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
	</head>
	<body>
		<h1>1부터 10까지 순서대로 출력해봅시다.</h1>
		<% for(int i = 0; i <= 10; i++){
			out.println("<h2>" + i + "</h2>");			
			}
		%>
		
	</body>
</html>