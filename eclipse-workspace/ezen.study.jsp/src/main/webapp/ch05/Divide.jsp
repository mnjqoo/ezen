<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
//get 방식으로 넘어온 데이터를 변수에 저장한다.
String str1 = request.getParameter("NUM1");
String str2 = request.getParameter("NUM2");

//계산하기 위해 문자열을 숫자로 변환한다.
int num1 = Integer.parseInt(str1);
int num2 = Integer.parseInt(str2);
int result = num1 / num2;
%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
	</head>
	<body>
		<h1>나눗셈 결과</h1>
		<h2><%= num1 %> / <%= num2 %> = <%= result %></h2>
	</body>
</html>