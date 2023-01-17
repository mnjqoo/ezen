package com.practice.common.util;

public class SearchCriteria extends Criteria{ //검색한 값들에 해당하는 게시글 목록을 보여주기 위한 정보
	
	private String searchType; //검색 조건(title, genre, rating, director)
	private String keyword; //검색 키워드
	
	public String getSearchType() {
		return searchType;
	}
	public void setSearchType(String searchType) {
		this.searchType = searchType;
	}
	public String getKeyword() {
		return keyword;
	}
	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}
	@Override
	public String toString() {
		return "SearchCriteria [searchType=" + searchType + ", keyword=" + keyword + "]";
	}
	
	
	

}
