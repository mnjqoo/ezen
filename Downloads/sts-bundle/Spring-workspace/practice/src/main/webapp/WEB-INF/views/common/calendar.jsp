<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import = "java.util.*" %>
<%@ page import = "java.sql.Timestamp" %>
<%@ taglib prefix="c"	uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt"	uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<%	request.setCharacterEncoding("UTF-8"); 

	Timestamp nowTime = new Timestamp(System.currentTimeMillis());
	int lastYear = Integer.parseInt(nowTime.toString().substring(0, 4)); //현재 년도를 구한다.(가장 최근 년도)
%>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>달력</title>
	</head>
	<body>
		<div class="col-sm-6">
			<div class="input-group">
				<select class="form-control" name="publishing_year" style="width:100%" onkeydown="nextFocus(publishing_month)">
					<% for(int year = lastYear; year >= 1900; year--){ %>
					<option value="<%= year %>"><%= year %></option>
					<% } %>
				</select>
				<span class="input-group-addon">년</span>
			</div>
		</div>
		<div class="col-sm-3">
			<div class="input-group">
				<select class="form-control" name="publishing_month" style="width:100%" onkeydown="nextFocus(publishing_day)">
					<c:forEach var="month" begin="1" end="12" step="1"> <!-- step:1 = 1++ -->
						<option value="${month}" <c:if test="${month == 5}">selected</c:if>>${month}</option>
					</c:forEach>
				</select>
				<span class="input-group-addon">월</span>
			</div>
		</div>
		<div class="col-sm-3">
			<div class="input-group">
				<select class="form-control" name="publishing_day" style="width:100%" onkeydown="nextFocus(publishing_com)">
					<c:forEach var="day" begin="1" end="31" step="1">
						<option value="${day}">${day}</option>
					</c:forEach>
				</select>
				<span class="input-group-addon">일</span>
			</div>
		</div>
	</body>
</html>