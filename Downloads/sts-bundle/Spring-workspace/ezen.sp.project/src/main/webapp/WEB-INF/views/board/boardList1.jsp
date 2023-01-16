<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c"	uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt"	uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<%	request.setCharacterEncoding("UTF-8"); %>
<% 
if(session.getAttribute("isLogOn") == null || session.getAttribute("member") == null){
	out.println("<script>");
	out.println("alert('로그인을 하셔야 서비스를 사용하실 수 있습니다.');");
	out.println("location.href='/main.do'");
	out.println("</script>");
} else {
	String id = (String) session.getAttribute("id");
}
%>


<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>게시글 목록1</title>
		<script src="${contextPath}/resources/js/board.js"></script>
	</head>
	<body>
		<jsp:include page="../common/topMenu.jsp" flush="false"></jsp:include>
		
		<div class="container">
			<form class="form-horizontal" id="frm">
				<div class="form-group">
					<div>
						<h2 align="center">게시글 목록 (paging 1)</h2>
					</div>
				</div>
				
				<p align="center">
					<button type="button" class="btn btn-primary" onclick="location.href='/board/boardRegisterForm?flag=1'">게시글 작성하기</button>
				</p>
				
				<table class="table table-bordered table-striped table-hover">
					<thead>
						<tr class="info">
							<th class="col-sm-1 text-center">번호</th>
							<th class="col-sm-3 text-center">제 목</th>
							<th class="col-sm-3 text-center">내 용</th>
							<th class="col-sm-1 text-center">작성자</th>
							<th class="col-sm-3 text-center">작성일자</th>
							<th class="col-sm-1 text-center">조회수</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${boardList}" var="list">
							<tr>
								<td align="center">${list.bno}</td>
								<td align="center"><a href="${contextPath}/board/boardDetail?bno=${list.bno}">${list.subject}</a></td>
								<td>${list.content}</td>
								<td align="center">${list.writer}</td>
								<td align="center"><fmt:formatDate value="${list.reg_date}" pattern="yyyy년 MM월 dd일 a hh시 mm분 ss초"></fmt:formatDate></td>
								<td align="right">${list.readCount}</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</form>
				
				<div align="center"> <!-- 페이지 숫자를 보여주는 영역 -->
					<c:if test="${totalCount > 0}">
						<h1>현재 페이지: ${pageNum}</h1>
						<c:set var="totalCount" value="${totalCount}"/> <!-- 전체 게시글 데이터 건수 -->
						<c:set var="pageSize" value="10"/>
						<c:set var="pageBlock" value="10"/>
						
						<fmt:parseNumber var="pageCountInt" integerOnly="true" value="${(totalCount / pageSize)}"></fmt:parseNumber>
						<c:set var="pageCount" value="${pageCountInt + (totalCount % pageSize == 0 ? 0 : 1)}"/> <!-- 보여줄 페이지 수. 10으로 나눠서 나머지가 있으면 1페이지를 더한다.-->
						
						<!-- <c:set var="startPage" value="${(pageNum / 10) * 10 + 1 }"/> 실수가 나온다. -->
						<fmt:parseNumber var="startPageInt" integerOnly="true" value="${(pageNum / pageSize)}"></fmt:parseNumber><!-- 정수로 만든다. -->
						<c:if test="${pageNum % pageSize == 0 }"> <!-- 현재 페이지가 10으로 나누어 떨어질 때 startPage를 유지 해야하므로 startPageInt를 1 빼준다. -->
							<c:set var="startPageInt" value="${startPageInt - 1}"/>
						</c:if>
						
						<c:set var="startPage" value="${startPageInt * pageSize + 1}"/> <!-- 첫번째 페이지 숫자 -->
						<c:set var="endPage" value="${startPage + pageBlock - 1}"/> <!-- 마지막 페이지 숫자 -->
						
						<c:if test="${endPage > pageCount}">
							<c:set var="endPage" value="${pageCount}"/>
						</c:if>
						
						
						<c:if test="${startPage != 1}"> <!-- 이전페이지 이동 -->
							<a href="/board/boardList1?pageNum=${startPage - pageBlock}">[이전]</a>
						</c:if>
						
						<c:forEach var="page" begin="${startPage}" end="${endPage}">
							<a href="/board/boardList1?pageNum=${page}">[${page}]</a>
						</c:forEach>
						
						<c:if test="${endPage != pageCount }"> <!-- 다음 페이지 이동 -->
							<a href="/board/boardList1?pageNum=${startPage + pageBlock}">[다음]</a>
						</c:if>
					</c:if>
				</div>
			
		</div>
		
		<jsp:include page="../common/footer.jsp" flush="false"></jsp:include>
	</body>
</html>