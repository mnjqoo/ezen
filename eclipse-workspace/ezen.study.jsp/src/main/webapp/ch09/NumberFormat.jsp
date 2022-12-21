<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>숫자형식</title>
	</head>
	<body>
		<h1>숫자 형식</h1>
		<hr/>
		<h2>첫번째 수 : <fmt:formatNumber value="123456789" groupingUsed="true"/>원</h2>
		<h2>두번째 수 : <fmt:formatNumber value="3.14158" pattern="#.###"/></h2>
		<h2>세번째 수 : <fmt:formatNumber value="10.8" pattern="#.000"/></h2>
	</body>
</html>