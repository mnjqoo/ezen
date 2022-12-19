<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<%
String str1 = request.getParameter("NUM1");
String str2 = request.getParameter("NUM2");
int num1 = Integer.parseInt(str1);
int num2 = Integer.parseInt(str2);

%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>나누기 프로그램</title>
	</head>
	<body>
		<h1>두 수 나누기</h1>
		<c:catch var="e">
			<% int result = num1 / num2; %>
			<h2>나누기 결과: <%= result %></h2>
		</c:catch>
		<c:if test="${ e != null }"> <!-- 예외가 발생하면 -->
			<h2>에러 메세지: ${ e.message }</h2>
			<h2>0으로 나누시면 안됩니다.</h2>
		</c:if>
	</body>
</html>