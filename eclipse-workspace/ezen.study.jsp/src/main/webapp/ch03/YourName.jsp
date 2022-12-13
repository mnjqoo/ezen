<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
	</head>
	<body>
		<h1>당신의 이름을 입력하세요!</h1>
		<form action = "YourNameIs.jsp" method="get">
			<h2>이름: <input type="text" name="YOURNAME"/></h2>
			<input type="reset" value="다시입력"/>
			<input type="submit" value="확인"/>
		</form>
	</body>
</html>