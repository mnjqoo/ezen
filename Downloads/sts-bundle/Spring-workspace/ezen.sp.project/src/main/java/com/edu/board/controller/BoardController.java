package com.edu.board.controller;

import java.util.List;
import java.util.Locale;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.edu.board.dao.BoardDAO;
import com.edu.board.dao.BoardDAOImpl;
import com.edu.board.dto.BoardDTO;
import com.edu.board.service.BoardServiceImpl;

@Controller //Bean의 대상으로 인식시키기 위해서 servlet-context.xml에 등록된다.
@RequestMapping(value="/board/*")
public class BoardController {

	private static final Logger logger = LoggerFactory.getLogger(BoardController.class);
	
	@Inject
	private BoardServiceImpl boardService;
	
	@RequestMapping(value="/boardRegisterForm", method=RequestMethod.GET)
	public String boardRegisterForm() { //게시글 작성 폼
		logger.info("BoardController의 게시글 작성 폼 불러오기...");
		
		return "/board/boardRegisterForm";
	}
	
	@ResponseBody //request 객체를 통해 가져온 데이터가 자동으로 setㅇㅇ 로 전달된다.
	@RequestMapping(value="/boardRegister", method=RequestMethod.POST)
	public String boardRegister(BoardDTO boardDTO) throws Exception { //게시글 등록 처리
		logger.info("BoardController의 게시글 등록 처리 시작...");
		logger.info("BoardDTO 값:" + boardDTO);
		
		if(boardService.boardRegister(boardDTO) == 1) { //게시글 등록 성공
			return "Y";
		} else { //게시글 등록 실패
			return "N";
		}
	}
	
	@RequestMapping(value="/boardList", method=RequestMethod.GET)
	public void boardList(Locale locale, Model model) throws Exception { //게시글 목록 불러와서 게시글 목록 창으로 넘기기
		logger.info("BoardController의 boardList 불러오기...");
		
		List<BoardDTO> boardList = boardService.boardList();
		logger.info("게시글 목록: " + boardList);
		
		model.addAttribute("boardList", boardList);
	}
	
	@RequestMapping(value="/boardDetail", method=RequestMethod.GET)
	public String boardDetail(Model model, HttpServletRequest request) throws Exception { //게시글 상세페이지 불러오기
		logger.info("BoardController의 boardDetail 불러오기... bno=" + request.getParameter("bno"));
		
		BoardDAO boardDAO = new BoardDAOImpl();
		boardDAO.updateReadCount(Integer.parseInt((String) request.getParameter("bno")));
		
		BoardDTO boardDTO = boardService.boardDetail(Integer.parseInt((String) request.getParameter("bno")));
		model.addAttribute("boardDetail", boardDTO);
		
		return "/board/boardDetail";
		
	}
	
	@ResponseBody
	@RequestMapping(value="/boardDelete", method=RequestMethod.POST)
	public String boardDelete(Model model, HttpServletRequest request) throws Exception { //게시글 삭제 처리
		logger.info("BoardController의 boardDelete 처리 시작...");
		
		if(boardService.boardDelete(Integer.parseInt((String)request.getParameter("bno"))) == 1) {
			return "Y";
		} else {
			return "N";
		}
	}
	
	@RequestMapping(value="/boardUpdateForm", method=RequestMethod.POST)
	public String boardUpdateForm(Model model, HttpServletRequest request) throws Exception { //게시글 수정 폼 불러오기
		logger.info("BoardController의 boardUpdateForm 불러오기...");
		
		BoardDTO boardDTO = boardService.boardDetail(Integer.parseInt((String) request.getParameter("bno")));
		model.addAttribute("boardDetail", boardDTO);
		
		return "/board/boardUpdate";
	}
	
	@ResponseBody
	@RequestMapping(value="/boardUpdate", method=RequestMethod.POST)
	public String boardUpdate(BoardDTO boardDTO) throws Exception { //게시글 수정하기
		logger.info("BoardController의 boardUpdate 처리 시작...");
		
		if(boardService.boardUpdate(boardDTO) == 1) { //게시글 수정 성공
			return "Y";
		} else { //게시글 수정 실패
			return "N";
		}
	}
}
