<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>
<%
GregorianCalendar now = new GregorianCalendar();
String date = String.format("%TY년 %Tm월 %Td일", now, now, now);
String time = String.format("%Tp시 %TR분", now, now);
%>

<h3>[현재 일자] <%= date %></h3>
<h3>[현재 시각] <%= time %></h3>