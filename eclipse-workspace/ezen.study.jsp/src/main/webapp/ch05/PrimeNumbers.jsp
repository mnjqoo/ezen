<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
String str = request.getParameter("NUM");
int num = Integer.parseInt(str);
%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>소수 보여주기</title>
	</head>
	<body>
		<h1>소수 보여주기</h1>
		<%
			//java.lang.ArrayIndexOutOfBoundsException: 배열의 범위를 벗어날 경우
			int prime[] = {2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31};
			for(int i = 0; i < num; i++){
				out.println("<h1>" + prime[i] + "</h1>");
			}
		%>
	</body>
</html>