<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<c:set var="date" value="<%= new Date() %>"/>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>현재의 날짜와 시각</title>
	</head>
	<body>
		<h1>현재의 날짜와 시각</h1>
		<hr/>
		<h1>[오늘의 날짜] <fmt:formatDate value="${ date }" type="date" pattern="yyyy/mm/dd"/></h1>
		<h1>[오늘의 날짜] <fmt:formatDate value="${ date }" type="date" pattern="yyyy년mm월dd일"/></h1>
		<h1>[현재의 사각] <fmt:formatDate value="${date }" type="time" pattern="(a) hh:mm:ss"/></h1>
	</body>
</html>