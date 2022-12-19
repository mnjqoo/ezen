<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>HTML 문법</title>
	</head>
	<body>
		<h3>Font Tag</h3>
		<font size="7">커다란 글자</font>
		<hr/>
		<c:out value="<font size=7>커다란 글자</font>는 다음과 같이 화면에 나타납니다." escapeXml="false"/>
	</body>
</html>