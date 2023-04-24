package com.edu.common.criteria;

public class SearchArrayCriteria extends Criteria{

	private String searchType; //검색 조건
	private String keyword; //검색 키워드
	private String order_state; //운송 상태값
	private String arrayType; //정렬 타입
	
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
	public String getOrder_state() {
		return order_state;
	}
	public void setOrder_state(String order_state) {
		this.order_state = order_state;
	}
	public String getArrayType() {
		return arrayType;
	}
	public void setArrayType(String arrayType) {
		this.arrayType = arrayType;
	}
	@Override
	public String toString() {
		return "SearchArrayCriteria [searchType=" + searchType + ", keyword=" + keyword + ", order_state=" + order_state
				+ ", arrayType=" + arrayType + "]";
	}
	
	
}
