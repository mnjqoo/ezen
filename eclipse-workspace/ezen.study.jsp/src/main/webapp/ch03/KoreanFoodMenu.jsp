<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
	</head>
	<body>
		<h1>오늘의 한식 메뉴</h1>
		<h2>김치찌개</h2>
		<h2>된장찌개</h2>
		<h2>불고기 백반</h2>
		<h2>냉면</h2>
		<%
			out.flush();
			RequestDispatcher dispatcher = request.getRequestDispatcher("Now.jsp");
			dispatcher.include(request, response);
		%>
	</body>
</html>