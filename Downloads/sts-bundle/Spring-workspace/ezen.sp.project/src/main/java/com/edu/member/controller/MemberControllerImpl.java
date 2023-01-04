package com.edu.member.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.edu.member.dto.MemberDTO;

//-----------------------------------------------------------------------------------------------------------
// 회원 정보 컨트롤러
//-----------------------------------------------------------------------------------------------------------
@Controller("memberController")
@RequestMapping("/member")	// url에서 /member로 시작하는 요청들을 처리하는 컨트롤러.
public class MemberControllerImpl implements MemberController {
	
	private static final Logger logger 
		= LoggerFactory.getLogger(MemberControllerImpl.class);

	//-----------------------------------------------------------------------------------------------------------
	//	@Inject		: Java에서 지원하는 어노테이션. 특정 Framework에 종속적이지 않다.
	//	@Autowired	: Spring에서 지원하는 어노테이션.
	//-----------------------------------------------------------------------------------------------------------
	@Autowired
	private	MemberDTO	memberDTO;
	
	// MemberService memberService = new MemberService();
	// @Autowired
	// private	MemberService	memberService;
	
	//-----------------------------------------------------------------------------------------------------------
	// 로그인 화면 띄우기
	//-----------------------------------------------------------------------------------------------------------
	@Override
	@RequestMapping(value="/loginForm.do", method=RequestMethod.GET)
	public ModelAndView loginForm(HttpServletRequest request, HttpServletResponse response) throws Exception {

		ModelAndView mav = new ModelAndView();
		mav.setViewName("/member/loginForm");
		return mav;
		
	}

	
	
} // End - public class MemberControllerImpl






