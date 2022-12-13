<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.io.*" %>
<%
String agree = request.getParameter("AGREE");
String result = null; //처리 결과를 저장할 변수

if(agree.equals("YES")) { //약관에 동의한 경우
	//사용자 아이디.text 파일을 만든다.
	String id = (String) session.getAttribute("ID");
	String password = (String) session.getAttribute("PASSWORD");
	String name = (String) session.getAttribute("NAME");
	
	PrintWriter writer = null;
	
	try {
		String filePath = application.getRealPath("/WEB-INF/" + id + ".txt");
		writer = new PrintWriter(filePath);
		writer.println("회원가입정보");
		writer.println("=================");
		writer.println("아이디: " + id);
		writer.println("비밀번호: " + password);
		writer.println("이름: " + name);
		
		result = "SUCCESS";
	} catch (IOException ioe ){
		result = "FAIL";
	} finally {
		try {
			writer.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
} else { //약관에 동의하지 않은 경우
	result = "FAIL";
}

//다 사용한 세션을 제거한다.
session.invalidate();

//처리 결과 화면으로 이동한다.(주소에 해당하는 값들은 띄어쓰기를 하면 안됨.)
response.sendRedirect("Result.jsp?RESULT=" + result);
%>