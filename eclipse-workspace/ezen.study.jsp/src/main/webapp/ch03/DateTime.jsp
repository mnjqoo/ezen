<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.GregorianCalendar" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
	</head>
	<body>
	
		<%
			GregorianCalendar now = new GregorianCalendar();
			String date = String.format("%TF", now);
			String time = String.format("%TT", now);
		%>
		<h1>오늘의 날짜와 시각</h1><hr/>
		<h2>오늘의 날짜: <%= date %></h2>
		<h2>오늘의 시각: <%= time %></h2>
	</body>
</html>