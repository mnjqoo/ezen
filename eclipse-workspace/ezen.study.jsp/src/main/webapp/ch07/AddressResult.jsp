<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>회원 주소록</title>
	</head>
	<body>
		<h1>회원 주소록</h1>
		<h2>${param.NAME }의 주소는 ${ADDRESS[param.NAME] }</h2>
		<h2>${param.NAME }의 주소는 ${ADDRESS.param.NAME }</h2> <!-- []를 사용해야함 -->
		
		
	</body>
</html>