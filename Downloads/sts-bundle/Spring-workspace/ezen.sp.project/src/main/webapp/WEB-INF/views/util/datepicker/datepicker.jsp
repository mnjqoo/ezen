<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import = "java.util.*" %>
<%@ page import = "java.sql.Timestamp" %>
<%@ taglib prefix="c"	uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt"	uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<%	request.setCharacterEncoding("UTF-8"); 

	Timestamp nowTime = new Timestamp(System.currentTimeMillis());
	int lastYear = Integer.parseInt(nowTime.toString().substring(0, 4)); //현재 년도를 구한다.(가장 최근 년도)
%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
		<!-- datepicker에서 사용 -->
  		<link rel="stylesheet" href="http://code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
	</head>
	<body>
		<jsp:include page="../../common/topMenu.jsp" flush="false"></jsp:include>
		
		<!-- datepicker에서 사용 -->
		<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>  

		<div class="container">
			<form class="form-horizontal">
				<div class="form-group">
					<div>
						<h2 align="center">도서 정보</h2>
					</div>
				</div>
				
				<div class="form-group">
					<label class="control-label col-sm-2">출판일자</label>
					<div class="col-sm-2">
						<div class="input-group">
							<select class="form-control" name="publishing_year" style="width:100%" onkeydown="nextFocus(publishing_month)">
								<% for(int year = lastYear; year >= 2001; year--){ %>
								<option value="<%= year %>"><%= year %></option>
								<% } %>
							</select>
							<span class="input-group-addon">년</span>
						</div>
					</div>
					<div class="col-sm-2">
						<div class="input-group">
							<select class="form-control" name="publishing_month" style="width:100%" onkeydown="nextFocus(publishing_day)">
								<c:forEach var="month" begin="1" end="12" step="1"> <!-- step:1 = 1++ -->
									<option value="${month}" <c:if test="${month == 5}">selected</c:if>>${month}</option>
								</c:forEach>
							</select>
							<span class="input-group-addon">월</span>
						</div>
					</div>
					<div class="col-sm-2">
						<div class="input-group">
							<select class="form-control" name="publishing_day" style="width:100%" onkeydown="nextFocus(publishing_com)">
								<c:forEach var="day" begin="1" end="31" step="1">
									<option value="${day}">${day}</option>
								</c:forEach>
							</select>
							<span class="input-group-addon">일</span>
						</div>
					</div>
				</div>
			</form>
		</div>
		
		<div class="container">
			<form class="form-horizontal">
				<div class="form-group">
					<div>
						<h2 align="center">제품 생산 계획</h2>
					</div>
				</div>
				<div class="form-group">
					<label class="control-label col-sm-2">일자</label>
					<div class="col-sm-2">
						<input type="text" class="form-control" id="datepicker1" placeholder="날짜를 선택하십시오."/>
					</div>
				</div>
				<div class="form-group">
					<label class="control-label col-sm-2">일자</label>
					<div class="col-sm-2">
						<input type="text" class="form-control" id="datepicker2" placeholder="날짜를 선택하십시오."/>
					</div>
				</div>
				
				<div class="form-group">
					<label class="control-label col-sm-2">조회기간을 선택하십시오.</label>
					<div class="col-sm-2">
						<input type="text" class="form-control" id="datepicker3" placeholder="날짜를 선택하십시오."/>
					</div>
					<div class="col-sm-1">
						&nbsp;~&nbsp;
					</div>
					<div class="col-sm-2">
						<input type="text" class="form-control" id="datepicker4" placeholder="날짜를 선택하십시오."/>
					</div>
				</div>
			</form>
		</div>
		
		<jsp:include page="../../common/footer.jsp" flush="false"></jsp:include>
		
		<script>
		function nextFocus(where){
			if(event.keyCode == 13) {	// Enter 키를 눌렀을 경우, 다음 입력 필드로 이동시킨다.
				where.focus();
			}
		}
		</script>
		
		<script>
		$(function() {
			$("#datepicker1").datepicker();
			
			$("#datepicker2").datepicker({
				//선택 할 수 있는 최대 날짜를 지정한다. +1m +1w: 한달, 일주일 뒤까지 선택할 수 있다.[+, -][숫자][y, m, w, d]
				maxDate: "+1m +1w",
				minDate: "-1y"
			});
			
			$("#datepicker3, #datepicker4").datepicker({
				//옵션들 생략
			});
		});
		
		$.datepicker.setDefaults({
			showOn: "both", //버튼과 텍스트 필드 모드 캘린더를 보여준다.
			changeYear: true, //년도를 바꿀 수 있는 select 박스 보기 옵션
			changeMonth: true, //월을 바꿀 수 있는 select 박스 보기 옵션
			showAnim: "slide", //캘린더에 애니메이션을 적용한다.
			dateFormat: "yy-mm-dd", //날짜 형식을 적용한다.
			prevText: '이전 달', //마우스 오버시 이전달이라는 텍스트 말풍선 도움말을 보여준다.
			nextText: '다음 달', //마우스 오버시 이전달이라는 텍스트 말풍선 도움말을 보여준다.
			closeText: '닫기', //닫기 버튼 텍스트 변경
			currentText: '오늘', //오늘 버튼 텍스트 변경
			//monthNames: ['1월', '2월', '3월', '4월', '5월', '6월', '7월', '8월', '9월', '10월', '11월', '12월'], //월을 한글로 변경
			monthNamesShort: ['1월', '2월', '3월', '4월', '5월', '6월', '7월', '8월', '9월', '10월', '11월', '12월'], //월을 한글로 변경
			dayNamesMin: ['일', '월', '화', '수', '목', '금', '토', '일'], //요일을 한글로 변경
			showMonthAfterYear: true, //년 월 로 표기한다.
			yearSuffix: '년', //년도 select 박스 다음에 글자를 넣는다.
			showButtonPanel: true //오늘로 가는 버튼과 달력 닫기 버튼 보기 옵션
		});
		</script>
	</body>
</html>