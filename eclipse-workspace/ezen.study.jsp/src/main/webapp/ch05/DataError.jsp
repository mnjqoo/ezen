<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>더하기 프로그램 예외처리 화면</title>
	</head>
	<body>
		<h1>더하기 프로그램 예외처리 화면</h1>
		<hr/>
		<h1>숫자형식의 데이터가 아닌 잘못된 데이터를 입력하셨습니다.</h1>
		<h1>상세 에러 페이지 : <%=exception.getMessage() %></h1>
	</body>
</html>