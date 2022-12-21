<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<c:set var="date" value="<%= new Date() %>"/>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>오늘의 날짜와 시각</title>
	</head>
	<body>
		<h1>오늘의 날짜와 시각</h1><hr/>
		<h2>[S] <fmt:formatDate value="${ date }" type="both" dateStyle="short" timeStyle="short"/></h2>
		<h2>[M] <fmt:formatDate value="${ date }" type="both" dateStyle="medium" timeStyle="medium"/></h2>
		<h2>[L] <fmt:formatDate value="${ date }" type="both" dateStyle="long" timeStyle="long"/></h2>
		<h2>[F] <fmt:formatDate value="${ date }" type="both" dateStyle="full" timeStyle="full"/></h2>
	</body>
</html>