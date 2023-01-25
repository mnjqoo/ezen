<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c"	uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt"	uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<%	request.setCharacterEncoding("UTF-8"); %>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>영화 목록</title>
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
	</head>
	<body>
		<div class="container">
			<div class="row">
				<div class="col-md-3">
					<jsp:include page="../common/nav.jsp"></jsp:include>
				</div>
				<div class="col-md-9 content">
					<form class="form-horizontal">
						<div align="center">
							<h3>게시글 목록</h3>
							<button type="button" onclick="location.href='${contextPath}/movie/movieRegisterForm'">게시글 작성</button>
						</div>
						<br/>
						<!-- 게시글 목록 -->
						<table class="table table-bordered table-striped table-hober">
							<thead>
								<tr>
									<td>번호</td>
									<td>제목</td>
									<td>장르</td>
									<td>개봉일</td>
									<td>평점</td>
									<td>감독</td>
								</tr>
							</thead>
							<tbody>
								<c:forEach var="list" items="${movieList}">
									<tr>
										<td>${list.bno}</td>
										<td><a href="${contextPath}/movie/movieDetail?bno=${list.bno}">${list.title}</a></td>
										<td>${list.genre}</td>
										<td>${list.releaseDate}</td>
										<td>${list.raiting}</td>
										<td>${list.director}</td>
									</tr>
								</c:forEach>
							</tbody>
							
						</table>
					</form>	
				</div>
			</div>
		</div>
	</body>
</html>