package com.practice.common.util;

public class PageMaker { //게시판의 페이지 번호를 만들 때 필요한 정보
	
	private Criteria cri;
	private int totalCount; //게시물의 총 갯수(에 따라 최종 마지막 페이지의 숫자가 결정된다.)
	private int startPageNum; //게시판 페이지 번호의 첫번째 숫자
	private int endPageNum; //게시판 페이지 번호의 마지막 숫자
	private final int displayPageNum = 5; //보여질 게시판 페이지의 갯수
	
	private boolean prev; //이전 버튼. 참일 때 보이게 한다.
	private boolean next; //다음 버튼. 참이 때 보이게 한다.
	
	public Criteria getCri() {
		return cri;
	}
	public void setCri(Criteria cri) {
		this.cri = cri;
	}
	public int getTotalCount() {
		return totalCount;
	}
	public void setTotalCount(int totalCount) { //총 게시글의 숫자를 입력하면 나머지 변수들의 값도 계산되어 들어가도록 해준다.
		this.totalCount = totalCount;
		calculatePage(); //계산해서 입력해줄 메소드
	}
	public int getStartPageNum() {
		return startPageNum;
	}
	public void setStartPageNum(int startPageNum) {
		this.startPageNum = startPageNum;
	}
	public int getEndPageNum() {
		return endPageNum;
	}
	public void setEndPageNum(int endPageNum) {
		this.endPageNum = endPageNum;
	}
	public boolean isPrev() {
		return prev;
	}
	public void setPrev(boolean prev) {
		this.prev = prev;
	}
	public boolean isNext() {
		return next;
	}
	public void setNext(boolean next) {
		this.next = next;
	}
	public int getDisplayPageNum() {
		return displayPageNum;
	}
	@Override
	public String toString() {
		return "PageMaker [cri=" + cri + ", totalCount=" + totalCount + ", startPageNum=" + startPageNum
				+ ", endPageNum=" + endPageNum + ", displayPageNum=" + displayPageNum + ", prev=" + prev + ", next="
				+ next + "]";
	}
	
	public void calculatePage() {
		
		endPageNum = (int)(Math.ceil(cri.getPageNum() / (double)displayPageNum) * displayPageNum); //현재 페이지를 기준으로 보여질 마지막 페이지를 구한다.
		startPageNum = (endPageNum - displayPageNum) + 1;
		
		//최종 마지막 페이지를 구한다.
		int lastPageNum = (int)(Math.ceil(totalCount / (double)cri.getPerPageNum())); //전체 게시글 / 한페이지당 보여줄 게시글 수로 나누면 최종 페이지 숫자가 나온다.
		
		//최종 페이지가 현재페이지 기준 endPageNum보다 작으면 endPageNum을 최종페이지가 되도록 한다.
		if(lastPageNum <= endPageNum) {
			endPageNum = lastPageNum;
		}
		
		//이전 버튼의 활성화 기준(startPageNum이 1이 아닌 경우)
		prev = startPageNum != 1 ? true : false;
		
		//다음 버튼의 활성화 기준(endPageNum이 lastPageNum이 아닌 경우)
		next = endPageNum != lastPageNum ? true : false;
	}
	
	
}
