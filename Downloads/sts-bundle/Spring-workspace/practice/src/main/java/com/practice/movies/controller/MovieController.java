package com.practice.movies.controller;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.practice.common.util.PageMaker;
import com.practice.common.util.SearchCriteria;
import com.practice.movies.service.MovieService;

@Controller
@RequestMapping(value="/movie/*")
public class MovieController {

	private static final Logger logger = LoggerFactory.getLogger(MovieController.class);
	
	@Inject
	private MovieService movieService;
	
	@RequestMapping(value="/movieList")
	public ModelAndView movieList(SearchCriteria sCri) throws Exception { //게시글 목록과 페이지 번호를 가져와서 넘겨준다.
		logger.info("MovieController의 movieList 불러오기 시작...");
		
		ModelAndView mav = new ModelAndView("/movie/movieList");
		
		//service를 통해 게시글 리스트를 가져온다.
		List<>
		
		//들어온 현재 페이지 값을 넣어준다.
		PageMaker pageMaker = new PageMaker();
		pageMaker.setCri(sCri);
		
		//service를 통해 전체 데이터 건수를 찾는다.
		int totalCount = movieService.movieListTotalCount(sCri);
		System.out.println("총 데이터 건수: " + totalCount);
		
		//전체 데이터 건수를 pageMaker에 넣어 다른 변수를 설정해준다.
		pageMaker.setTotalCount(totalCount);
		
		mav.addObject("pageMaker", pageMaker);
		return mav;		
	}
}
