<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<% request.setCharacterEncoding("UTF-8"); %>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
	</head>
	<body>
		<div class="container">
			<div class="row">
				<!-- 메뉴 -->
				<nav class="col-md-3">
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
				</nav>
			</div>
		</div>
	</body>
</html>