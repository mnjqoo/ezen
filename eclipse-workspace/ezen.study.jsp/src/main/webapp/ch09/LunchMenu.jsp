<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%
String arr[] = {"칼국수", "김치찌개", "된장찌개", "불고기백반", "순두부백반" };
request.setAttribute("MENU", arr);
%>
<jsp:forward page="LunchMenuView.jsp"/>