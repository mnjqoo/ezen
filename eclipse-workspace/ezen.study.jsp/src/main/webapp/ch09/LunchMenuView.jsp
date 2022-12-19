<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html> 
<html>
	<head>
		<meta charset="UTF-8">
		<title>점심메뉴</title>
	</head>
	<body>
		<h1>오늘의 점심 식단</h1>
		<ul>
			<c:forEach var="dish" items="${ MENU }">
				<li><h2>${ dish }</h2></li>
			</c:forEach>
		</ul>
	</body>
</html>