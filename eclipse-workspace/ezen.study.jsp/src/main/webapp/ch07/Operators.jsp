<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>익스프레션 언어의 연산자</title>
	</head>
	<body>
		<h1>익스프레션 언어의 연산자</h1>
		<h1>X = ${param.NUM1}, Y = ${param.NUM2}</h1>
		<hr/>
		<h1>X + Y = ${param.NUM1 + param.NUM2}</h1>
		<h1>X - Y = ${param.NUM1 - param.NUM2}</h1>
		<h1>X * Y = ${param.NUM1 * param.NUM2}</h1>
		<h1>X / Y = ${param.NUM1 / param.NUM2}</h1>
		<h1>X div Y = ${param.NUM1 div param.NUM2}</h1>
		<h1>X % Y = ${param.NUM1 % param.NUM2}</h1>
		<h1>X mod Y = ${param.NUM1 mod param.NUM2}</h1>
		
		<h1>X가 더 큰가요? ${param.NUM1 - param.NUM2 > 0 }</h1>
		<h1>X가 더 큰가요?(gt) ${param.NUM1 - param.NUM2 gt 0 }</h1>
		<h1>X가 더 작은가요? ${param.NUM1 - param.NUM2 < 0 }</h1>
		<h1>X가 더 작은가요?(lt) ${param.NUM1 - param.NUM2 lt 0 }</h1>
		
		<h1>X가 더 크거나 같은가요? ${param.NUM1 - param.NUM2 >= 0 }</h1>
		<h1>X가 더 크거나 같은가요?(ge) ${param.NUM1 - param.NUM2 ge 0 }</h1>
		<h1>X가 더 작거나 같은가요? ${param.NUM1 - param.NUM2 <= 0 }</h1>
		<h1>X가 더 작거나 같은가요?(le) ${param.NUM1 - param.NUM2 le 0 }</h1>
		
		<h1>X와 Y는 모두 양수인가요? ${param.NUM1 > 0 && param.NUM2 > 0 }</h1>
		<h1>X와 Y는 모두 양수인가요?(and) ${param.NUM1 gt 0 and param.NUM2 gt 0 }</h1>
		
		<h1>X와 Y는 같은가요? ${param.NUM1 == param.NUM2 ? "예" : "아니오" }</h1>
		<h1>X와 Y는 같은가요?(eq) ${param.NUM1 eq param.NUM2 ? "예" : "아니오" }</h1>
		
		
	</body>
</html>