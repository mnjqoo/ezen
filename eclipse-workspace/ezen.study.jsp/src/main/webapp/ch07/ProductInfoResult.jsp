<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>상품 정보</title>
	</head>
	<body>
		<h1>상품 정보: ${PRODUCT }</h1>
		<h2>상품명: ${PRODUCT.getName() }</h2>
		<h2>가격: ${PRODUCT.getPrice() }원</h2>
		<hr/>
		<h2>상품명: ${PRODUCT.name }</h2>
		<h2>가격: ${PRODUCT.price }원</h2>
	</body>
</html>