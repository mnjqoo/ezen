package object.block;

class Product{
	static int count = 0; //생산된 제품(인스턴스)의 총 생산량을 저장하기 위한 변수
	int serialNo ; //제품(인스턴스)의 고유번호
	
	{ //인스턴스 초기화 블럭
		++count; // 제품이 생산 될 때 마다 총 생산량을 1씩 증가시킨다.
		serialNo = count;
	}
	
	public Product(){ //생성자
		System.out.println("제품을 1대 생산하였습니다.");
	}
}

public class ProductExam {

	public static void main(String[] args) {
		Product p1 = new Product();
		System.out.println("p1의 제품번호 : " + p1.serialNo);
		Product p2 = new Product();
		System.out.println("p2의 제품번호 : " + p2.serialNo);
		Product p3 = new Product();
		System.out.println("p3의 제품번호 : " + p3.serialNo);
		
		System.out.println("생산된 제품의 총 수량 : " + Product.count);
		
	}

}
