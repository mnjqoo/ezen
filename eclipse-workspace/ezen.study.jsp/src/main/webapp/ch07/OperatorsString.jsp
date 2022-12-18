<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
	</head>
	<body>
		<h1>두 문자열 비교</h1>
		<h2>입력된 문자열은 ${param.STR1 }, ${param.STR2 } 입니다.</h2>
		<h2>두 문자열이 같은가요? ${param.STR1 eq param.STR2 }</h2>
		<h2>어떤 문자열이 먼저인가요? ${param.STR1 lt param.STR2 ? param.STR1 : param.STR2 }</h2>
	</body>
</html>