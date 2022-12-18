<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:useBean class="ch08.BookInfo" id="pinfo" scope="request">
	<jsp:setProperty property="code" name="pinfo" value="k63011"/>
	<jsp:setProperty property="name" name="pinfo" value="소나기"/>
	<jsp:setProperty property="price" name="pinfo" value="13500"/>
	<jsp:setProperty property="page" name="pinfo" value="120"/>
	<jsp:setProperty property="writer" name="pinfo" value="황순원"/>
</jsp:useBean>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>책 정보</title>
	</head>
	<body>
		<h2>책의 정보가 저장되었습니다.</h2>
		<hr/>
		<h1>제품 기본 정보</h1>
		<jsp:include page="ProductInfo.jsp"/>
		<h2>저자: <jsp:getProperty property="writer" name="pinfo"/></h2>
		<h2>페이지 수: <jsp:getProperty property="page" name="pinfo"/></h2>
	</body>
</html>