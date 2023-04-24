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
				<!-- <c:forEach items="${myDriveList}" var="drive"> -->
					<div class="container listDivBox">
						<!-- 목록 내용 부분 -->
						<table class="orderListTable">
							<thead>
								<tr>
									<th colspan="4">
										<p></p>
									</th>
								</tr>
							</thead>
							<tbody>
								<tr>
									<td class="orderListTd1">
										<p>신청일 <fmt:formatDate value="" pattern="yyyy.MM.dd"/></p>
										<p>톤 트럭</p>
										<!-- 예약 상태에 따라 다르게 보여준다. -->
										<c:if test="">
											<h5 class="orderState02">예약중</h5>
										</c:if>
										<c:if test="">
											<h5 class="orderState03">운송중</h5>
										</c:if>
										<c:if test="">
											<h5 class="orderState04">운송완료</h5>
										</c:if>
									</td>
									<td class="orderListTd2">
										<div>
											<p class="orderListTd2Title">상차지</p>
											<p></p>
										</div>
										<hr/>
										<div>
											<p class="orderListTd2Title">하차지</p>
											<p></p>
										</div>	
									</td>
									<td class="orderListTd3">
										<p class="orderListTd3Title">결제 예상 금액</p>
										<p></p>
									</td>
									<td class="orderListTd4">
										<div>
											<!-- 예약 대기 상태일 때 -->
											<c:choose>
												<c:when test="">
													<button class="orderListTd4FBtn" type="button">예약취소 <i class="fas fa-caret-down"></i></button>
												</c:when>
												<c:otherwise>
													<button class="orderListTd4FBtnDone" type="button">취소불가 <i class="far fa-check-circle"></i></button>
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
					</div>
					<!-- 스크립트에서 사용할 hidden 요소 -->
					<div>
						<input type="hidden" value="${memberSession.user_email}" id="user_email"/>
					</div>
				<!-- </c:forEach> -->
				
				<!-- 페이징 처리 부분 -->	
				<div class="container" >
					<ul class="btn-group pagination">
						<c:if test="${pageMaker.prev}">
							<li>
								<a href="<c:url value='/order/orderList?page=${pageMaker.startPage-1}&array_type=r'/>"><span class="glyphicon glyphicon-chevron-left"></span></a>
							</li>
						</c:if>
						<c:forEach begin="${pageMaker.startPage}" end="${pageMaker.endPage}" var="pageNum">
							<li>
								<a href='<c:url value="/product/productTypeList?product_type=${type}&page=${pageNum}&array_type=r"/>'><i>${pageNum}</i></a>
							</li>
						</c:forEach>
						<c:if test="${pageMaker.next}">
							<li>
								<a href="<c:url value='/product/productTypeList?product_type=${type}&page=${pageMaker.endPage+1}&array_type=r'/>"><span class="glyphicon glyphicon-chevron-right"></span></a>
							</li>
						</c:if>
					</ul>
				</div>
			</div>
		</div>
	</body>
</html>