package com.practice.movie.controller;

import java.util.HashMap;
import java.util.List;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.practice.common.util.PageMaker;
import com.practice.common.util.SearchCriteria;
import com.practice.movie.dto.MovieDTO;
import com.practice.movie.service.MovieService;

@Controller
@RequestMapping(value="/movie/*")
public class MovieController {

	private static final Logger logger = LoggerFactory.getLogger(MovieController.class);
	
	@Inject
	private MovieService movieService;
	
	//게시글 목록 페이지
	@RequestMapping(value="/movieList")
	public ModelAndView movieList(SearchCriteria sCri) throws Exception { //검색 결과에 대한 게시글 목록, 페이지 정보를 가져와서 넘겨준다.
		logger.info("MovieController의 movieList 불러오기 시작...");
		
		ModelAndView mav = new ModelAndView("/movie/movieList");
		
		//service를 통해 게시글 리스트를 가져온다.
		List<MovieDTO> movieList = movieService.movieList(sCri);
		System.out.println("데이터 리스트: " + movieList);
		
		//들어온 현재 페이지 값을 넣어준다.
		PageMaker pageMaker = new PageMaker();
		pageMaker.setCri(sCri);
		
		//service를 통해 전체 데이터 건수를 찾는다.
		int totalCount = movieService.movieListTotalCount(sCri);
		System.out.println("총 데이터 건수: " + totalCount);
		
		//전체 데이터 건수를 pageMaker에 넣어 다른 변수를 설정해준다.
		pageMaker.setTotalCount(totalCount);
		
		//게시글 리스트와 페이지 정보를 model에 넣어준다.
		mav.addObject("pageMaker", pageMaker);
		mav.addObject("movieList", movieList);
		System.out.println("mav: " + mav.getModel());
		return mav;		
	}
	
	//게시글 작성 양식 페이지(장르 코드를 같이 보내준다.)
	@RequestMapping(value="/movieRegisterForm")
	public ModelAndView movieRegisterForm() throws Exception {
		logger.info("MovieController의 movieRegisterForm 불러오기 시작...");
		
		ModelAndView mav = new ModelAndView("/movie/movieRegisterForm");
		
		//service를 통해 장르 코드를 구한다.
		List<HashMap<String, String>> genreList = movieService.genreCode();
		
		//model에 넣어준다.
		mav.addObject("genreList", genreList);
		
		return mav;
	}
	
	//작성한 게시글 데이터베이스에 등록하기
	@ResponseBody
	@RequestMapping(value="/movieRegister", method=RequestMethod.POST)
	public String movieRegister(MovieDTO movieDTO) throws Exception {
		logger.info("MovieController의 movieRegister 처리 시작...");
		
		System.out.println("movieDTO: " + movieDTO);
		
		if(movieService.movieRegister(movieDTO) == 1) {
			return "Y";
		} else {
			return "N";
		}
	}
	
	//클릭한 게시글 객체를 가지고 상세페이지로 보내준다.
	@RequestMapping(value="/movieDetail", method=RequestMethod.GET)
	public ModelAndView movieDetail(int bno) throws Exception {
		logger.info("MovieController의 movieDetail 불러오기 시작...");
		
		ModelAndView mav = new ModelAndView("/movie/movieDetail");
		//service를 통해 객체를 가져온다.
		MovieDTO movieDTO = movieService.movieDetail(bno);
		
		//model에 담기
		mav.addObject("movieDTO", movieDTO);
		
		return mav;
	}
	
	//수정할 게시글의 객채를 가지고 수정페이지로 보내준다. (장르코드도 함께)
	@RequestMapping(value="/movieUpdateForm")
	public ModelAndView movieUpdate(int bno) throws Exception {
		logger.info("MovieController의 movieUpdateForm 불러오기 시작...");
		
		ModelAndView mav = new ModelAndView("/movie/movieUpdate");
		//service를 통해 객체를 가져온다.
		MovieDTO movieDTO = movieService.movieDetail(bno);
		
		//model에 넣어준다.
		mav.addObject("movieDTO", movieDTO);
		
		//service를 통해 장르 코드를 구한다.
		List<HashMap<String, String>> genreList = movieService.genreCode();
				
		//model에 넣어준다.
		mav.addObject("genreList", genreList);
		
		return mav;
	}
	
	//수정한 정보로 게시글 수정하기
	@ResponseBody
	@RequestMapping(value="/movieUpdate", method=RequestMethod.POST)
	public String movieUpdate(MovieDTO movieDTO) throws Exception {
		logger.info("MovieController의 movieUpdate 처리 시작...");
		
		System.out.println("movieDTO: " + movieDTO);
		
		if(movieService.movieUpdate(movieDTO) == 1) {
			return "Y";
		} else {
			return "N";
		}
	}
	
	//해당bno로 게시글 삭제하기
	@ResponseBody
	@RequestMapping(value="/movieDelete", method=RequestMethod.POST)
	public String movieDelete(int bno) throws Exception {
		logger.info("MovieController의 movieDelete 처리 시작...");
		
		if(movieService.movieDelete(bno) == 1) {
			return "Y";
		} else {
			return "N";
		}
	}
}
