<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="ch07.ProductInfo" %>
<%
ProductInfo product = new ProductInfo(); 
product.setName("딸기케이크2호");
product.setPrice(28000);

request.setAttribute("PRODUCT", product);
RequestDispatcher dispatcher = request.getRequestDispatcher("ProductInfoResult.jsp");
dispatcher.forward(request, response);
%>
