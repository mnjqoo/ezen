<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c"	uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Home</title>
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
		<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
		<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">
		<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>	
		<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
		<!-- HOME CSS -->
		<link href="/resources/css/home.css" rel="stylesheet" type="text/css">
		<!-- HOME JS -->
		<script src="/resources/js/home.js"></script>
	</head>
	<body data-spy="scroll" data-target="#homeNav" data-offset="20">
		<div>
			<jsp:include page="common/homeNav.jsp" flush="false"></jsp:include>
			
			<!-- 1 Section -->
		    <div class="homeRow" id="sec01">
		    	<div class="sec01_text">
			    	<h1>화물 운송이</h1> 
			    	<h1>간편해집니다.</h1> 
			    	<p>배차와 정산을 한번에</p>
			    	<p>시간과 비용을 모두 아껴보세요</p>
			    	<button type="button" class="button_start_now" onclick="location.href='/member/login.form'">지금 시작하기 <span class="glyphicon glyphicon-chevron-right"></span></button>
			    </div>
			    <div>
			    	<img src="${contextPath}/resources/images/truck_home.jpg" class="truck_home"/> 
			    </div> 
		    </div>
		    
		    <!-- 2 Section -->
		    <div class="homeRow" id="sec02">
		    	<div>
		    		<h1>운송이 필요한 모두를 위해</h1>
		    		<p>개인부터 법인, 그리고 기사 모두를 위한 서비스입니다.
		    	</div>
		    	<div>
		    		<img src="${contextPath}/resources/images/screenshot1.jpg"/>
		    		<img src="${contextPath}/resources/images/screenshot2.jpg"/>
		    	</div>
		    </div>
		    
		    <!-- 3 Section -->
		    <div class="homeRow" id="sec03">
		    	<div>
		    		<h1>"이름"을 이용한 화물 운송은?</h1>
		    		<p>어쩌구저쩌구 이러저러해서 좋습니다.</p>
		    		<div class="sec03_box" id="sec03_01">
		    			<h5>실시간 운송 현황 확인</h5>
		    			<p>출발지부터 도착지까지 전화 없이 운송을 추적해보세요.</p>
		    		</div>
		    		<div class="sec03_box" id="sec03_02">
		    			<h5>운송비 간편 결제</h5>
		    			<p>카드를 간편하게 추가하고 편리하게 결제하세요.</p>
		    		</div>
		    		<div class="sec03_box" id="sec03_03">
		    			<h5>기사님 정보 확인</h5>
		    			<p>운송별 당담 기사님의 정보를 바로 확인해보세요.</p>
		    		</div>
		    		<div class="sec03_box" id="sec03_04">
		    			<h5>운송 히스토리 확인</h5> 
		    			<p>과거 운송 이력을 한눈에 확인해보세요.</p>
		    		</div>
		    	</div>
		    	<div>
		    		<img src="${contextPath}/resources/images/screenshot2.jpg" alt="sec03_img"/>
		    	</div>
		    </div>
		    
		    <!-- 4 Section -->
		    <div class="homeRow" id="sec04">
		    	<div>
		    		<h1>많은 사용자들이</h1>
		    		<h1>이미 "이름"과 함께하고 있습니다.</h1>
		    	</div>
		    	<div class="sec04_brand_box">
		    		<div>
			    		<img class="sec04_img" src="#"/>
			    		<img class="sec04_img" src="#"/>
			    		<img class="sec04_img" src="#"/>
			    		<img class="sec04_img" src="#"/>
			    		<img class="sec04_img" src="#"/>
			    		<img class="sec04_img" src="#"/>
			    	</div>
			    	<div>
			    		<img class="sec04_img" src="#"/>
			    		<img class="sec04_img" src="#"/>
			    		<img class="sec04_img" src="#"/>
			    		<img class="sec04_img" src="#"/>
			    		<img class="sec04_img" src="#"/>
			    		<img class="sec04_img" src="#"/>
			    	</div>	
		    	</div>
		    </div>
		    
		    <!-- 5 Section -->
		    <div id="sec05">
		    	<div class="container">
			    	<table>
			    		<tr>
			    			<th colspan="2">CONTACT US</th>
			    		</tr>
			    		<tr>
			    			<td>
			    				<a href="#">
			    					<span class='glyphicon glyphicon-envelope'></span>
			    					<p class="sec05SpanCaption">1:1 이메일 문의</p>
			    					<p class="sec05AP">truck@gmail.com</p>
			    					<p class="sec05AP">월-금 09:00~17:00</p>
			    					<p class="sec05AP">(주말 및 공휴일 휴무)</p>
			    				</a>
			    			</td>
			    			<td>
			    				<a href="#">
			    					<span class="glyphicon glyphicon-earphone"></span>
			    					<p class="sec05SpanCaption">전화 문의</p>
			    					<p class="sec05AP">1000-1000</p>
			    					<p class="sec05AP">월-금 09:00~17:00</p>
			    					<p class="sec05AP">(주말 및 공휴일 휴무)</p>
			    				</a>
			    			</td>
			    		</tr>
			    	</table>
			    </div>
		    </div>
		</div>
		<jsp:include page="common/footer.jsp" flush="false"></jsp:include>
	</body>
</html>
