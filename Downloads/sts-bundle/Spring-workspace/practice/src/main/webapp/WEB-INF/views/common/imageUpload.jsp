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
		</style>
	</head>
	<body>
		<div class="form-group">
			<div class="fileDrop">
			
			</div>
			<br/>
			<div>
				<input type="file" name="file"/>
				<input type="submit" value="파일 올리기"/>
				<input type="button" value="파일 삭제"/>
			</div>
		</div>
			
	</body>
</html>