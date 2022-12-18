<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
//문자열 배열을 만들고 참조변수에 주소값을 저장한다.
String winners[] = new String[3];

winners[0] = "향단이";
winners[1] = "이몽룡";
winners[2] = "춘향이";

//request.attribute에 배열의 값을 저장하고, 다음 페이지로 넘긴다.
request.setAttribute("WINNERS", winners);
RequestDispatcher dispatcher = request.getRequestDispatcher("WinnersResult.jsp");
dispatcher.forward(request, response);
%>