<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page errorPage="DataError.jsp" %> <%//web.xml에 쓴 errorPage보다 우선순위가 높다. %>
<% response.setStatus(200); %> <%//인위적으로 HTTP 상태 코드 값을 200(정상)으로 바꾼다. %>
<%
int num1 = 0, num2 = 0, sum = 0;

String str1 = request.getParameter("NUM1");
String str2 = request.getParameter("NUM2");
num1 = Integer.parseInt(str1);
num2 = Integer.parseInt(str2);
sum = num1 + num2;
%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>두 숫자 더하기</title>
	</head>
	<body>
		<h1>덧셈 프로그램</h1>
		<hr/>
		<h1><%=num1 %> + <%= num2 %> = <%= sum %></h1>
	</body>
</html>