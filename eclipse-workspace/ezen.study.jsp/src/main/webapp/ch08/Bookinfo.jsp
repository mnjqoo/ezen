<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>책 소개</title>
	</head>
	<body>
		<h1>책 소개</h1>
		<h2>제목: 소나기</h2>
		<h2>저자: 황순원</h2>
		<h2>가격: 17,000원</h2>
		<jsp:include page="Copyright.html"/> <!-- jsp 페이지가 실행 될 때 동적으로 해당 웹 페이지를 읽어서 포함한다.(표준 액션) -->
		<hr/>
		<%@ include file="Copyright.html" %> <!-- jsp가 서블릿 클래스로 변환 될 때 해당 웹 자원을 읽어서 서블릿 클래스의 코드의 일부로 만든다. -->
	</body>
</html>