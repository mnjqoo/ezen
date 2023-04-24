<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c"	uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt"	uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>메인 페이지</title>
		<script src='https://kit.fontawesome.com/a076d05399.js' crossorigin='anonymous'></script>
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
		<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
		<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">
		<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>	
		<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
		<!-- MAIN CSS -->
		<link href="/resources/css/common.css" rel="stylesheet" type="text/css">
		<link href="/resources/css/main.css" rel="stylesheet" type="text/css">
		<!-- MAIN JS -->
		<script src="/resources/js/main.js"></script>
	</head>
	<body>
		<!-- 상단 메뉴 바 -->
		<jsp:include page ="common/mainTopNav.jsp"></jsp:include>
		
		<div class="row" >
			<!-- 세로 메뉴 바 -->
			<div class="col-sm-1">
				<jsp:include page ="common/mainNav.jsp"></jsp:include>
			</div>
			
			<!-- 본문 부분 -->
			<div class="col-sm-11" id="mainContentBox">
			
				<div class="container mainContentDiv" id="mainContentSec01">
					<div class="row">
						<div class="col-sm-7">
							<div>
								<c:choose>
									<c:when test="${memberSession != null}">
										<p id="mainHelloP">안녕하세요 ${memberSession.user_name}님, 환영합니다.</p>
										<p>단순 용달, 물류 센터 입고, 거래처 납품, 정기 운송까지</p>
										<p>지금 운송을 시작해보세요.</p>
										<div>
											<button type="button" onclick="location.href='/order/orderRegister.form'">운송예약하기 <i class='fas fa-chevron-right'></i></button>
											<button type="button" id="lookOrders" onclick="location.href='/order/orderList.form?arrayType=r'">운송조회하기 <i class='fas fa-chevron-right'></i></button>
										</div>
									</c:when>
									<c:otherwise>
										<p id="mainHelloP">안녕하세요.</p>
										<p>먼저 로그인을 해주세요.</p>
										<div>
											<button type="button" onclick="location.href='/member/login.form'">로그인하기 <i class='fas fa-chevron-right'></i></button>
											<button type="button" id="lookOrders" onclick="location.href='member/register.form'">회원가입하기 <i class='fas fa-chevron-right'></i></button>
										</div>
									</c:otherwise>
								</c:choose>
							</div>
						</div>
						<div class="col-sm-5">
							<img src="${contextPath}/resources/images/mainFirstImg.jpg"/>
						</div>
					</div>
				</div>
				
				<!-- 두번째 -->
				<div class="container" id="mainContentSec02">
					<div class="row">
						<!-- 관련 기사 부분(슬라이더 사용) -->
						<div class="col-sm-8">
							<div class="mainContentDiv">
								<div id="mainContentArticle" class="carousel slide" data-interval="false">
									<!-- 슬라이더 타이틀 부분 -->
									<div>
										<div id="carouselTitle">
											<p>물류 이야기</p>
										</div>
										<!-- indicator 부분 -->
										<div class="carousel-indicator">
											<!-- 왼쪽 이동 버튼 -->
											<a href="#mainContentArticle" class="carousel-control-prev indicatorBtn" role="button" data-slide="prev">
												<span class="glyphicon glyphicon-chevron-left"></span>
												<span class="sr-only">Previous</span>
											</a>
											
											<!-- 페이지 숫자 -->
											<p id="indicatorNum">1</p>
											<p> / 2</p>
											
											<!-- 오른쪽 이동 버튼 -->
											<a href="#mainContentArticle" class="carousel-control-next indicatorBtn" role="button" data-slide="next">
												<span class="glyphicon glyphicon-chevron-right"></span>
												<span class="sr-only">Next</span>
											</a>
										</div>
									</div>
									
									<!-- 기사 나열 부분 -->	
									<div class="carousel-inner" role="listbox">
										<!-- 첫번째 페이지 -->
										<div class="item active">
											<table>
												<tr>
													<td>
														<a>
															<h5>접촉이 필요없는 비대면 용달</h5>
															<img src="${contextPath}/resources/images/mainArticle01.png"/>
															<p>💸운송비 절감부터 맞춤 운송까지</p>
														</a>
													</td>
													<td>
														<a>
															<h5>물류, 일상을 바꾸다</h5>
															<img src="${contextPath}/resources/images/mainArticle02.png"/>
															<p>🌎글로벌 물류 대란</p>
														</a>
													</td>
													<td>
														<a>
															<h5>가구는 왜 당일배송이 안될까?</h5>
															<img src="${contextPath}/resources/images/mainArticle03.png"/>
															<p>오늘의집, 지정일 배송📆</p>
														</a>
													</td>
												</tr>
											</table>
										</div>
										
										<!-- 두번째 페이지 -->
										<div class="item">
											<table>
												<tr>
													<td>
														<a>
															<h5>우체국 택배 폐지 : 택배 파업</h5>
															<img src="${contextPath}/resources/images/mainArticle04.png"/>
															<p>우체국 택배가 사라진다?😥</p>
														</a>
													</td>
													<td>
														<a>
															<h5>신세계+네이버, 이베이 인수</h5>
															<img src="${contextPath}/resources/images/mainArticle05.png"/>
															<p>이커머스 업계의 지각변동💫</p>
														</a>
													</td>
													<td>
														<a>
															<h5>카카오, 물류를 시작하다</h5>
															<img src="${contextPath}/resources/images/mainArticle06.png"/>
															<p>구글이 투자한 모빌리티🚕</p>
														</a>
													</td>
												</tr>
											</table>
										</div>
									</div>
								</div>
							</div>
						</div>
						
						<!-- 이용 방법 소개 부분-->
						<div class="col-sm-4" id="mainSec02-2">
							<div class="mainContentDiv">
								<table id="howToUseTable">
									<tr>
										<th>
											<img src="${contextPath}/resources/images/mainSecondImg.png"/>
										</th>
										<th>
											<p>운송 서비스</p><p>이용이</p><p>처음이신가요?</p>
										</th>
									</tr>
									<tr>
										<td colspan="2">
											<a href="#">
												ㅇㅇ 이용 방법 보러가기 <i class='fas fa-long-arrow-alt-right'></i>
											</a>
										</td>
									</tr>
								</table>
							</div>
						</div>
					</div>
				</div>
				<div class="container mainContentDiv" id="mainContentSec03">
					<table>
						<thead>
							<tr>
								<th colspan="2">최근에  예약한 운송</th>
							</tr>
						</thead>
						<c:if test="${memberSession != null}">
							<tbody>
								<tr>
									<td id="mainTableFirstTd">
										<a href="/order/orderDetail.form?order_num=${myOrderSession[0].order_num}">${myOrderSession[0].order_num}</a>
										<p>출발 날짜 ${myOrderSession[0].departure_date}</p>
										<p>도착 예정 시간 ${myOrderSession[0].estimated_time}</p>
										<!-- 예약 상태에 따라 다르게 보여준다. -->
										<c:if test="${myOrderSession[0].order_state == 1}">
											<h5 class="orderState01">예약대기</h5>
										</c:if>
										<c:if test="${myOrderSession[0].order_state == 2}">
											<h5 class="orderState02">예약중</h5>
										</c:if>
										<c:if test="${myOrderSession[0].order_state == 3}">
											<h5 class="orderState03">운송중</h5>
										</c:if>
										<c:if test="${myOrderSession[0].order_state == 4}">
											<h5 class="orderState04">운송완료</h5>
										</c:if>
									</td>
									<td id="mainTableSecondTd">
										<div id="deliverAskDate">
											<p>신청일 <fmt:formatDate value="${myOrderSession[0].order_date}" pattern="yyyy.MM.dd"/></p>
										</div>
											<i class="fa fa-square-o" id="deliveryLineFI"></i>
											<div id="deliveryLineDiv"></div>
											<i class="fa fa-square-o"  id="deliveryLineLI"></i>
										
										<div id="mainTableAddress">
											<div>
												<p class="deliverAskAdrress-1">${myOrderSession[0].departure_address1}</p>
												<p class="deliverAskAdrress-2">${myOrderSession[0].departure_address2}</p>
											</div>	
											<div id="deliverAskAdrress2">
												<p class="deliverAskAdrress-1">${myOrderSession[0].arrival_address1}</p>
												<p class="deliverAskAdrress-2">${myOrderSession[0].arrival_address2}</p>
											</div>
										</div>	
									</td>
								</tr>
							</tbody>
						</c:if>
					</table>
				</div>
			</div>
		</div>
	</body>
</html>