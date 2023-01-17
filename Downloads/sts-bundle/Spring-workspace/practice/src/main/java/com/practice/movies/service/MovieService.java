package com.practice.movies.service;

import com.practice.common.util.SearchCriteria;

public interface MovieService {

	public int movieListTotalCount(SearchCriteria sCri) throws Exception; //전체 게시물 갯수 구하기
}
