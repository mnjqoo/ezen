package com.edu.member.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.edu.member.dto.MemberDTO;


public interface MemberController {
	
	// 로그인 폼
	public ModelAndView loginForm(HttpServletRequest request, HttpServletResponse response) throws Exception; 
	
	// 로그인 처리
	public ModelAndView login(@ModelAttribute("member") MemberDTO member, RedirectAttributes rAttr, HttpServletRequest request, HttpServletResponse response) throws Exception; 
	
	// 로그아웃 처리
	public ModelAndView logout(HttpServletRequest request, HttpServletResponse response) throws Exception;
	
	// 회원가입 폼
	public ModelAndView memberForm(HttpServletRequest request, HttpServletResponse response) throws Exception;
	
	// 회원가입 처리
	public ModelAndView addMember(@ModelAttribute("member") MemberDTO memberDTO, HttpServletRequest request, HttpServletResponse response) throws Exception;
	
	// 회원목록 처리
	public ModelAndView listMembers(HttpServletRequest request, HttpServletResponse response) throws Exception;
	
	// 아이디에 해당하는 회원 조회 + 회원수정 폼
	public ModelAndView updateMemberForm(@RequestParam("id") String id, HttpServletRequest request, HttpServletResponse response) throws Exception;
	
	// 회원수정 처리
	public ModelAndView modifyMember(@ModelAttribute("member") MemberDTO memberDTO, HttpServletRequest request, HttpServletResponse response) throws Exception;
	
	// 아이디에 해당하는 회원삭제 처리
	public ModelAndView removeMember(@RequestParam("id") String id, HttpServletRequest request, HttpServletResponse response) throws Exception;

	// 회원가입 폼 (Ajax)
	public String getRegisterAjaxForm() throws Exception;
	
	// 아이디 중복 확인 (Ajax)
	public int idCheck(@ModelAttribute("member") MemberDTO memberDTO) throws Exception;
	
} // End - public interface MemberController






