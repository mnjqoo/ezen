package com.edu.member.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.edu.member.dto.MemberDTO;
import com.edu.member.service.MemberServiceImpl;

@Repository("memberDAO")
public class MemberDAOImpl implements MemberDAO {

	@Autowired
	private SqlSession sqlSession;
	
	private static final Logger logger 
	= LoggerFactory.getLogger(MemberDAOImpl.class);
	
	private static final String Namespace = "com.edu.member";
	
	
	@Override
	public MemberDTO loginById(MemberDTO memberDTO) throws DataAccessException { //로그인 처리
		
		logger.info("memberDAO loginById() 시작...");
		MemberDTO memDTO = sqlSession.selectOne(Namespace + ".loginById", memberDTO);
		return memDTO;
	}
	
	@Override
	public int addMember(MemberDTO memberDTO) throws DataAccessException { //회원가입 처리
		
		logger.info("memberDAO addMember() 시작...");
		int result = sqlSession.insert(Namespace + ".addMember", memberDTO);
		
		System.out.println("memberDAO addMember() 결과..." + result);
		return result;
	}

	@Override
	public List<MemberDTO> selectAllMemberList() throws DataAccessException { //회원 목록 처리
		logger.info("memberDAO selectAllMemberList() 시작...");
		List<MemberDTO> memberLists = sqlSession.selectList(Namespace + ".selectAllMemberList");
		
		return memberLists;
	}

	@Override
	public MemberDTO selectMember(String id) throws DataAccessException { //회원 수정 정보 조회 처리
		
		logger.info("memberDAO selectMember() 시작...");
		MemberDTO memberDTO = sqlSession.selectOne(Namespace + ".selectMember", id);
		return memberDTO;
	}

	@Override
	public int updateMember(MemberDTO memberDTO) throws DataAccessException { //회원 수정 처리

		logger.info("updateMember modifyMember() 시작...");
		
		int result = sqlSession.update(Namespace + ".updateMember", memberDTO);
		System.out.println("memberDAO updateMember() 결과건수..." + result);
		
		return result;
	}

	@Override
	public int deleteMember(String id) throws DataAccessException { //회원 삭제 처리
		
		logger.info("memberDAO deleteMember() 시작...");
		
		int result = sqlSession.delete(Namespace + ".deleteMember", id);
		System.out.println("memberDAO deleteMember() 결과건수..." + result);
		
		return result;
	}

	@Override
	public int idCheck(String id) throws DataAccessException { //아이디 중복 확인 처리
		
		logger.info("memberDAO idCheck() 시작...");
		
		int result = sqlSession.selectOne(Namespace + ".idCheck", id);
		return result;
	}
	
	

	
}
