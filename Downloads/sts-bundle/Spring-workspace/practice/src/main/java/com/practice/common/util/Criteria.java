package com.practice.common.util;

public class Criteria { //게시글 목록 기본 정보
	
	private int pageNum; //현재페이지 숫자
	private final int perPageNum = 5; //한페이지 당 보여줄 게시글 갯수로 고정값이다.
	
	public Criteria() { //기본 생성자가 생성될 때
		pageNum = 1; //기본값을 지정해준다.
	}

	public int getPageNum() {
		return pageNum;
	}

	public void setPageNum(int pageNum) {
		if(pageNum < 0) { //현재 페이지값이 음수가 나오는 상황을 대비해
			pageNum = 1; //값을 지정한다.
		} else {
			this.pageNum = pageNum;			
		}
	}

	public int getPerPageNum() {
		return perPageNum;
	}

	@Override
	public String toString() {
		return "Criteria [pageNum=" + pageNum + ", perPageNum=" + perPageNum + "]";
	}
	
}
