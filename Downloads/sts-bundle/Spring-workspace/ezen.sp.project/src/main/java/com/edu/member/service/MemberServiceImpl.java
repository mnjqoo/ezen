package com.edu.member.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import com.edu.member.dao.MemberDAO;
import com.edu.member.dto.MemberDTO;

@Service("memberService")
public class MemberServiceImpl implements MemberService {
	
	private static final Logger logger 
	= LoggerFactory.getLogger(MemberServiceImpl.class);
	
	@Autowired
	private MemberDAO memberDAO;

	@Override
	public MemberDTO login(MemberDTO memberDTO) throws DataAccessException { //로그인 처리
		
		logger.info("MemberServiceImpl login() 시작...");
		return memberDAO.loginById(memberDTO);
	}

	@Override
	public int addMember(MemberDTO memberDTO) throws DataAccessException { //회원가입 처리
		
		logger.info("MemberServiceImpl addMember() 시작...");
		System.out.println("회원가입 정보 => " + memberDTO);
		return memberDAO.addMember(memberDTO);
	}

	@Override
	public List<MemberDTO> listMembers() throws DataAccessException { //회원 목록 처리
		logger.info("MemberServiceImpl listMembers() 시작...");
		
		return memberDAO.selectAllMemberList();
	}

	@Override
	public MemberDTO selectMember(String id) throws DataAccessException { //회원 수정 정보 조회 처리
		logger.info("MemberServiceImpl selectMember() 시작...");
		
		return memberDAO.selectMember(id);
	}

	@Override
	public int modifyMember(MemberDTO memberDTO) throws DataAccessException { //회원 수정 처리
		logger.info("MemberServiceImpl modifyMember() 시작...");
		
		return memberDAO.updateMember(memberDTO);
	}

	@Override
	public int removeMember(String id) throws DataAccessException { //회원 삭제 처리
		logger.info("MemberServiceImpl removeMember() 시작...");
		
		return memberDAO.deleteMember(id);
	}

	@Override
	public int idCheck(String id) throws DataAccessException { //아이디 중복 확인 처리
		logger.info("MemberServiceImpl idCheck() 시작...");
		
		return memberDAO.idCheck(id);
	}
	
	
	
	

	
}
