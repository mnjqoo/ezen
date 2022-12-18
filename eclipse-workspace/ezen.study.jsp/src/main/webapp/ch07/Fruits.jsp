<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>
<%
//java.util.list는 자바의 표준 라이브러리에 있는 인터페이스 이름.
//(여러개의 데이터 항목을 저장하고 관리할 수 있는 메소드들이 있다. 자바 프로그램에서 이 메소드들을 불러 사용하기 위해서는
//java.util.list의 구현클래스인 java.util.ArrayList나 java.util.LinkedList의 객체를 만들어 사용해야 한다.

//<E> <=Generic
ArrayList<String> items = new ArrayList<String>();
items.add("수박");
items.add("딸기");
items.add("사과");

request.setAttribute("FRUITS", items);
RequestDispatcher dispatcher = request.getRequestDispatcher("FruitsResult.jsp");
dispatcher.forward(request, response);
%>