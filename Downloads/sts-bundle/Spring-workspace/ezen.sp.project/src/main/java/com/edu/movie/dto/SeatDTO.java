package com.edu.movie.dto;

public class SeatDTO {

	int movieID; //영화 종류
	String userID; //사용자 아이디
	int seatID; //좌석 정보
	
	public SeatDTO(int movieID, String userID, int seatID) {
		this.movieID = movieID;
		this.userID = userID;
		this.seatID = seatID;
	}
	
	public int getMovieID() {
		return movieID;
	}
	public void setMovieID(int movieID) {
		this.movieID = movieID;
	}
	public String getUserID() {
		return userID;
	}
	public void setUserID(String userID) {
		this.userID = userID;
	}
	public int getSeatID() {
		return seatID;
	}
	public void setSeatID(int seatID) {
		this.seatID = seatID;
	}
	@Override
	public String toString() {
		return "SeatDTO [movieID=" + movieID + ", userID=" + userID + ", seatID=" + seatID + "]";
	}

}
