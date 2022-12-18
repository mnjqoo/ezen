package ch08;

public class ClothingInfo extends ProductInfo {

	private String size; //사이즈(S/M/L/XL/XXL)
	private String color; //색상
	
	
	public String getSize() {
		return size;
	}
	public void setSize(String size) {
		this.size = size;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	@Override
	public String toString() {
		return "옷 정보 [사이즈=" + size + ", 색상=" + color + "]";
	}
	
	
}
