<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:useBean class="ch08.ClothingInfo" id="pinfo" scope="request">
	<jsp:setProperty property="code" name="pinfo" value="k63012"/>
	<jsp:setProperty property="name" name="pinfo" value="소나기"/>
	<jsp:setProperty property="price" name="pinfo" value="13500"/>
	<jsp:setProperty property="size" name="pinfo" value="M"/>
	<jsp:setProperty property="color" name="pinfo" value="NAVI"/>
</jsp:useBean>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>의류 정보</title>
	</head>
	<body>
		<h2>옷의 정보가 저장되었습니다.</h2>
		<hr/>
		<h1>제품 기본 정보</h1>
		<jsp:include page="ProductInfo.jsp"/>
		<h2>사이즈: <jsp:getProperty property="size" name="pinfo"/></h2>
		<h2>색상: <jsp:getProperty property="color" name="pinfo"/></h2>
	</body>
</html>