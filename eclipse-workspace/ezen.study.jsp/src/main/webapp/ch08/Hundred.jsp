<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
int sum = 0; //누적된 값을 저장하기 위한 변수

for(int i = 1; i <= 100; i++) {
	sum += i;
}

request.setAttribute("RESULT", sum);
//RequestDispatcher dispatcher = request.getRequestDispatcher("HundredResule.jsp");
//dispatcher.forward(request, response);
%>

<jsp:forward page="HundredResult.jsp"/>