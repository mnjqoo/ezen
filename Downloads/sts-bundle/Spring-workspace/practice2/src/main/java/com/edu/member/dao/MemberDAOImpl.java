package com.edu.member.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.edu.member.dto.MemberDTO;

@Repository("memberDAO")
public class MemberDAOImpl implements MemberDAO {

	@Autowired
	private SqlSession sqlSession;
	private	static final String Namespace = "com.edu.member";
	
	@Override
	public int emailCheck(MemberDTO memberDTO) throws Exception {
		System.out.println("MemberController 이메일 중복 검사  처리 시작..." + memberDTO);
		
		return sqlSession.selectOne(Namespace + ".emailCheck" , memberDTO);
	}

	@Override
	public int register(MemberDTO memberDTO) throws Exception {
		System.out.println("MemberController register()  처리 시작...회원 정보: " + memberDTO);
		
		return sqlSession.insert(Namespace + ".register" , memberDTO);
	}

	@Override
	public int update(MemberDTO memberDTO) throws Exception {
		System.out.println("MemberController update()  처리 시작...회원 정보: " + memberDTO);
		
		//이미지 값이 있으면 이미지 업데이트, 아니면 나머지 회원 정보를 업데이트 한다.
		if(memberDTO.getImage() != null) {
			return sqlSession.update(Namespace + ".updateImage" , memberDTO);
		} else {
			return sqlSession.update(Namespace + ".update" , memberDTO);
		}
		
	}

	@Override
	public MemberDTO getMemberDTOByEmail(String email) throws Exception {
		System.out.println("MemberController getMemberDTOByEmail()  처리 시작...");
		
		//먼저 t_client 테이블에서 객체를 찾는다.
		MemberDTO memberDTO = sqlSession.selectOne(Namespace + ".getClientMemberDTOByEmail", email);
		if(memberDTO == null) {
			//t_client에 객체가 없으면 t_driver에서 찾아서 리턴해준다.
			return sqlSession.selectOne(Namespace + ".getDriverMemberDTOByEmail" , email);
		} else {
			//t_client에 객체가 있으면 그대로 리턴해준다.
			return memberDTO;
		}
	}

	

}
