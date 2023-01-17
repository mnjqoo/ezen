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
		<title>게시글 목록3</title>
		<script src="${contextPath}/resources/js/board.js"></script>
	</head>
	<body>
	
		<jsp:include page="../common/topMenu.jsp" flush="false"></jsp:include>
		
		<div class="container">
			<form class="form-horizontal" id="frm">
				<div class="form-group">
					<div>
						<h2 align="center">게시글 목록 (paging 3 + 검색)</h2>
					</div>
				</div>
				
				<p align="center">
					<button type="button" class="btn btn-primary" onclick="location.href='/board/boardRegisterForm?flag=1'">게시글 작성하기</button>
				</p>
				
				<h1>현재 페이지: ${pageMaker.cri.getPage()}</h1>
				
				<!-- 게시글 목록 영역 -->
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
						<c:forEach items="${boardList}" var="board">
							<tr>
								<td align="center">${board.bno}</td>
								<td align="center"><a href="${contextPath}/board/boardDetail?bno=${board.bno}">${board.subject}</a></td>
								<td>${board.content}</td>
								<td align="center">${board.writer}</td>
								<td align="center"><fmt:formatDate value="${board.reg_date}" pattern="yyyy년 MM월 dd일 a hh시 mm분 ss초"></fmt:formatDate></td>
								<td align="right">${board.readCount}</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</form>
			
			<!-- 검색 영역 -->
			
			
			<div align="center"> <!-- 페이지 숫자를 보여주는 영역 -->
				<ul class="btn-group pagination">
					<c:if test="${pageMaker.prev}">
						<li>
							<a href="<c:url value='/board/boardList3?page=${pageMaker.startPage - 1}'/>"><span class="glyphicon glyphicon-chevron-left"></span></a>
						</li>
					</c:if>
						
					<c:forEach var="pageNum" begin="${pageMaker.startPage}" end="${pageMaker.endPage}">
						<li>
							<a href="<c:url value='/board/boardList3?page=${pageNum}'/>">${pageNum}</a>
						</li>
					</c:forEach>
						
					<c:if test="${pageMaker.next}">
						<li>
							<a href="<c:url value='/board/boardList3?page=${pageMaker.endPage + 1}'/>"><span class="glyphicon glyphicon-chevron-right"></span></a>
						</li>
					</c:if>
				</ul>
			</div>
		</div>
		
		<jsp:include page="../common/footer.jsp" flush="false"></jsp:include>
		
	</body>
</html>