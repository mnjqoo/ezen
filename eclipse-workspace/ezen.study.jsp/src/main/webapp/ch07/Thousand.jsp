<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
//1부터 1000까지 정수의 합
int sum = 0;
for(int i = 1; i <=1000; i++) {
	sum += i;
}
pageContext.setAttribute("RESULT", sum);
%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
	</head>
	<body>
		<h1>page attribute</h1>
		<h1>1부터 1000까지 정수의 합은 얼마인가요?</h1>
		<h1>정답: ${RESULT }</h1>
	</body>
</html>