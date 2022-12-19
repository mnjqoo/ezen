<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<jsp:useBean id="pinfo" class="ch08.ProductInfo" scope="request"/>
<h2>제품 코드: <jsp:getProperty property="code" name="pinfo"/></h2>
<h2>제품 명: <jsp:getProperty property="name" name="pinfo"/></h2>
<h2>제품 가격: <jsp:getProperty property="price" name="pinfo"/></h2>