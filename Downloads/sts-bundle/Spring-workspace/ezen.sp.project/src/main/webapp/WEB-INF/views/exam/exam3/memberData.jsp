<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
	</head>
	<body>
		<jsp:include page="../../common/topMenu.jsp" flush="false"/>
		<div class="container">
			<h1>회원 정보</h1>
			<h2>MemberVO</h2>
			<h2>MemberVO 아이디: ${member.userId }</h2>
			<h2>MemberVO 비밀번호: ${member.userPw }</h2>
			<hr/>
			
			<h1>회원 정보</h1>
			<h2>Map</h2>
			<h2>Map 아이디: ${map.userId }</h2>
			<h2>Map 비밀번호: ${map.userPw }</h2>
		</div>
	</body>
</html>