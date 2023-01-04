package com.edu.member.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;

//-----------------------------------------------------------------------------------------------------------
// public interface MemberController
//-----------------------------------------------------------------------------------------------------------
public interface MemberController {
	
	//-----------------------------------------------------------------------------------------------------------
	// 로그인 폼
	//-----------------------------------------------------------------------------------------------------------
	public ModelAndView loginForm(HttpServletRequest request, HttpServletResponse response) throws Exception;
	

} // End - public interface MemberController






