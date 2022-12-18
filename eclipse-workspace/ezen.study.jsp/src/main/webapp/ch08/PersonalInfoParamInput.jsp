<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>회원정보</title>
	</head>
	<body>
		<%
			/*
			회원 정보를 입력 받아서 다음 페이지로 넘어가자.
			회원 정보: 이름, 성별, 나이를 입력받도록 한다.
			회원 정보를 가지고 이동할 페이지는 PersonalInfoParam.jsp
			*/
			
		%>
		<h1>회원 정보를 입력해주세요.</h1>
		<form action="PersonalInfoParam.jsp" method="get">
			<h2>이름: <input type="text" name="NAME"></h2>
			<h2>성별: <br>
			여 <input type="radio" name="GENDER" value="여">
			남 <input type="radio" name="GENDER" value="남">
			</h2>
			<h2>나이: <input type="text" name="AGE"></h2>
			<input type="reset" value="다시 입력">
			<input type="submit" value="확인">
		</form>
	</body>
</html>