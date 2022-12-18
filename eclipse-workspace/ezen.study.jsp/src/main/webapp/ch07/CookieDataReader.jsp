<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%


%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>쿠키 데이터 읽기</title>
	</head>
	<body>
		<h1>쿠키 데이터 읽기</h1>
		<h2>${cookie }</h2> <!-- EL식은 쿠키 값이 아닌 쿠키 객체를 가져온다. -->
		
		<!-- 쿠키의 값을 출력한다. -->
		<h2>NAME 쿠키의 값은? ${cookie.NAME.value }</h2>
		<h2>도메인의 값은? ${cookie.NAME.domain }</h2>
		<h2>경로의 값은? ${cookie.NAME["path"] }</h2>
		<h2>쿠키의 수명은? ${cookie.NAME["maxAge"] }</h2>
	</body>
</html>