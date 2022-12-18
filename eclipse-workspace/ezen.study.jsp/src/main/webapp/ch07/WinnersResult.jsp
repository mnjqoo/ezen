<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>우승자 명단</title>
	</head>
	<body>
		<h1>우승자 명단</h1>
		<h2>${WINNERS}</h2> <!-- 주소값이 나온다. -->
		<h2>1등: ${WINNERS[0]}</h2>
		<h2>2등: ${WINNERS[1]}</h2>
		<h2>3등: ${WINNERS[2]}</h2>
	</body>
</html>