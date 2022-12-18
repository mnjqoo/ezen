package ch08;

public class BookInfo extends ProductInfo {

	private int page; //페이지 수
	private String writer; //저자
	
	
	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		this.page = page;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	@Override
	public String toString() {
		return "책 정보 [페이지 수=" + page + ", 저자=" + writer + "]";
	}
	
	
}
