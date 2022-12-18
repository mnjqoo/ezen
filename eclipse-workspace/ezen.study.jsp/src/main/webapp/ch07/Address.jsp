<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>
<%
//java.util.Map은 자바의 표준 라이브러리에 있는 인터페이스 이름.
//(데이터 항목을 <이름, 값> 쌍으로 만들어서 저장하고 관리할 수 있는 메소드들이 있다. 자바 프로그램에서 이 메소드들을 호출하려면
//java.util.Map의 구현 클래스인 java.util.HashMap을 만들어서 사용하면 된다.)

HashMap<String, String> map = new HashMap<String, String>();
map.put("gildong", "지리산");
map.put("hyangdan", "남원");
map.put("sooil", "서울");
map.put("soonae", "인천");

request.setAttribute("ADDRESS", map);
RequestDispatcher dispatcher = request.getRequestDispatcher("AddressResult.jsp");
dispatcher.forward(request, response);
%>