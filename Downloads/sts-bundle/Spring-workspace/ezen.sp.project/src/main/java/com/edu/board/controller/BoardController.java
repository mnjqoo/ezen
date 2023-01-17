package com.edu.board.controller;

import java.util.HashMap; 
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.edu.board.dao.BoardDAOImpl;
import com.edu.board.dto.BoardDTO;
import com.edu.board.service.BoardServiceImpl;
import com.edu.common.util.Criteria;
import com.edu.common.util.PageMaker;
import com.edu.common.util.SearchCriteria;

@Controller //Bean의 대상으로 인식시키기 위해서 servlet-context.xml에 등록된다.
@RequestMapping(value="/board/*")
public class BoardController {

	private static final Logger logger = LoggerFactory.getLogger(BoardController.class);
	
	@Inject
	private BoardServiceImpl boardService;
	
	@Inject
	private BoardDAOImpl boardDAO;
	
	@RequestMapping(value="/boardRegisterForm", method=RequestMethod.GET)
	public String boardRegisterForm(Model model, HttpServletRequest request) { //게시글 작성 폼
		logger.info("BoardController의 게시글 작성 폼 불러오기...");
		
		System.out.println("flag: " + Integer.parseInt((String) request.getParameter("flag")));
		
		if(Integer.parseInt((String) request.getParameter("flag")) == 1) {
			model.addAttribute("flag", Integer.parseInt((String) request.getParameter("flag")));
		} else if(Integer.parseInt((String) request.getParameter("flag")) == 0) {
			model.addAttribute("flag", Integer.parseInt((String) request.getParameter("flag")));
		}
		System.out.println(model.getAttribute("flag"));
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
		
		if(request.getParameter("flag") == null) {
			boardDAO.updateReadCount(Integer.parseInt((String) request.getParameter("bno")));
		}
		
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
	
	@RequestMapping(value="/boardList1", method=RequestMethod.GET)
	public ModelAndView boardList1(Model model, @RequestParam(defaultValue="1") int pageNum, @RequestParam(defaultValue="10") int pageSize) throws Exception { //게시글 목록 불러와서 게시글 목록 창으로 넘기기
		logger.info("BoardController의 boardList1 불러오기...");
		
		//받은 페이지 상태가 두개이고 Mapper에서는 파라미터를 2개이상 받지 않기 때문에 hashmap 형태로 담는다.
		HashMap<String, Integer> pageList = new HashMap<String, Integer>();
		pageList.put("pageNum", pageNum);
		pageList.put("pageSize", pageSize);
		
		for(int key : pageList.values()) {
			System.out.println(key);
		}
		
		int totalCount = boardService.boardListTotalCount1(); //전체 게시글의 수를 구한다. 
		
		//요청된 페이지에 해당하는 게시글을 가져온다.
		List<BoardDTO> boardList = boardService.boardListPaging1(pageList);
		
		ModelAndView mav = new ModelAndView("/board/boardList1");
		
		mav.addObject("pageNum", pageNum); //현재 페이지 번호
		mav.addObject("boardList", boardList); //현재 페이지 번호에 해당하는 게시글 목록
		mav.addObject("totalCount", totalCount); //전체 게시글 수
		return mav;
	}
	
	@RequestMapping(value="/boardList2", method=RequestMethod.GET)
	public ModelAndView boardList2(Criteria cri) throws Exception { //게시글 목록 불러와서 게시글 목록 창으로 넘기기2
		logger.info("BoardController의 boardList2 불러오기...");
		
		ModelAndView mav = new ModelAndView("board/boardList2");
		
		PageMaker pageMaker = new PageMaker();
		pageMaker.setCri(cri);
		
		//게시글의 전체 갯수를 구해서 pageMaker의 totalCount에ㅔ 저장한다.
		pageMaker.setTotalCount(boardService.boardListTotalCount2(cri));
		
		List<BoardDTO> boardList = boardService.boardListPaging2(cri);
		
		mav.addObject("boardList", boardList);
		mav.addObject("pageMaker", pageMaker);
		
		return mav;
	}
	
	@RequestMapping(value="/boardList3", method=RequestMethod.GET)
	public ModelAndView boardList3(SearchCriteria sCri) throws Exception { //게시글 목록 보여주기 + 검색기능
		logger.info("BoardController의 boardList3 불러오기...");
		
		ModelAndView mav = new ModelAndView("/board/boardList3");
		mav.addObject("searchType", sCri.getSearchType());
		mav.addObject("keyword", sCri.getKeyword());
		
		PageMaker pageMaker = new PageMaker();
		pageMaker.setCri(sCri);
		
		pageMaker.setTotalCount(boardService.boardListTotalCount3(sCri)); //조건에 해당하는 데이터 건수로 전체 데이터 건수를 설정한다.
		System.out.println("찾은 데이터 건수: " + boardService.boardListTotalCount3(sCri));
		
		List<BoardDTO> boardList = boardService.boardListPaging3(sCri); //조건에 해당하는 데이터 목록을 가져온다.
		
		mav.addObject("boardList", boardList);
		mav.addObject("pageMaker", pageMaker);
		return mav;
	}
}
