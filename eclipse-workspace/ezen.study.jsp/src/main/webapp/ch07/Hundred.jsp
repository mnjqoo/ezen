<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
//1부터 100까지 정수를 누적시킨다.
int sum = 0;
for(int i = 1; i <= 100; i++) {
	sum += i;
}

//누적시킨 값을 attribute에 저장해서 다음 페이지로 넘어갈 때 가지고 간다.
request.setAttribute("RESULT", sum); 
RequestDispatcher dispatcher = request.getRequestDispatcher("HundredResult.jsp");
dispatcher.forward(request, response);
%>