package com.edu.member.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.edu.member.dto.MemberDTO;
import com.edu.member.service.MemberService;

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
	
	@Autowired
	private	MemberService	memberService;
	
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
	
	// 로그인 처리
	//-----------------------------------------------------------------------------------------------------------
	@Override
	@RequestMapping(value="/login.do", method=RequestMethod.POST)
	public ModelAndView login(@ModelAttribute("member") MemberDTO member, RedirectAttributes rAttr, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		
		logger.info("MemberControllerImpl 로그인 처리 시작....");
		System.out.println("로그인 정보 => " + member.getId() + " : " + member.getPwd());
		
		ModelAndView mav = new ModelAndView();
		
		if(member.getId().equals("") || member.getId() == null) { //아이디 값이 없이 넘어온 경우에는 돌려보낸다.
			rAttr.addAttribute("result", "loginIdEmpty");
			mav.setViewName("redirect:/member/loginForm.do");
			return mav;
		}
		
		
		//로그인한 정보를 가지고 데이터베이스에 존재하는지 확인 하고, 결과를 가져온다.
		memberDTO = memberService.login(member);
		System.out.println("로그인 처리 결과 ==> " + memberDTO);
		
		
		
		
		//로그인한 정보가 데이터베이스에 존재하는지에 따라 처리를 다르게 한다.
		if(memberDTO != null) { //정보가 있으면
			if(member.getPwd().equals(memberDTO.getPwd())) { //입력한 비밀번호가 데이터베이스의 비밀번호와 같으면
				
				HttpSession session = request.getSession(); //세션을 발급한다.
				session.setAttribute("member", memberDTO);
				session.setAttribute("isLogOn", true);
				mav.setViewName("redirect:/main.do"); //메인페이지로 넘어가도록
				
			} else { //아이디는 있는데 비밀번호가 일치하지 않으면
				
				rAttr.addAttribute("result", "PasswordFailed");
				mav.setViewName("redirect:/member/loginForm.do"); //메세지를 가지고 로그인화면으로 이동한다.
				
			}
		} else { //정보가 없으면
			rAttr.addAttribute("result", "LoginFailed");
			mav.setViewName("redirect:/member/loginForm.do"); //메세지를 가지고 로그인화면으로 이동한다.
		}
		
		return mav;
	}

	// 로그아웃 처리
	//-----------------------------------------------------------------------------------------------------------
	@Override
	@RequestMapping(value="/logout.do", method=RequestMethod.GET)
	public ModelAndView logout(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		//세션 정보를 없애고 메인페이지로 이동하게 한다.
		HttpSession session = request.getSession();
		session.removeAttribute("member");
		session.removeAttribute("isLogOn");
		
		ModelAndView mav = new ModelAndView();
		mav.setViewName("redirect:/main.do");
		return mav;
	}
	
	
	// 회원가입 화면 띄우기
	//-----------------------------------------------------------------------------------------------------------
	@Override
	@RequestMapping(value="/memberForm.do", method=RequestMethod.GET)
	public ModelAndView memberForm(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		logger.info("MemberControllerImpl 회원가입 화면 불러오기() 시작...");
		ModelAndView mav = new ModelAndView();
		mav.setViewName("/member/memberForm");
		return mav;
	}

	
	
	// 회원가입 처리
	//-----------------------------------------------------------------------------------------------------------
	@Override
	@RequestMapping(value="/addMember.do", method=RequestMethod.POST)
	public ModelAndView addMember(@ModelAttribute("member") MemberDTO memberDTO, HttpServletRequest request, HttpServletResponse response) throws Exception {
		logger.info("MemberControllerImpl 회원가입 처리 시작....");
		System.out.println("회원가입 정보 => " + memberDTO.getId() + " : " + memberDTO.getPwd());
		
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		
		int result = 0; //데이터 처리 완료 건수를 저장할 변수
		
		result = memberService.addMember(memberDTO);//사용자가 입력한 회원정보를 서비스에게 넘겨주어 처리하게 한다.
		
		System.out.println("회원가입 처리 결과 건수: " + result);
		ModelAndView mav = new ModelAndView("redirect:/member/listMembers.do"); //회원 가입 후 회원 전체 목록페이지로 이동한다.
		
		return mav;
	}
	
	
	// 회원목록 처리
	//-----------------------------------------------------------------------------------------------------------
	@Override
	@RequestMapping(value="/listMembers.do", method=RequestMethod.GET)
	public ModelAndView listMembers(HttpServletRequest request, HttpServletResponse response) throws Exception {
		logger.info("MemberControllerImpl 회원목록 처리 시작....");
		
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		
		List<MemberDTO> membersLists = new ArrayList();
		
		membersLists = memberService.listMembers();
		
		ModelAndView mav = new ModelAndView();
		mav.addObject("membersLists", membersLists);
		mav.setViewName("/member/listMembers");
		return mav;
	}

	// 아이디에 해당하는 회원 조회 + 회원 수정 폼
	//-----------------------------------------------------------------------------------------------------------	
	@Override
	@RequestMapping(value="/updateMemberForm.do", method=RequestMethod.GET)
	public ModelAndView updateMemberForm(@RequestParam("id") String id, HttpServletRequest request, HttpServletResponse response) throws Exception {
		logger.info("MemberControllerImpl 회원수정 화면 불러오기() 시작...");
		
		//요청받은 id에 해당하는 정보를 서비스를 통해 찾는다.
		memberDTO = memberService.selectMember(id);
		logger.info("회원정보 조회 결과: " + memberDTO);
		
		//찾아온 정보를 가지고 회원정보 수정 화면으로 넘어간다.
		ModelAndView mav = new ModelAndView();
		mav.addObject("member", memberDTO);
		mav.setViewName("/member/updateMemberForm");
		return mav;
	}
	
	// 회원 수정 처리
	//-----------------------------------------------------------------------------------------------------------	
	@Override
	@RequestMapping(value="/modifyMember.do", method=RequestMethod.POST)
	public ModelAndView modifyMember(@ModelAttribute("member") MemberDTO memberDTO, HttpServletRequest request, HttpServletResponse response) throws Exception {
		logger.info("MemberControllerImpl 회원수정 처리() 시작...");
		
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		
		int result = memberService.modifyMember(memberDTO);
		System.out.println("회원수정 처리 결과 건수: " + result);
		
		ModelAndView mav = new ModelAndView("redirect:/member/listMembers.do"); //회원 수정 후 회원 전체 목록페이지로 이동한다.
		
		return mav;
	}
	
	// 아이디에 해당하는 회원삭제 처리
	//-----------------------------------------------------------------------------------------------------------	
	@Override
	@RequestMapping(value="/removeMember.do", method=RequestMethod.GET)
	public ModelAndView removeMember(String id, HttpServletRequest request, HttpServletResponse response) throws Exception {
		logger.info("MemberControllerImpl 회원삭제 처리() 시작...");
		
		//요청받은 id에 해당하는 정보를 서비스를 통해 지운다.
		int result = memberService.removeMember(id);
		System.out.println("회원삭제 처리 결과 건수: " + result);
		
		ModelAndView mav = new ModelAndView("redirect:/member/listMembers.do"); //회원 삭제 후 회원 전체 목록페이지로 이동한다.
		
		return mav;
	}
	
	
	// 회원가입 폼(Ajax)
	//-----------------------------------------------------------------------------------------------------------	
	@Override
	@RequestMapping(value="registerAjaxForm.do", method=RequestMethod.GET)
	public String getRegisterAjaxForm() throws Exception {
		logger.info("MemberControllerImpl 회원가입 폼(Ajax) 처리() 시작...");
		
		return "/member/registerAjax";
	}

	// 아이디 중복 확인(Ajax)
	//-----------------------------------------------------------------------------------------------------------		
	@Override
	@ResponseBody
	@RequestMapping(value="/idCheck.do", method=RequestMethod.POST)
	public int idCheck(@ModelAttribute("member") MemberDTO memberDTO) throws Exception {
		logger.info("MemberControllerImpl 아이디 중복 확인(Ajax) 처리() 시작...");
		
		return memberService.idCheck(memberDTO.getId());
	}
	
	

	
} // End - public class MemberControllerImpl






