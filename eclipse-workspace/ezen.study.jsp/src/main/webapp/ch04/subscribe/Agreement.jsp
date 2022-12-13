<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
request.setCharacterEncoding("UTF-8");
//넘겨 받은 정보를 변수에 저장한다.
String id = request.getParameter("ID");
String password = request.getParameter("PASSWORD");
String name = request.getParameter("NAME");

//정보를 변수를 이용해 세션에 저장한다.
session.setAttribute("ID", id);
session.setAttribute("PASSWORD", password);
session.setAttribute("NAME", name);
%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
	</head>
	<body>
		<h2>회원 가입 약관</h2>
		<hr/>
		<h3>1.회원정보는 웹사이트의 운영을 위해서만 사용됩니다.</h3>
		<h3>2.웹사이트의 정상 운영을 방해하는 회원은 탈퇴 처리합니다.</h3>
		<hr/>
		<form action = "Subscribe.jsp" method="post">
			<h4>위 약관에 동의하십니까?</h4>
			<h4><input type="radio" name="AGREE" value="YES" checked/>동의함</h4>
			<h4><input type="radio" name="AGREE" value="NO"/>동의하지 않음</h4>
			<hr/>
			<input type="reset" value="다시입력"/>
			<input type="submit" value="확인"/>
		</form>
	</body>
</html>