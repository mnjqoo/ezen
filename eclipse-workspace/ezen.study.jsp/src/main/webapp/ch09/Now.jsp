<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<c:set var="date" value="<%= new Date() %>"/>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>현재의 시간</title>
	</head>
	<body>
		<h1>현재의 시간</h1>
		<h2>현재 날짜와 시간: ${ date }</h2>
		<hr/>
		<h2>오늘의 날짜: <fmt:formatDate value="${date}" type="date"/></h2>
		<h2>현재의 시각: <fmt:formatDate value="${date}" type="time"/></h2>
		<h2>현재의 날짜와 시각: <fmt:formatDate value="${date}" type="both"/></h2>
	</body>
</html>