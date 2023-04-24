<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c"	uri="http://java.sun.com/jsp/jstl/core" %>
	<div class="navbar-fixed-top" id="mainTopNav">
		<div>
			<a href="/">로고</a>				
		</div>
		<div class="nav_right">
			<ul>
				<li><a href="/home">고객센터</a></li>
				<c:choose>
					<c:when test="${memberSession != null}">
						<li class="dropdown">
							<a href="#" class="dropdown-toggle" data-toggle="dropdown">
								${memberSession.user_name} <span class="caret"></span>
							</a>
							<ul class="dropdown-menu">
								<li>
									<a href="/member/myOrderList.form?user_email=${memberSession.user_email}">내 운송 목록</a>
								</li>
							</ul>
						</li>
						<li>
							<a href="/member/logout.do">로그아웃</a></li>
					</c:when>
					<c:otherwise>
						<li><a href="/member/login.form">로그인</a></li>
						<li><a href="/member/register.form">회원가입</a></li>
					</c:otherwise>
				</c:choose>	
			</ul>
		</div>
	</div>