<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false"%>
<%@ page import="java.io.*" %>
<%@ taglib prefix="c"	uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<%	request.setCharacterEncoding("UTF-8"); %>
<% //isELIgnored="false" : EL식 표현을 사용함 / true: 단순 text로 해석함 %>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title><spring:message code="site.title" text="Member Info"/> </title>
	</head>
	<body>
		<jsp:include page="./common/topMenu.jsp"></jsp:include>
		
		<a href="${pageContext.request.contextPath}/test/locale.do?locale='ko'">한국어</a>
		<a href="${pageContext.request.contextPath}/test/locale.do?locale='en'">ENGLISH</a>
		<h1><spring:message code="site.title" text="Member Info"/></h1>
		<p><spring:message code="site.name" text="no name"/>: <spring:message code="name" text="no name"/></p>
		<input type="button" value="<spring:message code='btn.send'/>"/>
		
		<jsp:include page="./common/footer.jsp" flush="false"></jsp:include>
	</body>
</html>