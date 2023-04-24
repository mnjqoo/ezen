<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c"	uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt"	uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>운송 목록 페이지</title>
		<script src='https://kit.fontawesome.com/a076d05399.js' crossorigin='anonymous'></script>
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
		<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
		<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">
		<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>	
		<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
		<!-- CSS -->
		<link href="/resources/css/common.css" rel="stylesheet" type="text/css">
		<link href="/resources/css/order.css" rel="stylesheet" type="text/css">
		<!-- JS -->
		<script src="/resources/js/order.js"></script>
	</head>
	<body>
		<!-- 상단 메뉴 바 -->
		<jsp:include page ="../common/mainTopNav.jsp"></jsp:include>
		
		<div class="row" >
			<!-- 세로 메뉴 바 -->
			<div class="col-sm-1">
				<jsp:include page ="../common/orderNav.jsp"></jsp:include>
			</div>
			
			<!-- 본문 부분 -->
			<div class="col-sm-11">
				<c:forEach items="${myOrderList}" var="order">
					<div class="container listDivBox">
						<!-- 목록 내용 부분 -->
						<table class="orderListTable">
							<thead>
								<tr>
									<th colspan="4">
										<p>${order.order_num}</p>
									</th>
								</tr>
							</thead>
							<tbody>
								<tr>
									<td class="orderListTd1">
										<p>신청일 <fmt:formatDate value="${order.order_date}" pattern="yyyy.MM.dd"/></p>
										<p>${order.truck_type}톤 트럭</p>
										<!-- 예약 상태에 따라 다르게 보여준다. -->
										<c:if test="${order.order_state == '1'}">
											<h5 class="orderState01">예약대기</h5>
										</c:if>
										<c:if test="${order.order_state == '2'}">
											<h5 class="orderState02">예약중</h5>
										</c:if>
										<c:if test="${order.order_state == '3'}">
											<h5 class="orderState03">운송중</h5>
										</c:if>
										<c:if test="${order.order_state == '4'}">
											<h5 class="orderState04">운송완료</h5>
										</c:if>
									</td>
									<td class="orderListTd2">
										<div>
											<p class="orderListTd2Title">상차지</p>
											<p>(${order.departure_postnum}) ${order.departure_address1} ${order.departure_address2}</p>
										</div>
										<hr/>
										<div>
											<p class="orderListTd2Title">하차지</p>
											<p>(${order.arrival_postnum}) ${order.arrival_address1} ${order.arrival_address2}</p>
										</div>	
									</td>
									<td class="orderListTd3">
										<p class="orderListTd3Title">결제 예상 금액</p>
										<p>${order.order_price}</p>
									</td>
									<td class="orderListTd4">
										<div>
											<c:choose>
												
												<c:when test="${(order.order_state == '1' or order.order_state == '2') and order.client_email == memberSession.user_email}">
													<button class="orderListTd4FBtn" type="button">예약취소 <i class="fas fa-caret-down"></i></button>
												</c:when>
												<c:otherwise>
													<c:choose>
														
														<c:when test="${(order.order_state == '3') and order.client_email == memberSession.user_email}">
															<button class="orderListTd4FBtnDone" type="button" disabled>취소불가 <i class="far fa-check-circle"></i></button>
														</c:when>
														<c:otherwise>
															
															<c:choose>
																<c:when test="${order.order_state == '2' and memberSession.user_type == 'D' }">
																	<button class="orderListTd4FBtn startOrderBtn" type="button">운송출발 <i class="fa fa-check-square-o"></i></button>
																	<!-- 스크립트에서 사용할 hidden 요소 -->
																	<input type="hidden" value="${order.order_num}" class="order_num"/>
																</c:when>
																<c:otherwise>
																	<c:choose>
																		<c:when test="${order.order_state == '3' and memberSession.user_type == 'D' }">
																			<button class="orderListTd4FBtn finishOrderBtn" type="button">운송도착 <i class="fa fa-check-square-o"></i></button>
																			<!-- 스크립트에서 사용할 hidden 요소 -->
																			<input type="hidden" value="${order.order_num}" class="order_num"/>
																		</c:when>
																		<c:otherwise>
																			<button class="orderListTd4FBtnDone" type="button" disabled>운송완료 <i class="far fa-check-circle"></i></button>
																		</c:otherwise>
																	</c:choose>	
																</c:otherwise>
															</c:choose>
														</c:otherwise>
													</c:choose>
												</c:otherwise>
											</c:choose>
										</div>
										<div>
											<button class="orderListTd4SBtn"  type="button" onclick="location.href='/order/orderDetail.form?order_num=${order.order_num}'">상세보기 <i class='far fa-plus-square'></i></button>
										</div>	
									</td>
								</tr>
							</tbody>
						</table>
						<!-- 예약하기 버튼 클릭시 나올 부분(예약 대기 상태일때만) -->
						<c:if test="${order.order_state == 1}">
							<table class="orderListTimeTable">
								<tr>
									<td class="orderListTd1"><p>운송 완료 예정 시간</p></td>
									<td>
										<input type="time" class="form-control bookOrderTime" min="00:00" max="12:00" required>
										<button class="form-control bookOrderBtn">예약하기</button>
										
									</td>
								</tr>
							</table>
						</c:if>	
					</div>
					<!-- 스크립트에서 사용할 hidden 요소 -->
					<div>
						<input type="hidden" value="${memberSession.user_email}" id="user_email"/>
					</div>
				</c:forEach>
				
				<!-- 페이징 처리 부분 -->	
				<div class="container orderPaging" >
					<ul class="btn-group pagination">
						<c:if test="${pageMaker.prev}">
							<li>
								<a href="<c:url value='/member/myOrderList.form?user_email=${memberSession.user_email}&page=${pageMaker.startPage-1}&array_type=r'/>"><span class="glyphicon glyphicon-chevron-left"></span></a>
							</li>
						</c:if>
						<c:forEach begin="${pageMaker.startPage}" end="${pageMaker.endPage}" var="pageNum">
							<li>
								<a href='<c:url value="/member/myOrderList.form?user_email=${memberSession.user_email}&page=${pageNum}&array_type=r"/>'><i>${pageNum}</i></a>
							</li>
						</c:forEach>
						<c:if test="${pageMaker.next}">
							<li>
								<a href="<c:url value='/member/myOrderList.form?user_email=${memberSession.user_email}&page=${pageMaker.endPage+1}&array_type=r'/>"><span class="glyphicon glyphicon-chevron-right"></span></a>
							</li>
						</c:if>
					</ul>
				</div>
			</div>
		</div>
	</body>
</html>