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
		<title>게시글 전체 목록</title>
	</head>
	<body>
		<jsp:include page="../common/topMenu.jsp" flush="false"></jsp:include>
		
		<div class="container">
			<form class="form-horizontal" id="frm">
				<div class="form-group">
					<div>
						<h2 align="center">게시글 목록</h2>
					</div>
				</div>
				
				<p align="center">
					<button type="button" class="btn btn-primary" onclick="location.href='/board/boardRegisterForm?flag=0'">게시글 작성하기</button>
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
		</div>
		
		<jsp:include page="../common/footer.jsp" flush="false"></jsp:include>
	</body>
</html>