package com.edu.member.controller;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.edu.common.criteria.OrderArrayCriteria;
import com.edu.common.criteria.PageMaker;
import com.edu.member.dto.MemberDTO;
import com.edu.member.service.MemberService;
import com.edu.order.service.OrderService;

@Controller("memberController")
@RequestMapping("/member")
public class MemberController {

	private static final Logger logger = LoggerFactory.getLogger(MemberController.class);
	
	@Inject
	MemberService memberService;
	
	@Inject
	OrderService orderService;
	
	//로그인 화면 띄우기
	@RequestMapping(value="/login.form", method=RequestMethod.GET)
	public ModelAndView loginForm() throws Exception {
		logger.info("MemberController의 loginForm 불러오기 시작....");
		
		ModelAndView mav = new ModelAndView();
		mav.setViewName("/member/loginForm");
		return mav;
	}
	
	//로그인 처리하기
	@ResponseBody
	@RequestMapping(value="/login.do", method=RequestMethod.POST)
	public int login(String email, String password, HttpServletRequest request) throws Exception {
		logger.info("MemberController의 login 처리 시작...");
		System.out.println("로그인 정보 => email: " + email + " 비밀번호: " + password);
		
		//해당 아이디로 memberDTO객체를 가져온다.
		MemberDTO memberDTO = memberService.getMemberDTOByEmail(email);
		
		//이메일에 해당하는 memberDTO가 있는지 확인한다.
		if(memberDTO == null) {
			//없으면 1을 리턴해준다.
			return 1;
		} else {
			//있으면 해당 객체의 비밀번호가 일치하는지 확인한다.
			if(!memberDTO.getUser_pwd().equals(password)) {
				//비밀번호가 일치하지 않으면 2를 리턴한다.
				return 2;
			} else {
				//아이디와 비밀번호가 일치하면 세션을 발급해주고 3을 리턴한다.
				HttpSession session = request.getSession();
				session.setAttribute("memberSession", memberDTO); //회원 정보 세션
				
				OrderArrayCriteria oCri = new OrderArrayCriteria();
				oCri.setUser_email(email);
				session.setAttribute("myOrderSession", orderService.myOrderList(oCri)); //최근 운송 세션
				
				return 3;
			}
			
		}
	}
	
	//로그아웃 처리하기
	@RequestMapping(value="/logout.do", method=RequestMethod.GET)
	public String logount(HttpServletRequest request) throws Exception {
		System.out.println("MemberController logount() 시작...");
		
		//세션을 제거해준다.
		HttpSession session = request.getSession();
		session.removeAttribute("memberSession");
		session.removeAttribute("myOrderSession");
		
		return "/home";
	}
	
	//회원가입 화면 띄우기
	@RequestMapping(value="/register.form", method=RequestMethod.GET)
	public ModelAndView registerForm() throws Exception {
		logger.info("MemberController의 registerForm 불러오기 시작....");
		
		ModelAndView mav = new ModelAndView();
		mav.setViewName("/member/registerForm");
		
		return mav;
	}
	
	//이메일 중복 검사하기
	@ResponseBody
	@RequestMapping(value="/emailCheck.do", method=RequestMethod.POST)
	public int emailCheck(MemberDTO memberDTO) throws Exception {
		System.out.println("MemberController 이메일 중복 검사  처리 시작...회원 정보: " + memberDTO);
		
		return memberService.emailCheck(memberDTO);
	}
	
	//회원가입 처리하기
	@ResponseBody
	@RequestMapping(value="/register.do", method=RequestMethod.POST)
	public int register(MemberDTO memberDTO, HttpServletRequest request) throws Exception {
		System.out.println("MemberController의 register 처리 시작...");
		
		if(memberService.register(memberDTO) == 1) {
			//회원 등록에 성공하면 메인으로 보내주기 전에 세션을 등록한다.
			HttpSession session = request.getSession();
			session.setAttribute("memberSession", memberDTO);
			return 1;
		} else {
			return 0;
		}
		
	}
	
	//회원 정보 업데이트 하기
	@ResponseBody
	@RequestMapping(value="/update.do", method=RequestMethod.POST)
	public int update(MemberDTO memberDTO) throws Exception {
		System.out.println("MemberController의 update 처리 시작...");
		
		return memberService.update(memberDTO);
	}
	
	//나의 운송 목록 보기 (페이징 + 정렬)
	@RequestMapping(value="/myOrderList.form", method=RequestMethod.GET)
	public ModelAndView myOrderListForm(OrderArrayCriteria oCri) throws Exception {
		System.out.println("MemberController의 myOrderListForm 처리 시작...");
		
		ModelAndView mav = new ModelAndView();
		
		//모델에 해당 회원의 운송 리스트를 담아준다.
		mav.addObject("myOrderList", orderService.myOrderList(oCri));
		
		//pageMaker에 대한 세팅을 한다.(paging 처리를 위해)
		PageMaker pageMaker = new PageMaker();
		pageMaker.setCri(oCri);	//Criteria 세팅
		pageMaker.setTotalCount(orderService.getMyListCount(oCri));		//totalcount 세팅
		//model에 담아준다.
		mav.addObject("pageMaker", pageMaker);
		
		//주소를 세팅한다.
		mav.setViewName("/order/myOrderListForm");
		
		return mav;
	}
	
}

