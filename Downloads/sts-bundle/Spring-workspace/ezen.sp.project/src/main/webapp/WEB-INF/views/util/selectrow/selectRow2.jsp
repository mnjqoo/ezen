<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import = "java.util.*" %>
<%@ page import = "java.sql.Timestamp" %>
<%@ taglib prefix="c"	uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt"	uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<%	request.setCharacterEncoding("UTF-8"); %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
		<style>
		table {
			border: 1px solid #DDD;
		}
		td {
			border: 1px solid #BBB;
			text-align: center;
			font-size: 2em;
		}
		</style>
	</head>
	<body>
		<jsp:include page="../../common/topMenu.jsp" flush="false"></jsp:include>
		
		<div class="container">
			<h1 align="center">Selected Row &amp; Selected Column2</h1>
			<hr/>
			<table class="table table-stiped" id="myTable">
				<tr>
					<td>0-0</td><td>0-1</td><td>0-2</td><td>0-3</td>
				</tr>
				<tr>
					<td>1-0</td><td>1-1</td><td>1-2</td><td>1-3</td>
				</tr>
				<tr>
					<td>2-0</td><td>2-1</td><td>2-2</td><td>2-3</td>
				</tr>
				<tr>
					<td>3-0</td><td>3-1</td><td>3-2</td><td>3-3</td>
				</tr>
				<tr>
					<td>4-0</td><td>4-1</td><td>4-2</td><td>4-3</td>
				</tr>
				<tr>
					<td>5-0</td><td>5-1</td><td>5-2</td><td>5-3</td>
				</tr>
			</table>
		</div>
		
		<jsp:include page="../../common/footer.jsp" flush="false"></jsp:include>
		
		<script>
		$(document).ready(function(){
			/*
			$("#myTable").on("click", "tr", function(){
					
					alert($(this).find("td:eq(0)").text()); //누른 tr의 0번째
					alert($(this).find("td:eq(1)").text()); //누른 tr의 1번째
			});
			*/
			
			$("td").click(function(){
				//index는 0부터 시작한다.
				let rowIndex = $(this).parent().parent().children().index($(this).parent());
				
				let colIndex = $(this).parent().children().index($(this));
				
				alert(rowIndex + ":" + colIndex);
			});
		});
		</script>
	</body>
</html>