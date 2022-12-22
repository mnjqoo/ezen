<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="sec02.ex02.MemberVO" %>
<%@ page import="sec02.ex02.MemberDAO" %>
<%
String id = request.getParameter("id");
MemberDAO memberDAO = new MemberDAO();
MemberVO memberVO = memberDAO.getMember(id);
%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>회원 정보 수정 화면</title>
		<script>
		function fn_updateMember() {
			var frmMember = document.frmMember;
			var id = frmMember.id.value;
			var pwd = frmMember.pwd.value;
			var name = frmMember.name.value;
			var email = frmMember.email.value;
			
			//alert(id);
			if(id.length == 0 || id == ""){
				alert("아이디는 필수 입력 항목입니다.");
			} else if(pwd.length == 0 || pwd == ""){
				alert("비밀번호는 필수 입력 항목입니다.");
			} else if(name.length == 0 || name == ""){
				alert("이름은 필수 입력 항목입니다.");
			} else if(email.length == 0 || email == ""){
				alert("이메일은 필수 입력 항목입니다.");
			} else {
				frmMember.method = "post";
				frmMember.action = "/member22";
				frmMember.submit();
			}
		}
		</script>
	</head>
	<body>
		<form name="frmMember">
			<table>
				<tr>
					<th colspan="2" align="center"><h2>회원 정보 수정</h2></th>
				</tr>
				<tr>
					<td class="title">아이디</td>
					<td><input type="text" name="id" value="<%= memberVO.getId() %>" readonly/></td> 
					<%-- readonly : input type ="text" 에서만 가능. 사용자는 value 값을 변경 할 수 없다. 
						 disabled : 모든 input 객체에 대하여 비활성화 처리가 가능하다. submit 시 해당 객체는 전송이 안된다.	--%>
				</tr>
				<tr>
					<td class="title">비밀번호</td>
					<td><input type="password" name="pwd" value="<%= memberVO.getPwd() %>"/></td>
				</tr>
				<tr>
					<td class="title">이름</td>
					<td><input type="text" name="name" value="<%= memberVO.getName() %>"/></td>
				</tr>
				<tr>
					<td class="title">이메일</td>
					<td><input type="text" name="email" value="<%= memberVO.getEmail() %>"/></td>
				</tr>
			</table>
			<hr/>
			<input type="reset" value="다시입력"/>
			<input type="button" value="수정하기" onclick="fn_updateMember()"/>
			<input type="hidden" name="command" value="updateMember"/>
		</form>
	</body>
</html>