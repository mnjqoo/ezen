package com.edu.board.dao;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.edu.board.dto.BoardDTO;

@Repository("boardDAO")
public class BoardDAOImpl implements BoardDAO{

	private static final Logger logger = LoggerFactory.getLogger(BoardDAOImpl.class);
	
	@Inject
	private SqlSession sqlSession;
	
	private static String Namespace = "com.edu.board"; //xml의 Namespace와 동일해야한다.(대소문자 주의)
	
	@Override
	public Integer getMaxBno() { //가장 큰 게시글 번호 가져오기
		logger.info("BoardDAOImpl의 getMaxBno() 시작...");
		
		return sqlSession.selectOne(Namespace + ".maxBno");
	}
	
	public int boardRegister(BoardDTO boardDTO) { //게시글 등록 처리
		logger.info("BoardDAOImpl의 boardRegister() 시작...");
		
		return sqlSession.insert(Namespace + ".insertBoard", boardDTO);
	}

	@Override
	public List<BoardDTO> boardList() throws Exception { //게시글 목록 불러오기
		logger.info("BoardDAOImpl의 boardList() 시작...");
		
		List<BoardDTO> boardList = sqlSession.selectList(Namespace + ".listAll");
		return boardList;
	}

	
	@Override
	public void updateReadCount(int bno) throws Exception { //조회수 증가시키는 메소드
		logger.info("BoardDAOImpl의 updateReadCount() 시작...");
		System.out.println("bno: " + bno);
		sqlSession.update(Namespace + ".updateReadCount", bno);
		System.out.println("bno: " + bno);
	}

	@Override
	public BoardDTO boardDetail(int bno) throws Exception { //게시글 상세페이지 불러오기
		logger.info("BoardDAOImpl의 boardDetail() 시작...");
		
		BoardDTO boardDTO = sqlSession.selectOne(Namespace + ".detail", bno);
		System.out.println("updateReadCount 결과: " + boardDTO.getReadCount());
		return boardDTO;
	}

	@Override
	public int boardDelete(int bno) throws Exception { //게시글 삭제 처리
		logger.info("BoardDAOImpl의 boardDelete() 시작...");
		
		return sqlSession.delete(Namespace + ".delete", bno);
	}

	@Override
	public int boardUpdate(BoardDTO boardDTO) throws Exception { //게시글 수정 처리
		logger.info("BoardDAOImpl의 boardUpdate() 시작...");
		
		return sqlSession.update(Namespace + ".update", boardDTO);
	}

	
}
