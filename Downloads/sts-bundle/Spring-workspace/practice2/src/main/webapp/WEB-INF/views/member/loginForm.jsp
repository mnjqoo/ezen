<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>로그인 화면</title>
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
		<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
		<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">
		<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>	
		<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
		<!-- MEMBER CSS -->
		<link href="/resources/css/common.css" rel="stylesheet" type="text/css">
		<link href="/resources/css/member.css" rel="stylesheet" type="text/css">
		<!-- MEMBER JS -->
		<script src="/resources/js/member.js"></script>
	</head>
	<body style="background-color: #17465a;">
		<div>
			<!-- 상단 메뉴 바 -->
			<jsp:include page ="../common/mainTopNav.jsp"></jsp:include>
			
			<div class="container" id="loginForm">
				<h3>어쩌구 저쩌구 </h3>
				<div id="loginBox">
					<p class="login_label">이메일</p>
					<input type="text" name="email" id="email"/>
					<p class="login_label">비밀번호</p>
					<input type="password" name="password" id="password"/>
					<button type="button" onClick="fn_loginCheck();">로그인</button>
					<p id="login_register">아직 회원이 아니신가요? <a href="/member/register.form">회원가입하기</a></p>
				</div>
			</div>
			
				
			
		</div>
		<div id="login_footer">
			<jsp:include page="../common/footer.jsp" flush="false"></jsp:include>
		</div>
	</body>
</html>