<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
//전 페이지에서 넘겨준 데이터(문자열)을 변수에 저장한다.
String str1 = request.getParameter("NUM1");
String str2 = request.getParameter("NUM2");

int num1 = Integer.parseInt(str1);
int num2 = Integer.parseInt(str2);

//request 변수에 새로운 변수와 사칙연산한 값을 저장한다. request.setAttribute(변수명, 값);
request.setAttribute("PLUSE", (num1 + num2));
request.setAttribute("MINUS", (num1 - num2));
request.setAttribute("MULTIPLY", (num1 * num2));
request.setAttribute("DIVIDE", (num1 / num2));

RequestDispatcher dispatcher = request.getRequestDispatcher("FourRulesResult.jsp");
dispatcher.forward(request, response);
%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
	</head>
	<body>
		
	</body>
</html>
