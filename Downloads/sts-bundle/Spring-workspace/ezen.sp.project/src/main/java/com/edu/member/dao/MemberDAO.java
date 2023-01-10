package com.edu.member.dao;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.edu.member.dto.MemberDTO;

public interface MemberDAO {

	public MemberDTO loginById(MemberDTO memberDTO) throws DataAccessException;//로그인처리
	
	public int addMember(MemberDTO memberDTO) throws DataAccessException;//회원가입 처리
	
	public List<MemberDTO> selectAllMemberList() throws DataAccessException;//회원목록 처리
	
	public MemberDTO selectMember(String id) throws DataAccessException;//회원 수정 정보 조회 처리
	
	public int updateMember(MemberDTO memberDTO) throws DataAccessException;//회원수정 처리
	
	public int deleteMember(String id) throws DataAccessException;//회원삭제 처리
	
	public int idCheck(String id) throws DataAccessException;//아이디 중복 확인 처리
}
