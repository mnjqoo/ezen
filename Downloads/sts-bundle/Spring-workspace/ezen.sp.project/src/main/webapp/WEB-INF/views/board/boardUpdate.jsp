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
		<title>게시글 상세페이지</title>
		<script src="${contextPath}/resources/js/board.js"></script>
	</head>
	<body>
		<jsp:include page="../common/topMenu.jsp" flush="false"></jsp:include>
		
		<div class="container">
			<form class="form-horizontal" id="frm">
				<div class="form-group">
					<div>
						<h2 align="center">게시글 수정 화면</h2>
					</div>
				</div>
				<div class="form-group">
					<label for="subject" class="col-sm-2 control-label">제 목</label>
					<div class="col-sm-10">
						<input type="text" class="form-control" id="subject" name="subject" maxlength="200" value="${boardDetail.subject}"/>
					</div>
				</div>
				<div class="form-group">
					<label for="subject" class="col-sm-2 control-label">작성일자</label>
					<div class="col-sm-5">
						<input type="text" class="form-control" id="reg_date" name="reg_date" value="<fmt:formatDate value='${boardDetail.reg_date}' pattern='yyyy년 MM월 dd일 a hh시 mm분 ss초'/>" readonly/>
					</div>
				</div>
				<div class="form-group">
					<label for="subject" class="col-sm-2 control-label">조회수</label>
					<div class="col-sm-3">
						<input type="text" class="form-control" id="readCount" name="readCount" maxlength="4" value="${boardDetail.readCount}" readonly/>
					</div>
				</div>
				<div class="form-group">
					<label for="subject" class="col-sm-2 control-label">작성자</label>
					<div class="col-sm-3">
						<input type="text" class="form-control" id="writer" name="writer" maxlength="3" value="${boardDetail.writer}"/>
					</div>
				</div>
				<div class="form-group">
					<label for="subject" class="col-sm-2 control-label">내용</label>
					<div class="col-sm-10">
						<textarea class="form-control" id="content" name="content" rows="10" cols="160">${boardDetail.content}</textarea>
					</div>
				</div>
				<div class="form-group">
					<p align="center">
						<button type="reset" class="btn btn-danger">
							<span class="glyphicon glyphicon-erase"> 다시 입력</span>
						</button>
						<button type="button" class="btn btn-primary" onclick="location.href='${contextPath}/board/boardList'">
							<span class="glyphicon glyphicon-list-alt"> 게시글 목록</span>
						</button>
						<button type="button" class="btn btn-warning" onclick="fn_boardUpdate(${boardDetail.bno})"">
							<span class="glyphicon glyphicon-pencil"> 게시글 수정</span>
						</button>
					</p>
				</div>
			</form>
		</div>
		
		<jsp:include page="../common/footer.jsp" flush="false"></jsp:include>
	</body>
</html>