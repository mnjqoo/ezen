<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>숫자 포멧</title>
	</head>
	<body>
		<h1>숫자 포멧</h1>
		<hr/>
		<h2>금액: <fmt:formatNumber value="1234567890" type="currency" currencySymbol="￦"/></h2>
		<h2>금액: <fmt:formatNumber type="currency" currencySymbol="＄">123456789</fmt:formatNumber></h2>
		<h2>퍼센트: <fmt:formatNumber type="percent">1</fmt:formatNumber></h2>
	</body>
</html>