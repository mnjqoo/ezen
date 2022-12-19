<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
//scope = request
//자바빈 객체가 request 데이터의 영역에 저장되도록 만든다.
%>
<jsp:useBean class="ch08.PersonalInfo" id="pinfo" scope="request">
	<jsp:setProperty property="name" name="pinfo" value="심순애"/>
	<jsp:setProperty property="gender" name="pinfo" value="여"/>
	<jsp:setProperty property="age" name="pinfo" value="18"/>
</jsp:useBean>

<jsp:forward page="PersonalInfoViewer.jsp"/>
