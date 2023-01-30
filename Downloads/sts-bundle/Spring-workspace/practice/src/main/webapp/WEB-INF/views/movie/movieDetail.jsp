<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c"	uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt"	uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<%	request.setCharacterEncoding("UTF-8"); %>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>상세 페이지</title>
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
		<script src="${contextPath}/resources/js/movieJs.js"></script>
		<script src="${contextPath}/resources/js/fileJs.js"></script>
	</head>
	<body>
		
		
		<div class="container">
			<div class="row">
				<div class="col-md-3">
					<jsp:include page="../common/nav.jsp"></jsp:include>
				</div>
				<div class="col-md-9 content">
					<form class="form-horizontal" id="frm">
						<div class="col-sm-3">
							<a href="${contextPath}/file/display?fileName='originalImg(${movieDTO.images});'">
								<img src="${contextPath}/file/display?fileName='${movieDTO.imgaes}'"/>
							</a>
						</div>
						<div class="col-sm-9">
							<div class="form-group">
								<label class="col-sm-2">제목</label>
								<div class="col-sm-10">
									<input type="text" class="form-control" id="title" name="title" placeholder="${movieDTO.title}" readonly/>
								</div>
							</div>
							<div class="form-group">
								<label class="col-sm-2">장르</label>
								<div class="col-sm-2">
									<input type="text" class="form-control" id="genre" name="genre" placeholder="${movieDTO.genre}" readonly/>
								</div>
								<label class="col-sm-2">개봉일</label>
								<div class="col-sm-6">
									<input type="text" class="form-control" id="releaseDate" placeholder="${movieDTO.releaseDate}" readonly/>
								</div>
							</div>
							<div class="form-group">
								<label class="col-sm-2">평점</label>
								<div class="col-sm-2">
									<input type="text" class="form-control" id="raiting" name="raiting" placeholder="${movieDTO.raiting}" readonly/>
								</div>
								<label class="col-sm-2">감독</label>
								<div class="col-sm-6">
									<input type="text" class="form-control" id="director" name="director" placeholder="${movieDTO.director}" readonly/>
								</div>
							</div>
						</div>
						<!-- 버튼 -->
						<div class="form-group">
							<p align="center">
								<button type="button" onclick="location.href='${contextPath}/movie/movieList'">
									<span class="glyphicon glyphicon-list-alt"> 게시글 목록</span>
								</button>
								<button type="button" onclick="location.href='${contextPath}/movie/movieUpdateForm?bno=${movieDTO.bno}'">
									<span class="glyphicon glyphicon-pencil"> 게시글 수정</span>
								</button>
								<button type="button" onclick="fn_movieDelete(${movieDTO.bno});">
									<span class="glyphicon glyphicon-erase"> 게시글 삭제</span>
								</button>
							</p>
						</div>
					</form>
				</div>
			</div>
		</div>
	</body>
</html>