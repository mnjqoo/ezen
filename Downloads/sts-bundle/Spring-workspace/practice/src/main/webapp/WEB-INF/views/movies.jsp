<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c"	uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<%	request.setCharacterEncoding("UTF-8"); %>

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
		<link href="${contextPath}/resources/css/front.css" rel="stylesheet" type="text/css">
		
	</head>
	<body>
		<div class="container">
			<div class="row">
				<!-- 메뉴 -->
				<div class="col-md-3">
					<jsp:include page="common/nav.jsp" flush="false"></jsp:include>
				</div>
				
				<!-- 본문 -->
				<div class="col-md-9 content">
					<div id="section1"> <!-- section1 -->
						<div>
							<p>section1 <a href="${contextPath}/movie/movieList">>>></a></p>
						</div>
						<!-- 슬라이드 -->
						<div class="carousel slide" data-ride="carousel" id="section1Carousel"> 
							<div class="carousel-inner" role="listbox">
								<div class="item active">
									<ul>
										<li><a>dddd</a></li>
										<li><a>dddd</a></li>
										<li><a>dddd</a></li>
										<li><a>dddd</a></li>
										<li><a>dddd</a></li>
									</ul>
								</div>
								<div class="item">
									<ul>
										<li><a>22222</a></li>
										<li><a>22222</a></li>
										<li><a>dddd</a></li>
										<li><a>dddd</a></li>
										<li><a>dddd</a></li>
									</ul>
								</div>
								<div class="item">
									<ul>
										<li><a>3333</a></li>
										<li><a>3333</a></li>
									</ul>
								</div>
								
								<!-- 좌 우 버튼 -->
								<a class="left carousel-control" href="#section1Carousel" role="button" data-slide="prev">
									<span class="sr-only">Previous</span>
								</a>
								<a class="right carousel-control" href="#section1Carousel" role="button" data-slide="next">
									<span class="sr-only">Next</span>
								</a>
							</div>
						</div>
					</div>
					
					<div id="section2"> <!-- section2 -->
						<div>
							<p>section2 <a href="#">>>></a></p>
						</div>
						<div class="carousel slide" data-ride="carousel"> 
							<div class="carousel-inner" role="listbox">
								<div class="item active">
									<ul>
										<li><a>dddd</a></li>
										<li><a>dddd</a></li>
										<li><a>dddd</a></li>
										<li><a>dddd</a></li>
										<li><a>dddd</a></li>
									</ul>
								</div>
							</div>
						</div>
					</div>
					
					<div id="section3"> <!-- section3 -->
						<div>
							<p>section3 <a href="#">>>></a></p>
						</div>
						<div class="carousel slide" data-ride="carousel"> 
							<div class="carousel-inner" role="listbox">
								<div class="item active">
									<ul>
										<li><a>dddd</a></li>
										<li><a>dddd</a></li>
										<li><a>dddd</a></li>
										<li><a>dddd</a></li>
										<li><a>dddd</a></li>
									</ul>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</body>
	
	

</html>