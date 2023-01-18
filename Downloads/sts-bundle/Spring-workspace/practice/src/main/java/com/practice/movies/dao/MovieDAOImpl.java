package com.practice.movies.dao;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.practice.common.util.SearchCriteria;
import com.practice.movies.dto.MovieDTO;

@Repository("movieDAO")
public class MovieDAOImpl implements MovieDAO {

	Logger logger = LoggerFactory.getLogger(MovieDAOImpl.class);
	
	//쿼리를 사용하기 위해 SplSession과 Namespace를 준비한다.
	@Inject
	private SqlSession sqlSession;
	
	private String Namespace = "com.practice.movie";
	
	@Override
	public int movieListTotalCount(SearchCriteria sCri) throws Exception { //총 게시글 수 구하기
		logger.info("MovieDAOImpl의 movieListTotalCount 시작....");
		
		
		return sqlSession.selectOne(Namespace + ".totalCount", sCri);
	}

	@Override
	public List<MovieDTO> movieList(SearchCriteria sCri) throws Exception {
		logger.info("MovieDAOImpl의 movieList 불러오기....");
		
		return sqlSession.selectList(Namespace + ".movieList", sCri);
	}

}
