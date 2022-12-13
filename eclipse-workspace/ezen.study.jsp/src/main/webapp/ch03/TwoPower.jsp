<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
	</head>
	<body>
		<h1>2의 거듭제곱</h1><hr/>
		<h2>2^1 = <%=power(2, 1) %></h2>
		<h2>2^2 = <%=power(2, 2) %></h2>
		<h2>2^3 = <%=power(2, 3) %></h2>
		<h2>2^4 = <%=power(2, 4) %></h2>
		<h2>2^5 = <%=power(2, 5) %></h2>
	</body>
</html>

<%! //제곱을 구하는 메소드
	private int power (int base, int exponent) {
		int result = 1;
		for(int i = 0; i < exponent; i++){
			result *= base;
		}
		return result;
	}
%>