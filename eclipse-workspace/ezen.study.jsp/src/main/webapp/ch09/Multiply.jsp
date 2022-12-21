<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="num1" value="10"/>
<c:set var="num2" value="5"/>
<c:set var="result" value="${ num1*num2 }"/> 
<%-- 이렇게 선언한 변수는 익스프레션 언어의 EL식 안에서 사용할 수 있다. 
	 하지만 스크립팅 요소 안에서는 사용할 수 없다.
	 <c:set> 커스텀 액션을 이용해서 선언한 변수는 자바 변수가 되는 것이 아니라,
	 page 데이터 영역의 attribute가 되기 때문이다.--%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>곱셈 프로그램</title>
	</head>
	<body>
		<h1>곱셈 프로그램</h1>
		<h1>${ num1 } x ${ num2 } = ${ result }</h1>
		
		<% for(int i = 1; i <=5; i++) {%>
			<h2>안녕하세요?</h2>
		<jsp:scriptlet>
		}	
		</jsp:scriptlet>
		
		<c:forEach begin="1" end="5">
			<h2>안녕하세요 jstl core입니다.</h2>
		</c:forEach>
	</body>
</html>