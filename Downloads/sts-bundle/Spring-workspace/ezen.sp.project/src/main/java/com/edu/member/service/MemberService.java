package com.edu.member.service;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.edu.member.dto.MemberDTO;

public interface MemberService {

	public MemberDTO login(MemberDTO memberDTO) throws DataAccessException; //로그인 처리
	
	public int addMember(MemberDTO memberDTO) throws DataAccessException; //회원가입 처리
	
	public List<MemberDTO> listMembers() throws DataAccessException; //회원목록 처리
	
	public MemberDTO selectMember(String id) throws DataAccessException; //회원수정 정보 조회 처리
	
	public int modifyMember(MemberDTO memberDTO) throws DataAccessException; //회원수정 처리
	
	public int removeMember(String id) throws DataAccessException; //회원삭제 처리
	
	public int idCheck(String id) throws DataAccessException; //아이디 중복 확인 처리
}
