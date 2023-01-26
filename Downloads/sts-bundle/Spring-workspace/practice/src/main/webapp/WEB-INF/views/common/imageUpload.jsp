<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
		<script src="${contextPath}/resources/js/fileJs.js"></script>
		
		<style>
		.fileDrop {
			width: 120px;
			height: 180px;
			border: 1px dotted #FFF;
		}
		</style>
	</head>
	<body>
		<div class="form-group">
			<div class="fileDrop">
			
			</div>
			<br/>
			<div>
				<input type="file" id="file" name="file"/>
				<input type="button" value="파일 등록" onclick="fn_fileUpload(file);"/>
			</div>
		</div>
			
	</body>
</html>