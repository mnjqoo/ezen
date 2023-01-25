package com.practice.movie.dto;

import org.springframework.stereotype.Component;

@Component("movieDTO")
public class MovieDTO {

	private int bno; //번호
	private String title; //제목
	private String genre; //장르코드
	private String releaseDate; //개봉일
	private String raiting; //평점
	private String director; //감독
	
	public int getBno() {
		return bno;
	}
	public void setBno(int bno) {
		this.bno = bno;
	}
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
	public String getReleaseDate() {
		return releaseDate;
	}
	public void setReleaseDate(String releaseDate) {
		this.releaseDate = releaseDate;
	}
	public String getRaiting() {
		return raiting;
	}
	public void setRaiting(String raiting) {
		this.raiting = raiting;
	}
	public String getDirector() {
		return director;
	}
	public void setDirector(String director) {
		this.director = director;
	}
	@Override
	public String toString() {
		return "MovieDTO [bno=" + bno + ", title=" + title + ", genre=" + genre + ", releasDate=" + releaseDate
				+ ", raiting=" + raiting + ", director=" + director + "]";
	}
	
	
	
	
	
}
