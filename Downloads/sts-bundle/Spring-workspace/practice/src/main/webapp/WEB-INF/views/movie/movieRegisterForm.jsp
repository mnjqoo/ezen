<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import = "java.util.*" %>
<%@ page import = "java.sql.Timestamp" %>
<%@ taglib prefix="c"	uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt"	uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<%	request.setCharacterEncoding("UTF-8"); %>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>게시글 작성 페이지</title>
		<link rel="stylesheet" href="http://code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
		<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
		<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
		<script src="${contextPath}/resources/js/movieJs.js"></script>
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
					<h3 align="center">게시글 작성 양식</h3>
					
					<form class="form-horizontal" id="frm">
						<!-- 게시글 작성 -->
						<div class="form-group">
							<div class="col-sm-9">
								<div class="form-group">
									<label class="col-sm-2">제목</label>
									<div class="col-sm-10">
										<input type="text" class="form-control" id="title" name="title"/>
									</div>
								</div>
								<div class="form-group">
									<label class="col-sm-2">장르</label>
									<div class="col-sm-2">
										<select class="form-control" id="genre" name="genre">
											<c:forEach var="genre" items="${genreList}">
												<option value="${genre.genre_code}">${genre.genre}</option>
											</c:forEach>
										</select>
									</div>
									<label class="col-sm-2">개봉일</label>
									<div class="col-sm-6">
										<input type="text" class="form-control" id="releaseDate" name="releaseDate"/>
									</div>
								</div>
								<div class="form-group">
									<label class="col-sm-2">평점</label>
									<div class="col-sm-2">
										<select class="form-control" id="raiting" name="raiting">
											<c:forEach var="i" begin="1" end="5">
												<option value="${i}">${i}</option>
											</c:forEach>
										</select>
									</div>
									<label class="col-sm-2">감독</label>
									<div class="col-sm-6">
										<input type="text" class="form-control" id="director" name="director"/>
									</div>
								</div>
								<br/>
								<!-- 버튼 -->
								<div class="form-group">
									<p align="center">
										<button type="reset">
											<span class="glyphicon glyphicon-remove"> 다시입력</span>
										</button>
										<button type="button" onclick="fn_movieRegister();">
											<span class="glyphicon glyphicon-ok"> 게시글등록</span>
										</button>
									</p>
								</div>
							</div>
							<div class="col-sm-3">
								<jsp:include page="../common/imageUpload.jsp"></jsp:include>
							</div>
						</div>
					</form>
				</div>
			</div>
		</div>
	</body>
</html>