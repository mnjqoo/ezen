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
			String appPath = application.getContextPath();
			String filePath = application.getRealPath("/sub1/sub1.html");
		%>
		
		<h1>웹 어플리케이션의 URL 경로명: <%= appPath %></h1>
		<h1>/sub1/sub1.html의 파일 경로 명: <%= filePath %></h1>
	</body>
</html>