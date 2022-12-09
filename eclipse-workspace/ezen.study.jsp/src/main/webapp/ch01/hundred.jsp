<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
	int result = 0; //1부터 100까지 누적된 값을 저장할 변수를 선언하고 초기화한다.
	
	for(int i = 0; i <= 100; i++){
		result += i;
	}
	System.out.println("더한 결과: " + result);
	%>


	<h1>1부터 100까지 더하면 얼마인가요? <%= result %></h1>
	
</body>
</html>