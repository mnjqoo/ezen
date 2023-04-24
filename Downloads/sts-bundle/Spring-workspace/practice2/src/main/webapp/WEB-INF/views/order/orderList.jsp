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
		<!-- datepicker -->
		<link rel="stylesheet" href="http://code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
		<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
		<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
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
			
				<!-- 정렬, 검색 부분 -->
				<div class="container">
					<div id="orderListArrayDiv">
						<select class="form-control" id="arrayType">
							<option value="r" <c:if test="${arrayType == 'r'}">selected</c:if>>최근예약 순</option>
							<option value="p" <c:if test="${arrayType == 'p'}">selected</c:if>>예상결제액 순</option>
							<option value="s" <c:if test="${arrayType == 's'}">selected</c:if>>예약상태 순</option>
						</select>
					</div>
					<div id="orderListSearchDiv">
						<input type="text" class="form-control" id="orderListSearchInput"/>
						<button type="button"  class="form-control" id="orderListSearchBtn">
							<i class="fa fa-search"></i>
						</button>
					</div>
				</div>
				
				<c:forEach items="${orderList}" var="order">
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
										<!-- user_type이 운송기사인 경우에만 예약 버튼을 보이게 한다. -->
										<c:if test="${memberSession.user_type == 'D' and memberSession.user_email != order.client_email}">
											<div>
												<!-- 예약 대기 상태일 때 -->
												<c:choose>
													<c:when test="${order.order_state == '1'}">
														<button class="orderListTd4FBtn makeTimeTable" type="button">예약하기 <i class="fas fa-caret-down"></i></button>
													</c:when>
													<c:otherwise>
														<button class="orderListTd4FBtnDone" type="button">예약마감 <i class="far fa-check-circle"></i></button>
													</c:otherwise>
												</c:choose>
											</div>
										</c:if>
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
										<input type="text" class="form-control boodOrderDate" placeholder="날짜 선택"/>
										<input type="time" class="form-control bookOrderTime" min="00:00" max="12:00" required>
										<button class="form-control bookOrderBtn">예약하기</button>
										<!-- 스크립트에서 사용할 hidden 요소 -->
										<input type="hidden" value="${order.order_num}" class="order_num"/>
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
								<a href="<c:url value='/order/orderList.form?page=${pageMaker.startPage-1}&array_type=r'/>"><span class="glyphicon glyphicon-chevron-left"></span></a>
							</li>
						</c:if>
						<c:forEach begin="${pageMaker.startPage}" end="${pageMaker.endPage}" var="pageNum">
							<li>
								<a href='<c:url value="/order/orderList.form?page=${pageNum}&array_type=r"/>'><i>${pageNum}</i></a>
							</li>
						</c:forEach>
						<c:if test="${pageMaker.next}">
							<li>
								<a href="<c:url value='/order/orderList.form?page=${pageMaker.endPage+1}&array_type=r'/>"><span class="glyphicon glyphicon-chevron-right"></span></a>
							</li>
						</c:if>
					</ul>
				</div>
			</div>
		</div>
	</body>
</html>