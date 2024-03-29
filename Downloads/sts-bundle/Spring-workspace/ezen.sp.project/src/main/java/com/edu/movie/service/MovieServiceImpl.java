package com.edu.movie.service;

import java.util.List;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.edu.movie.dao.MovieDAO;
import com.edu.movie.dto.SeatDTO;

@Service("movieService")
public class MovieServiceImpl implements MovieService {

	Logger logger = LoggerFactory.getLogger(MovieServiceImpl.class);

	@Inject
	MovieDAO movieDAO;
	
	@Override
	public List<SeatDTO> getSeatList(int movieID) throws Exception {
		logger.info("MovieServiceImpl의 getSeatList 불러오기...");
		
		return movieDAO.getSeatList(movieID);
	}

	@Override
	public int insertSeatID(int seatID) throws Exception {
		logger.info("MovieServiceImpl의 insertSeatID 처리하기...");

		return movieDAO.insertSeatID(seatID);
	}

	@Override
	public int seatReservationCount() throws Exception {
		logger.info("MovieServiceImpl의 seatReservationCount 불러오기...");

		return movieDAO.seatReservationCount();
	}
	
	
}
