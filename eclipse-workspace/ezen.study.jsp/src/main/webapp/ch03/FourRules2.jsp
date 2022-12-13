<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
	</head>
	<body>
	
		<h1>두 수를 더하면 <%= getnum(request.getParameter("NUM1")) + getnum(request.getParameter("NUM2")) %></h1>
		<h1>두 수를 빼면 <%= getnum(request.getParameter("NUM1")) - getnum(request.getParameter("NUM2")) %></h1>
		<h1>두 수를 곱하면 <%= getnum(request.getParameter("NUM1")) * getnum(request.getParameter("NUM2")) %></h1>
		<h1>두 수를 나누면 <%= getnum(request.getParameter("NUM1")) / getnum(request.getParameter("NUM2")) %></h1>
	</body>
</html>
<%! 
private int getnum (String num) {
	return Integer.parseInt(num);
}

%>
