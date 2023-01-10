package com.edu.board.service;

import java.util.List;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.edu.board.dao.BoardDAOImpl;
import com.edu.board.dto.BoardDTO;

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

	
}
