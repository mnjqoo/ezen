<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% String result = request.getParameter("RESULT"); %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
	</head>
	<body>
		<h1>회원 가입 결과</h1>
		<%
			if(result.equals("SUCCESS")){
				out.println("<h2>회원가입이 되었습니다.</h2>");
			} else {
				out.println("<h2>회원가입이 되지 않았습니다.</h2>");
			}
		%>
	</body>
</html>