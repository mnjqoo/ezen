<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>운송 등록 페이지</title>
		<script src='https://kit.fontawesome.com/a076d05399.js' crossorigin='anonymous'></script>
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
		<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
		<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">
		<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>	
		<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
		<!-- 다음 API -->
		<script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
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
				<div class="container registerDivBox">
				
					<!-- 운송 예약 정보 부분 -->
					<h4>운송 예약 등록</h4>
					<hr/>
					
					<!-- 예약자 정보 -->
					<table id="registerTable1">
						<thead>
							<tr>
								<th colspan="4">
									<p>예약자 정보</p>
								</th>
							</tr>
						</thead>
						<tbody>
							<tr>
								<td class="registerTdTitle">이름</td>
								<td id="orderDetailTd2">${memberSession.user_name}</td>
								<td class="registerTdTitle">휴대폰번호</td>
								<td>${memberSession.user_phone}</td>
							</tr>
							<tr>
								<td class="registerTdTitle">이메일</td>
								<td id="clientEmail">${memberSession.user_email}</td>
								<td class="registerTdTitle">생년월일</td>
								<td>${memberSession.user_birthdate}</td>
							</tr>
							<tr>
								<td colspan="4">
									<input type="checkbox" id="userCheck" /> <label for="userCheck">위의 정보가 예약자 본인이 맞습니까?</label>
								</td>	
							</tr>
						</tbody>
					</table>
					<!-- 운송 정보 -->
					<table id="registerTable2">
						<thead>
							<tr>
								<th colspan="4">
									운송 정보
								</th>
							</tr>
						</thead>
						<tbody>
							<tr>
								<td class="registerTdTitle">상차지 주소</td>
								<td colspan="5">
									<input type = "text" class="form-control" id="departurePostnum" readonly/>
									<input type = "button" class=" form-control postBtn" id="departurePostBtn" onclick = "fn_daumZipCode('D');" value = "우편번호 검색"/>
									<input type = "text"  class="form-control address1" id="departureAddress1" readonly/>
									<input type="text"  class="form-control" id="departureAddress2" placeholder="상세주소"/>
								</td>
							</tr>
							<tr>
								<td class="registerTdTitle">하차지 주소</td>
								<td colspan="5">
									<input type = "text" class="form-control" id="arrivalPostnum" readonly/>
									<input type = "button" class=" form-control postBtn" id="arrivalPostBtn"  onclick = "fn_daumZipCode('A');" value = "우편번호 검색"/>
									<input type = "text"  class="form-control address1" id="arrivalAddress1" readonly/>
									<input type="text"  class="form-control" id="arrivalAddress2" placeholder="상세주소"/>
								</td>
							</tr>
							<tr>
								<td class="registerTdTitle">운송 메모</td>
								<td colspan="5">
									<select class="form-control" id="orderMemo" onchange="fn_orderMemo();">
										<option>빠른 운송 부탁드립니다.</option>
										<option>깨지기 쉬운 물품이 있습니다. 조심히 운송해주세요.</option>
										<option>3</option>
										<option value="makeMemo">직접입력</option>
									</select>
									<input type="text" class="form-control" id="order_memo" maxlength="100" placeholder="운송 메모 직접 입력" value="빠른 운송 부탁드립니다."/>
								</td>
							</tr>
							<tr>
								<td class="registerTdTitle2">트럭 종류</td>
								<td>
									<select class="form-control" id="truck_type" onchange="fn_calcPrice();">
										<option value="1">1톤</option>
										<option value="5">5톤</option>
										<option value="8">8톤</option>
										<option value="18">18톤</option>
									</select>
								</td>
								<td class="registerTdTitle2">예상 거리</td>
								<td>
									<select class="form-control" id="distance" onchange="fn_calcPrice();">
										<option value="30">30km 이하</option>
										<option value="70">30km 초과 70km 이하</option>
										<option value="110">70km 초과 110km 이하</option>
										<option value="150">110km 초과 150km 이하</option>
										<option value="200">150km 초과 200km 이하</option>
									</select>
								</td>
								<td class="registerTdTitle2">결제 예정 금액</td>
								<td id="price">5만원</td>
							</tr>
						</tbody>
					</table>
					
					<!-- 버튼 부분 -->
					<div class="registerBtnDiv">
						<button type="button" class="form-control registerFormBtn" id="registerBtn" onclick="fn_orderRegister('${memberSession.user_email}');">운송 예약 등록</button>
						<button type="button" class="form-control registerFormBtn" onclick="location.href='/order/orderList.form'">목록 보기</button>
					</div>
				</div>
			</div>
		</div>
		
	</body>
</html>