package ch08;

public class ProductInfo {
	
	private String code; //상품코드
	private String name; //상품 명
	private String price; //상품 가격
	
	public ProductInfo() {
		
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "제품정보 [상품코드=" + code + ", 상품 명=" + name + ", 상품 가격=" + price + "]";
	}
	
	
}
