package com.practice.movies.dto;

import java.sql.Date;

import org.springframework.stereotype.Component;

@Component("movieDTO")
public class MovieDTO {

	private String title; //제목
	private String genre; //장르코드
	private Date release_date; //개봉일
	private int rating; //평점
	private String director; //감독
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getGenre() {
		return genre;
	}
	public void setGenre(String genre) {
		this.genre = genre;
	}
	public Date getRelease_date() {
		return release_date;
	}
	public void setRelease_date(Date release_date) {
		this.release_date = release_date;
	}
	public int getRating() {
		return rating;
	}
	public void setRating(int rating) {
		this.rating = rating;
	}
	public String getDirector() {
		return director;
	}
	public void setDirector(String director) {
		this.director = director;
	}
	@Override
	public String toString() {
		return "MovieDTO [title=" + title + ", genre=" + genre + ", release_date=" + release_date + ", rating=" + rating
				+ ", director=" + director + "]";
	}
	
	
	
}
