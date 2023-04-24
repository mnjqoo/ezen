package com.edu.member.dao;

import com.edu.member.dto.MemberDTO;

public interface MemberDAO {

	//이메일 중복 검사하기
	public int emailCheck(MemberDTO memberDTO) throws Exception;

	//회원가입 처리하기
	public int register(MemberDTO memberDTO) throws Exception;
	
	//회원 정보 업데이트 하기
	public int update(MemberDTO memberDTO) throws Exception;
	
	//이메일로 memberDTO 객체 가져오기
	public MemberDTO getMemberDTOByEmail(String email) throws Exception;
}
