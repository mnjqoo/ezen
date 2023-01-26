package com.practice.movie.service;

import java.util.HashMap;
import java.util.List;

import com.practice.common.util.SearchCriteria;
import com.practice.movie.dto.MovieDTO;

public interface MovieService {

	public List<MovieDTO> movieList(SearchCriteria sCri) throws Exception; //게시글 목록 불러오기
	
	public List<HashMap<String, String>> genreCode() throws Exception; //장르코드 불러오기
	
	public int movieListTotalCount(SearchCriteria sCri) throws Exception; //전체 게시물 갯수 구하기
	
	public int movieRegister(MovieDTO movideDTO) throws Exception; //게시글 데이터베이스에 등록하기
	
	public MovieDTO movieDetail(int bno) throws Exception; //bno에 해당하는 MovieDTO객체 구하기
	
	public int movieUpdate(MovieDTO movieDTO) throws Exception; //게시글 수정하기
	
	public int movieDelete(int bno) throws Exception; //게시글 삭제하기
}
