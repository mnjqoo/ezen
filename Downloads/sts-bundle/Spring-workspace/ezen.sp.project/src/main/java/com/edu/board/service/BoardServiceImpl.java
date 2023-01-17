package com.edu.board.service;

import java.util.HashMap;
import java.util.List;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.edu.board.dao.BoardDAOImpl;
import com.edu.board.dto.BoardDTO;
import com.edu.common.util.Criteria;
import com.edu.common.util.SearchCriteria;

@Service("boardService")
public class BoardServiceImpl implements BoardService {

	private static final Logger logger = LoggerFactory.getLogger(BoardServiceImpl.class);
	
	@Inject
	private BoardDAOImpl boardDAO;
	
	@Override
	public int boardRegister(BoardDTO boardDTO) throws Exception { //게시글 등록 처리
		logger.info("BoardServiceImpl의 boardRegister() 처리 시작..." );
		
//		if(boardDAO.getMaxBno() == null) { //이미 작성된 게시글이 없을 때 게시글 번호를 1로 한다.
//			boardDTO.setBno(1);
//		} else {
//			boardDTO.setBno(boardDAO.getMaxBno() + 1)); //있을 때 게시글 번호를 1을 더한 값으로 한다.
//		}
		
		
		return boardDAO.boardRegister(boardDTO);
	}

	@Override
	public List<BoardDTO> boardList() throws Exception { //게시글 목록 불러오기
		logger.info("BoardServiceImpl의 boardList() 처리 시작..." );
		
		return boardDAO.boardList();
	}

	@Override
	public BoardDTO boardDetail(int bno) throws Exception { //게시글 상세페이지 불러오기
		logger.info("BoardServiceImpl의 boardDetail() 처리 시작..." );
		
		//게시글 자료를 가져오기 전에 조회수를 1 증가한다.
		//boardDAO.updateReadCount(bno);
		
		return boardDAO.boardDetail(bno);
	}

	@Override
	public int boardDelete(int bno) throws Exception { //게시글 삭제 처리
		logger.info("BoardServiceImpl의 boardDelete() 처리 시작..." );
		
		return boardDAO.boardDelete(bno);
	}

	@Override
	public int boardUpdate(BoardDTO boardDTO) throws Exception { //게시글 수정 처리
		logger.info("BoardServiceImpl의 boardUpdate() 처리 시작..." );
		
		return boardDAO.boardUpdate(boardDTO);
	}

	@Override
	public int boardListTotalCount1() throws Exception { //총 게시글 수 구하기 1 
		logger.info("BoardServiceImpl의 boardListTotalCount1() 처리 시작..." );
		
		return boardDAO.boardListTotalCount1();
	}

	@Override
	public List<BoardDTO> boardListPaging1(HashMap<String, Integer> pageList) throws Exception { //요청된 페이지수에 해당하는 게시글 목록을 보여주기
		logger.info("BoardServiceImpl의 boardListPaging1() 불러오기..." );
		System.out.println("pageNum: " + pageList.get("pageNum"));
		System.out.println("pageSize: " + pageList.get("pageSize"));
		return boardDAO.boardListPaging1(pageList);
	}
	
	@Override
	public int boardListTotalCount2(Criteria cri) throws Exception { //총 게시글 수 구하기 2
		logger.info("BoardServiceImpl의 boardListTotalCount2() 처리 시작..." );
		
		return boardDAO.boardListTotalCount2(cri);
	}
	
	@Override
	public List<BoardDTO> boardListPaging2(Criteria cri) throws Exception { //요청된 페이지에 해당하는 게시글 목록 가져오기2
		logger.info("BoardServiceImpl의 boardListPaging2() 처리 시작..." );
		
		return boardDAO.boardListPaging2(cri);
	}

	@Override
	public int boardListTotalCount3(SearchCriteria sCri) throws Exception { //총 게시글 수 구하기3
		logger.info("BoardServiceImpl의 boardListPaging3() 처리 시작..." );
		
		return boardDAO.boardListTotalCount3(sCri);
	}
	
	@Override
	public List<BoardDTO> boardListPaging3(SearchCriteria sCri) throws Exception { //조건에 해당하는 게시글 목록 가져오기3
		logger.info("BoardServiceImpl의 boardListPaging3() 처리 시작..." );
		
		return boardDAO.boardListPaging3(sCri);
	}
}
