<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>두 수의 합은?</title>
	</head>
	<body>
		<!-- JSP 표준 액션에는 스크립팅 요소인 스크립틀릿, 익스프레션, 선언부를 대신해서 사용할 수 있는 것도 있다. -->
		<jsp:scriptlet>
			String str1 = request.getParameter("NUM1");
			String str2 = request.getParameter("NUM2");
			int num1 = Integer.parseInt(str1);
			int num2 = Integer.parseInt(str2);
			int sum = add(num1, num2);
		</jsp:scriptlet>
		
		<h1>두 수의 합은?</h1>
		<h2><jsp:expression>sum</jsp:expression></h2>
	</body>
</html>
<jsp:declaration>
	private int add(int num1, int num2){
		return num1 + num2;
	}
</jsp:declaration>