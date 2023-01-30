<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
		
		<style>
		.fileDrop {
			width: 120px;
			height: 180px;
			border: 1px dotted #FFF;
		}
		.fileDrop p {
			padding-top: 50%;
		}
		</style>
	</head>
	<body>
		<div class="form-group">
			<div class="fileDrop">
				<p id="p" align="center">파일 드롭</p>
			</div>
			
			<br/>
			
			<div>
				<input type="file" id="file" name="file"/>
				<input type="button" value="파일 등록" onclick="fn_fileUpload();"/>
			</div>
		</div>
			
	</body>
</html>