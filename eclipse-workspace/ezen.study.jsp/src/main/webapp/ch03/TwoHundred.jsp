<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
	</head>
	<body>
		<%  int total = 0; 
			for(int i = 0; i <= 100; i++){
				total += i;
			}
		%>
		<h1>1부터 100까지 더한 값은 <%=total %>입니다.</h1>
		<% 	
			for(int i = 101; i <= 200; i++){
				total += i;
			}
		%>
		<h1>1부터 200까지 더한 값은 <%=total %>입니다.</h1>
		
		<h1>1부터 200까지 더한 값에서 1000을 빼면 <%=total - 1000 %>입니다.</h1>
	</body>
</html>