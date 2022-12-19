<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
	</head>
	<body>
		<!-- 스크립팅 요소를 대신하는 표준액션을 사용하자.
			 2개의 정수를 get방식으로 받아서 사칙연산 결과를 보여주세요.
			 사칙연산은 메소드를 이용해서 만들어보십시오. 
			 두 수를 입력하는 Adder.html를 만들어봅시다.-->
		<jsp:scriptlet>
			String str1 = request.getParameter("NUM1");
			String str2 = request.getParameter("NUM2");
			int num1 = Integer.parseInt(str1);
			int num2 = Integer.parseInt(str2);
		</jsp:scriptlet>
		<% if(num1 > 0 && num2 > 0) { %>
			<h1>두 수를 더하면?</h1>
			<h2><jsp:expression>add(num1, num2)</jsp:expression></h2>
			<h1>두 수를 빼면?</h1>
			<h2><jsp:expression>minus(num1, num2)</jsp:expression></h2>
			<h1>두 수를 곱하면?</h1>
			<h2><jsp:expression>muliply(num1, num2)</jsp:expression></h2>
			<h1>두 수를 나누면?</h1>
			<h2><jsp:expression>divide(num1, num2)</jsp:expression></h2>
		<%} else { %>
			<h1>계산하려는 숫자는 양수를 입력하셔야 합니다.</h1>
		<%} %>
		
	</body>
</html>
<jsp:declaration>
	private int add(int num1, int num2){
		return num1 + num2;
	}
	private int minus(int num1, int num2){
		return num1 - num2;
	}
	private int muliply(int num1, int num2){
		return num1 * num2;
	}
	private int divide(int num1, int num2){
		return num1 / num2;
	}
</jsp:declaration>