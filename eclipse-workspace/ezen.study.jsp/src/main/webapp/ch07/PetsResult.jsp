<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
	</head>
	<body>
		<h1>${param.ID }님이 기르고 있는 애완동물</h1>
		<hr/>
		<h2>${paramValues.ANIMAL[0] }</h2>
		<h2>${paramValues.ANIMAL[1] }</h2>
		<h2>${paramValues.ANIMAL[2] }</h2>
		<h2>${paramValues.ANIMAL[3] }</h2>
	</body>
</html>