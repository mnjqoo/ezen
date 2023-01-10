<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c"	uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<%	request.setCharacterEncoding("UTF-8"); %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>회원 목록</title>
	</head>
	<body>
		<%
		if(session.getAttribute("isLogOn") == null || session.getAttribute("isLogOn").equals("")) { //로그인 되어있지 않으면
			response.sendRedirect("/member/loginForm.do"); //로그인 화면으로 돌려보낸다.
		}
		%>
		
		<!-- 상단 메뉴 바 -->
		<jsp:include page="../common/topMenu.jsp" flush="false"/>
		
		<!-- 회원 목록 -->
		<div class="container">
			<h1 align="center">회원 전체 목록</h1>
			<a href="${contextPath}/member/logout.do" class="btn btn-danger"><span class="glyphicon glyphicon-log-out"></span> 로그아웃</a>
			<br/>
			<br/>
			
			<table class="table table-bordered table-striped table-hover" style="width:1200px; margin:auto;">
				<tr class="info"> <!-- 타이틀 -->
					<td align="center" width="80"><b>아이디</b></td>
					<td align="center" width="80"><b>비밀번호</b></td>
					<td align="center" width="80"><b>이름</b></td>
					<td align="center" width="300"><b>이메일</b></td>
					<td align="center" width="120"><b>가입날짜</b></td>
					<td align="center" width="60"><b>수정</b></td>
					<td align="center" width="100"><b>삭제 (Yes/No)</b></td>
					<td align="center" width="60"><b>삭제</b></td>
				</tr>
				
				<!-- 내용 -->
				<c:forEach var="member" items="${membersLists}">
					<tr>
						<td align="center">${member.id}</td>
						<td align="center">${member.pwd}</td>
						<td align="center">${member.name}</td>
						<td align="center">${member.email}</td>
						<td align="center">${member.joinDate}</td>
						<td align="center"><a class="btn btn-sm btn-primary" href="${contextPath}/member/updateMemberForm.do?id=${member.id}">수정</a></td>
						<td align="center"><a class="btn btn-sm btn-warning" href="javascript:removeMember('${member.id}');">삭제 (Yes/No)</a></td>
						<td align="center"><a class="btn btn-sm btn-danger" href="${contextPath}/member/removeMember.do?id=${member.id}">삭제</a></td>
					</tr>
				</c:forEach>
			</table>
			
		</div>
		
		<!-- footer -->
		<jsp:include page="../common/footer.jsp" flush="false"/>
		
		<script>
		<!-- 회원정보를 삭제하기 전에 삭제여부를 확인하는 스크립트 -->
		function removeMember(id){
			if(!confirm(id + "회원의 정보를 삭제하시겠습니까?\n\n 삭제를 하시려면 [확인] 버튼을 누르시고, 아니면 [취소] 버튼을 누르세요.")) {
				alert("회원 정보 삭제를 취소하셨습니다.");
			} else {
				alert("회원 정보를 삭제합니다.");
				location.href="/member/removeMember.do?id=" + id;
			}
		}
		</script>
	</body>
</html>