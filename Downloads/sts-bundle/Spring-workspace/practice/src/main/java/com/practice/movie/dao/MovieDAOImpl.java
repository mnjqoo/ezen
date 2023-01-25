package com.practice.movie.dao;

import java.util.HashMap;
import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.practice.common.util.SearchCriteria;
import com.practice.movie.dto.MovieDTO;

@Repository("movieDAO")
public class MovieDAOImpl implements MovieDAO {

	Logger logger = LoggerFactory.getLogger(MovieDAOImpl.class);
	
	//쿼리를 사용하기 위해 SplSession과 Namespace를 준비한다.
	@Inject
	private SqlSession sqlSession;
	
	private String Namespace = "com.practice.movie";
	
	@Override
	public List<MovieDTO> movieList(SearchCriteria sCri) throws Exception { //게시글 목록 불러오기
		logger.info("MovieDAOImpl의 movieList 불러오기....");
		
		return sqlSession.selectList(Namespace + ".movieList", sCri);
	}
	
	@Override
	public List<HashMap<String, String>> genreCode() throws Exception { //장르코드 구하기
		logger.info("MovieDAOImpl의 genreCode 불러오기....");
		
		return sqlSession.selectList(Namespace + ".genreCode");
	}
	
	@Override
	public int movieListTotalCount(SearchCriteria sCri) throws Exception { //총 게시글 수 구하기
		logger.info("MovieDAOImpl의 movieListTotalCount 시작....");
		
		
		return sqlSession.selectOne(Namespace + ".totalCount", sCri);
	}
	
	@Override
	public int movieRegister(MovieDTO movieDTO) throws Exception { //게시글 데이터베이스에 등록하기
		logger.info("MovieDAOImpl의 movieRegister 시작....");
		
		return sqlSession.insert(Namespace + ".movieRegister", movieDTO);
	}

	@Override
	public MovieDTO movieDetail(int bno) throws Exception { //bno에 해당하는 MovieDTO객체 구하기
		logger.info("MovieDAOImpl의 movieDetail 불러오기....");
		
		return sqlSession.selectOne(Namespace + ".movieDetail", bno);
	}

	@Override
	public int movieUpdate(MovieDTO movieDTO) throws Exception {
		logger.info("MovieDAOImpl의 movieUpdate 불러오기....");
		
		return sqlSession.update(Namespace + ".movieUpdate", movieDTO);
	}

}
