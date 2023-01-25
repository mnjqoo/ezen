package com.practice.movie.service;

import java.util.HashMap;
import java.util.List;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.practice.common.util.SearchCriteria;
import com.practice.movie.dao.MovieDAO;
import com.practice.movie.dto.MovieDTO;

@Service("movieService")
public class MovieServiceImpl implements MovieService {
	
	private Logger logger = LoggerFactory.getLogger(MovieServiceImpl.class);
	
	@Inject
	MovieDAO movieDAO;
	
	@Override
	public List<MovieDTO> movieList(SearchCriteria sCri) throws Exception { //게시글 목록 불러오기
		logger.info("MovieServiceImpl의 movieList 불러오기....");
		
		return movieDAO.movieList(sCri);
	}
	
	@Override
	public List<HashMap<String, String>> genreCode() throws Exception { //장르 코드 불러오기
		logger.info("MovieServiceImpl의 genreCode 불러오기....");
		
		return movieDAO.genreCode();
	}

	@Override
	public int movieListTotalCount(SearchCriteria sCri) throws Exception { //게시물 총 갯수 구하기
		logger.info("MovieServiceImpl의 movieListTotalCount 시작....");
		
		return movieDAO.movieListTotalCount(sCri);
	}
	
	@Override
	public int movieRegister(MovieDTO movieDTO) throws Exception { //게시글 데이터베이스에 등록하기
		logger.info("MovieServiceImpl의 movieRegister 시작....");
		
		return movieDAO.movieRegister(movieDTO);
	}

	@Override
	public MovieDTO movieDetail(int bno) throws Exception { //bno에 해당하는 MovieDTO객체 구하기
		logger.info("MovieServiceImpl의 movieDetail 시작....");
		
		return movieDAO.movieDetail(bno);
	}

	@Override
	public int movieUpdate(MovieDTO movieDTO) throws Exception { //게시글 수정하기
		logger.info("MovieServiceImpl의 movieUpdate 시작....");
		
		return movieDAO.movieUpdate(movieDTO);
	}

	
}
