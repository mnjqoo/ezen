package com.practice.movies.dao;

import java.util.List;

import com.practice.common.util.SearchCriteria;
import com.practice.movies.dto.MovieDTO;

public interface MovieDAO {

	public int movieListTotalCount(SearchCriteria sCri) throws Exception; //전체 게시물 갯수 구하기
	
	public List<MovieDTO> movieList(SearchCriteria sCri) throws Exception; //게시글 목록 불러오기
}
