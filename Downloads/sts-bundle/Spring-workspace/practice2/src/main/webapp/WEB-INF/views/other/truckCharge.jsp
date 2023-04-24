<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>요금 안내</title>
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
		<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
		<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">
		<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>	
		<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
		<!-- CSS -->
		<link href="/resources/css/home.css" rel="stylesheet" type="text/css">
		<link href="/resources/css/common.css" rel="stylesheet" type="text/css">
	</head>
	<body>
		<!-- 상단 메뉴 -->
		<jsp:include page="../common/mainTopNav.jsp" flush="false"></jsp:include>
		
		<div class="container">
			<div id="truciChargeDivBox">
				<div>
					<h2>운송요금안내</h2>
					<p>운송거리별 요금표(전국권, 시내운송)</p>
					<p id="measureRight">단위 : 만원(VAT별도)</p>
				</div>
				<table>
					<thead>
						<tr>
							<th>운송거리</th>
							<th>1톤</th>
							<th>5톤</th>
							<th>8톤</th>
							<th>18톤</th>
						</tr>
					</thead>
					<tbody>
						<tr>
							<td>30k</td>
							<td>5</td>
							<td>10</td>
							<td>12</td>
							<td>18</td>
						</tr>
						<tr>
							<td>70k</td>
							<td>7</td>
							<td>13</td>
							<td>18</td>
							<td>22</td>
						</tr>
						<tr>
							<td>110k</td>
							<td>9</td>
							<td>15</td>
							<td>22</td>
							<td>25</td>
						</tr>
						<tr>
							<td>150k</td>
							<td>11</td>
							<td>18</td>
							<td>25</td>
							<td>28</td>
						</tr>
						<tr>
							<td>200k</td>
							<td>13</td>
							<td>21</td>
							<td>28</td>
							<td>32</td>
						</tr>
					</tbody>
				</table>
				<p>※ 최저요금 기준으로 기사 수작업, 화물의 특성, 결제방식 등에 따라서 요금조정 있을 수 있음</p>
			</div>	
		</div>
		
		<!-- footer -->
		<jsp:include page="../common/footer.jsp" flush="false"></jsp:include>
	</body>
</html>