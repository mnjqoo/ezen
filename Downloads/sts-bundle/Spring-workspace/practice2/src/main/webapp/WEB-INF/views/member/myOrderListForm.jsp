<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

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
				<div class="container listDivBox">
					<!-- 목록 내용 부분 -->
					<table class="orderListTable">
						<thead>
							<tr>
								<th colspan="4">
									<p>123456789</p>
								</th>
							</tr>
						</thead>
						<tbody>
							<tr>
								<td class="orderListTd1">
									<p>신청일 2020.02.02</p>
									<p>트럭 종류</p>
									<h5>예약대기</h5>
								</td>
								<td class="orderListTd2">
									<div>
										<p class="orderListTd2Title">상차지</p>
										<p>(우편번호) 상차지주소1 상차지주소2</p>
									</div>
									<hr/>
									<div>
										<p class="orderListTd2Title">하차지</p>
										<p>(우편번호) 하차지주소1 하차지주소2</p>
									</div>	
								</td>
								<td class="orderListTd3">
									<p class="orderListTd3Title">결제 예상 금액</p>
									<p>150,000원</p>
								</td>
								<td class="orderListTd4">
									<div>
										<button class="orderListTd4FBtn" type="button" onclick="location.href='/order/orderApplication.form'">예약하기 <i class="fas fa-caret-down"></i></button>
									</div>
									<div>
										<button class="orderListTd4SBtn"  type="button" onclick="location.href='/order/orderDetail.form'">상세보기 <i class='far fa-plus-square'></i></button>
									</div>	
								</td>
							</tr>
						</tbody>
					</table>
					<!-- 예약하기 버튼 클릭시 나올 부분 -->
					<table class="orderListTimeTable">
						<tr>
							<td class="orderListTd1"><p>운송 완료 예정 시간</p></td>
							<td>
								<input type="time" id="appt" name="appt"  class="form-control" min="00:00" max="12:00" required>
								<button class="form-control">예약하기</button>
							</td>
						</tr>
					</table>
				</div>
			</div>
		</div>
	</body>
</html>