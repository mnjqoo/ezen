package com.edu.member.service;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.edu.member.dao.MemberDAO;
import com.edu.member.dto.MemberDTO;
@Service("memberService")
public class MemberServiceImpl implements MemberService {
	
	@Inject
	MemberDAO memberDAO;

	//이메일 중복 검사하기
	@Override
	public int emailCheck(MemberDTO memberDTO) throws Exception {
		System.out.println("MemberServiceImpl 이메일 중복 검사  처리 시작..." + memberDTO);
		
		//user_type이 한글로 들어왔으므로 다시 세팅해준다.
		if(memberDTO.getUser_type() == "운송기사") {
			memberDTO.setUser_type("D");
		} else {
			memberDTO.setUser_type("C");
		}
		
		return memberDAO.emailCheck(memberDTO);
	}

	@Override
	public int register(MemberDTO memberDTO) throws Exception {
		System.out.println("MemberServiceImpl register()  처리 시작...회원 정보: " + memberDTO);
		
		return memberDAO.register(memberDTO);
	}

	@Override
	public int update(MemberDTO memberDTO) throws Exception {
		System.out.println("MemberServiceImpl update()  처리 시작...회원 정보: " + memberDTO);
		
		return memberDAO.update(memberDTO);
	}

	@Override
	public MemberDTO getMemberDTOByEmail(String email) throws Exception {
		System.out.println("MemberServiceImpl update()  처리 시작...");
		
		return memberDAO.getMemberDTOByEmail(email);
	}



}
