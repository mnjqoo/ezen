package com.edu.movie.dao;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.edu.movie.dto.SeatDTO;

@Repository("movieDAO")
public class MovieDAOImpl implements MovieDAO {
	
	Logger logger = LoggerFactory.getLogger(MovieDAOImpl.class);
	
	@Inject
	private SqlSession sqlSession;
	
	private static String Namespace = "com.edu.movie.mappers.movieMapper";

	@Override
	public List<SeatDTO> getSeatList(int movieID) throws Exception {
		logger.info("MovieDAOImpl의 getSeatList 불러오기....");
		
		return sqlSession.selectList(Namespace + ".seatList", movieID);
	}

}
