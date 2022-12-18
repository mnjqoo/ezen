<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Empty</title>
	</head>
	<body>
		<h1>Empty 연산자</h1>
		<h2>Empty 연산자는 데이터의 존재 여부를 확인하는 단항 연산자이다.</h2>
		<h2>피연산자인 데이터 이름은 empty 연산자 다음에 기술해야한다.</h2>
		<hr/>
		<h1>안녕하세요? ${empty param.ID ? "손" : param.ID }님</h1>
		<h1>안녕하세요? ${param.ID == null ? "손" : param.ID }님</h1>
	</body>
</html>