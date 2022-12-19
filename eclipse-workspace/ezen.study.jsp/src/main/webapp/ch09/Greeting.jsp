<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>방문인사</title>
	</head>
	<body>
		<h1>방문인사</h1>
		<hr/>
		<c:choose>
			<c:when test="${ param.NUM == 0 || param.NUM == null }">
				<h2>반갑습니다. 저희 사이트에 처음 방문하셨군요!</h2>
			</c:when>
			<c:when test="${ param.NUM == 1 }">
				<h2>두번째 방문이시군요. 즐거운 시간 되십시오.</h2>
			</c:when>
			<c:otherwise>
				<h2>감사합니다. 자주 방문하시는군요.</h2>
			</c:otherwise>
		</c:choose>
	</body>
</html>