<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>개인정보 입력 화면</title>
	</head>
	<body>
		<h1>개인 정보 입력</h1>
		
		<form action="/pinfo-result" method="get">
			이름: <input type="text" name="NAME"/><br/>
			아이디: <input type="text" name="ID"/><br/>
			비밀번호: <input type="password" name="PASSWORD"/><br/>
			성별: 여 <input type="radio" name="GENDER" value="FEMALE" checked/> 
				  남 <input type="radio" name="GENDER" value="MALE"/><br/>
			<hr/>
			메일 수신 여부: <br/>
				공지 메일 <input type="checkbox" name="INOTICE"/>
				광고 메일 <input type="checkbox" name="CNOTICE"/>
				배송 확인 메일 <input type="checkbox" name="DNOTICE"/><br/><br/>
				
			직업:
				<select name="JOB">
					<option>프로그래머</option>
					<option>회사원</option>
					<option>전기기술자</option>
					<option>아티스트</option>
				</select>
			<br/><br/>
			자기소개: <br/>
				<textarea name="MYINFO" cols="100" rows="6"></textarea>
			<hr/>
			<input type="reset" value="다시 작성"/>
			<input type="submit" value="작성 완료"/>
		</form>
	</body>
</html>