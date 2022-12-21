<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>반복문</title>
	</head>
	<body>
		<c:forEach var="cnt" begin="1" end="10">
			<font size=${cnt}}>Hi~~</font><hr/>
		</c:forEach>
		<c:forEach var="cnt" begin="1" end="10" step="2">
			<font size=${cnt}}>Hi~~</font><hr/>
		</c:forEach>
		
	</body>
</html>