<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<% request.setCharacterEncoding("UTF-8"); %>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
		<!-- jQuery -->
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.1/jquery.min.js"></script>
		<script src="../../js/jquery-3.6.1.js"></script>
		<!-- 합쳐지고 최소화된 최신 CSS -->
		<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">

		<!-- 부가적인 테마 -->
		<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">

		<!-- 합쳐지고 최소화된 최신 자바스크립트 -->
		<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>
		<link href="${contextPath}/resources/css/default.css" rel="stylesheet" type="text/css">
		<link href="${contextPath}/resources/css/nav.css" rel="stylesheet" type="text/css">
		<script>
		$(function(){
			$(".dropdown").on("click", function(){
				$(this).find("ul").stop().fadeToggle(200) //stop(): 전에 작동하던 것을 멈추고 다음 것을 작동시킨다.
			});
		});
		</script>
		
	</head>
	<body>
		<!-- 메뉴 -->
		<div class="search">
			<input type="text" placeholder="text"/>
			<button type="submit"><span class="glyphicon glyphicon-search"></span></button>
		</div>
		<ul class="nav nav-pills nav-stacked">
			<li><a href="#">section1</a></li>
			<li><a href="#">section2</a></li>
			<li class="dropdown"><a href="#">section3<span class="caret"></span></a>
				<ul>
					<li><a href="#">section3-1</a>
					<li><a href="#">section3-2</a>
				</ul>
			</li>
		</ul>
	</body>
</html>