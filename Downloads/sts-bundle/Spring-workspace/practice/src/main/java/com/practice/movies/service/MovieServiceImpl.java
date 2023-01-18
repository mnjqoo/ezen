package com.practice.movies.service;

import java.util.List;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.practice.common.util.SearchCriteria;
import com.practice.movies.dao.MovieDAO;
import com.practice.movies.dto.MovieDTO;

@Service("movieService")
public class MovieServiceImpl implements MovieService {
	
	private Logger logger = LoggerFactory.getLogger(MovieServiceImpl.class);
	
	@Inject
	MovieDAO movieDAO;
	
	@Override
	public List<MovieDTO> movieList(SearchCriteria sCri) throws Exception {
		logger.info("MovieServiceImpl의 movieList 불러오기....");
		
		return movieDAO.movieList(sCri);
	}

	@Override
	public int movieListTotalCount(SearchCriteria sCri) throws Exception { //게시물 총 갯수 구하기
		logger.info("MovieServiceImpl의 movieListTotalCount 시작....");
		
		return movieDAO.movieListTotalCount(sCri);
	}

	
}
