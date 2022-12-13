<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% Cookie[] cookies = request.getCookies(); %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
	</head>
	<body>
		<h1>쿠키 정보 보여주기</h1>
		<h2>이름: <%= getCookieValue(cookies, "NAME") %></h2>
		<h2>성별: <%= getCookieValue(cookies, "GENDER") %></h2>
		<h2>나이: <%= getCookieValue(cookies, "AGE") %></h2>
	</body>
</html>

<%!
//쿠키에 사용된 이름으로 데이터를 검색하는 메소드
private String getCookieValue(Cookie[] cookies, String name){
	
	if(cookies == null) //조사할 데이터가 없다면
		return null;
	
	for(Cookie cookie : cookies) {
		if(cookie.getName().equals(name)){ //name에 해당하는 이름을 찾았다면 값을 돌려준다.
			return cookie.getValue();
		}
	}
	
	return null;
}
%>