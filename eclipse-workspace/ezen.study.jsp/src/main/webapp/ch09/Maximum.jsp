<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>최대값은?</title>
	</head>
	<body>
		<h1>최대값 구하기</h1>
		<hr/>
		<c:if test="${ param.NUM1 - param.NUM2 > 0 }">
			<h2>${ param.NUM1 }</h2>
		</c:if>
		<c:if test="${ param.NUM1 - param.NUM2 < 0 }">
			<h2>${ param.NUM2 }</h2>
		</c:if>
		<c:if test="${ param.NUM1 - param.NUM2 == 0 }">
			<h2>두 수는 같습니다.</h2>
		</c:if>
	</body>
</html>