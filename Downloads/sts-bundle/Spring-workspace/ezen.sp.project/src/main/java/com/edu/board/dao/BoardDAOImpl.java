package com.edu.board.dao;

import java.util.HashMap;
import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.edu.board.dto.BoardDTO;
import com.edu.common.util.Criteria;

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

	@Override
	public int boardListTotalCount1() throws Exception { //총 게시글 수 구하기1
		logger.info("BoardDAOImpl의 boardListTotalCount1() 시작...");
		
		return sqlSession.selectOne(Namespace + ".totalCount");
	}

	@Override
	public List<BoardDTO> boardListPaging1(HashMap<String, Integer> pageList) throws Exception { //요청된 페이지에 해당하는 게시글 가져오기
		logger.info("BoardDAOImpl의 boardListPaging1() 시작...");
		logger.info("pageNum: " + pageList.get("pageNum"));
		
		//sql의 limit에는 사칙연산을 사용할 수 없기 때문에 미리 계산을 해서 넘겨준다.
		int pageNum = pageList.get("pageNum");
		int startRow = (pageNum - 1) * pageList.get("pageSize");
		pageList.put("startRow", startRow);
		
		return sqlSession.selectList(Namespace + ".boardListPaging1", pageList);
	}

	@Override
	public int boardListTotalCount2(Criteria cri) throws Exception { //총 게시글 수 구하기2
		logger.info("BoardDAOImpl의 boardListTotalCount2() 시작...");
		
		return sqlSession.selectOne(Namespace + ".totalCount2", cri);
	}

	@Override
	public List<BoardDTO> boardListPaging2(Criteria cri) throws Exception { //요청된 페이지에 해당하는 게시글 목록 가져오기2
		logger.info("BoardDAOImpl의 boardListPaging2() 시작...");
		
		return sqlSession.selectList(Namespace + ".boardListPaging2", cri);
	}
	
	
}
