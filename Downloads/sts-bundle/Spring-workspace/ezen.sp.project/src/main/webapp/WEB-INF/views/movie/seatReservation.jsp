<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c"	uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt"	uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<%	request.setCharacterEncoding("UTF-8"); %>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>영화 좌석 예약</title>
	</head>
	<body>
		<jsp:include page="../common/topMenu.jsp" flush="false"></jsp:include>
	
		<div class="container">
			<!-- 좌석 예약 현황 -->
			<div class="row" align="center">
				<div class="col-sm-offset-2 col-sm-8">
					<h2>좌석 예약</h2>
				</div>
				<div class="col-sm-offset-3 col-sm-8">
					<label class="control-label col-sm-2">남은 좌석 수</label>
					<div id="reserveNO" class="col-sm-1" style="font-size:1.2em; width:80px; height:28px; border:1px solid; background-color:#2F70A9; color:#FFF; float:left;">
						${reserveNO}
					</div>
					
					<label class="control-label col-sm-2">예약된 좌석 수</label>
					<div id="reserveOK" class="col-sm-1" style="font-size:1.2em; width:80px; height:28px; border:1px solid; background-color:#D77875; color:#FFF; float:left;">
						${reserveOK}
					</div>
				</div>
			</div>
			
			<div class="row" align="center">
				<form action="" method="post" class="pt-3" style="max-width: 1720px;">
					<c:forEach var="list" items="${seatList}" begin="0" end="99" varStatus="status">
						<!-- 좌석 1-100까지 만들기 -->
						<c:choose>
							<c:when test="${list.status == false}"> <!-- 예약 안된 상태일 때 -->
								<button type="button" class="btn btn-primary seatNO" style="width:50px;" value="${list.seatID}">${list.seatID}</button>
							</c:when>
							<c:otherwise> <!-- 예약된 상태일 때 -->
								<button type="button" class="btn btn-danger seatOK" style="width:50px;" value="${list.seatID}" disabled>${list.seatID}</button>
							</c:otherwise>
						</c:choose>
						<!-- 12개씩 줄바꿈 해준다. -->
						<c:choose>
							<c:when test="${status.count %12 == 0}"><br/></c:when> 
						</c:choose>
					</c:forEach>
					
					<br/>
					<br/>
					<br/>
					
					<c:forEach var="list" items="${seatList}" begin="100" end="199" varStatus="status">
						<!-- 좌석 101-200까지 만들기 -->
						<c:choose>
							<c:when test="${list.status == false}"> <!-- 예약 안된 상태일 때 -->
								<button type="button" class="btn btn-primary seatNO" style="width:50px;" value="${list.seatID}">${list.seatID}</button>
							</c:when>
							<c:otherwise> <!-- 예약된 상태일 때 -->
								<button type="button" class="btn btn-danger seatNO" style="width:50px;" value="${list.seatID}" disabled>${list.seatID}</button>
							</c:otherwise>
						</c:choose>
						<!-- 16개씩 줄바꿈 해준다. -->
						<c:choose>
							<c:when test="${status.count %16 == 0}"><br/></c:when> 
						</c:choose>
					</c:forEach>
				</form>
			</div>
		</div>
	
		<jsp:include page="../common/footer.jsp" flush="false"></jsp:include>
		
		<script>
		//빈 좌석을 클리갛면 예약 업무를 실행한다.
		$(".seatNO").on("click", function() {
			
			var idx = $(".seatNO").index(this);
			alert(idx + "를 클릭하셨습니다.")
			
		});
		
		</script>
	</body>
</html>