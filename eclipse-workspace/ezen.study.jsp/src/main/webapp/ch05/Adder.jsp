<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
int num1 = 0, num2 = 0, sum = 0;

//예외가 발생할 경우 Error Page를 만들어서 호출하기
try {
	String str1 = request.getParameter("NUM1");
	String str2 = request.getParameter("NUM2");
	num1 = Integer.parseInt(str1);
	num2 = Integer.parseInt(str2);
	sum = num1 + num2;
} catch (NumberFormatException e) {
	System.out.println("입력한 값이 숫자 형식에 맞지 않습니다.");
	RequestDispatcher dispatcher = request.getRequestDispatcher("DataError.jsp");
	dispatcher.forward(request, response);
}
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