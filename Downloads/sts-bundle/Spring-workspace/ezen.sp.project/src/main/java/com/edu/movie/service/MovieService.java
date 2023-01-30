package com.edu.movie.service;

import java.util.List;

import com.edu.movie.dto.SeatDTO;

public interface MovieService {

	public List<SeatDTO> getSeatList(int movieID) throws Exception;
	
	public int insertSeatID(int seatID) throws Exception;
	
	public int seatReservationCount() throws Exception;
}
