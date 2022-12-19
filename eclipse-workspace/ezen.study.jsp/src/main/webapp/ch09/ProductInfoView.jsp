<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<c:remove var="NAME" scope="request"/><!-- request 데이터 영역에 있는 변수를 제거한다. -->

<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>상품 정보</title>
	</head>
	<body>
		<h1>상품 정보</h1>
		<hr/>
		<h2>상품 코드: ${ CODE }</h2>
		<h2>상품 명: ${ NAME }</h2>
		<h2>상품 가격: ${ PRICE }</h2>
	</body>
</html>