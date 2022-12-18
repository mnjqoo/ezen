package ch07;

public class ProductInfo { //제품 Bean(자바빈 규격서에 따라 작성된 자바 클래스)
	
	//parameter가 없는 생성자가 반드시 있어야 하고, 
	//클래스 외부에서 필드(클래스의 멤버 변수)를 필요로 할 때 직접 접근 할 수 없고
	//반드시 메소드를 통해서 접근해야한다. 이 메소드의 이름은 get과 set 으로 시작해야 한다. 
	private String name; //멤버변수, 인스턴스 변수
	private int price;
	
	public ProductInfo() { //매개 변수가 없는 기본 생성자
		
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		
		this.name = name;
	}
	
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "[name=" + name + ", price=" + price + "]";
	}
	
	
}
