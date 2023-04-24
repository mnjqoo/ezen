<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c"	uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt"	uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>운송 상세 페이지</title>
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
				<div class="container detailDivBox">
					<table id="orderDetailTable">
						<thead>
							<tr>
								<th colspan="3">
									<p>${orderDTO.order_num }</p>
									<button type="button" onclick="location.href='/order/orderList.form'">목록보기</button>
								</th>
							</tr>
						</thead>
						<tbody>
							<tr>
								<td class="orderDetailTd1">
									<div>
										<p class="detailPBold">신청일</p>
										<p class="detailPInline"><fmt:formatDate value="${orderDTO.order_date}" pattern="yyyy.MM.dd"/></p>
									</div>	
									<div>
										<p class="detailPBold">트럭 종류</p><p class="detailPInline">${orderDTO.truck_type}톤 트럭</p>
									</div>	
									<div>
										<p class="detailPBold">예상 거리</p><p class="detailPInline">${orderDTO.distance}km</p>
									</div>		
								</td>
								<td id="orderDetailTd2">
									<div>
										<p class="orderListTd2Title">상차지</p>
										<p>(${orderDTO.departure_postnum}) ${orderDTO.departure_address1} ${orderDTO.departure_address2}</p>
										<button type="button">지도 보기 <i class="fa fa-map-marker"></i></button>
									</div>
									<hr/>
									<div>
										<p class="orderListTd2Title">하차지</p>
										<p>(${orderDTO.arrival_postnum}) ${orderDTO.arrival_address1} ${orderDTO.arrival_address2}</p>
										<button type="button">지도 보기 <i class="fa fa-map-marker"></i></button>
									</div>	
								</td>
								<td id="orderDetailTd3">
									<p class="detailPBold">결제 예상 금액</p>
									<p>${orderDTO.order_price}</p>
								</td>
							</tr>
							<tr>
								<td id="orderDetailTd4">
									<p class="detailPBold">운송 메모</p>
								</td>
								<td colspan="2" id="orderDetailTd5">
									<p>${orderDTO.order_memo}</p>
								</td>
							</tr>
						</tbody>
					</table>
					
					<!-- 예약한 운송기사일 경우 보여지는 버튼 -->
					<c:if test="${memberSession.user_email == orderDTO.driver_email}">
						<button>예약 취소하기</button>
					</c:if>
				</div>
			</div>
		</div>
	</body>
</html>