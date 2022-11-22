package object.poly.poly2;



//-----------------------------------------------------------------------------
class Product {
	int price = 0; //제품의 가격
	int bonusPoint = 0; // 제품 구매시 제공하는 보너스 점수
	
	Product(int price){
		this.price = price;
		bonusPoint = price / 10; //보너스 점수는 제품가격의 10%
	}
}
//-----------------------------------------------------------------------------
class Tv extends Product {
	Tv(){
		super(100); //조상클래스의 생성자 Product(int price)를 호출한다. Tv의 가격을 100만원으로 설정한다.
	}
	public String toString() {//Object 클래스의 toSting()을 오버라이딩한다.
		return "Tv";
	}
}
//-----------------------------------------------------------------------------
class Computer extends Product {
	Computer(){
		super(200);
	}
	public String toString() {
		return "Computer";
	}
}
//-----------------------------------------------------------------------------
class Mobile extends Product {
	Mobile(){
		super(150);
	}
	public String toString() {
		return "Mobile";
	}
}
//-----------------------------------------------------------------------------
class Buyer {
	int myMoney = 1000;
	int bonusPoint = 0;
	Product[] item = new Product[10]; //구매한 제품을 저장하기 위한 배열
	int cnt = 0; //Product 배열에 사용될 카운터
	
	void buy (Product p) {
		if(myMoney < p.price) {
			System.out.println("잔액이 모자라서 " + p + "을/를 구매할 수 없습니다.");
			return;
		}
		myMoney -= p.price; 
		bonusPoint += p.bonusPoint; 
		item[cnt++] = p; //구매한 제품을 Product[] item에 저장한다.
	}
	
	void summary() { //구매한 현 상황을 보여준다.
		int sum = 0; //구매하는데 사용된 금액의 함계
		String itemList = ""; //구매한 물품 목록
		int bonus = 0;
		for(int i = 0; i < cnt; i++) {
			if(item[i] == null) break;
			sum += item[i].price; //구매한 물품 가격을 누적시킨다.
			itemList += item[i] + ", "; //구매한 물품 목록을 추가시킨다.
			bonus += item[i].bonusPoint; //보너스 점수를 누적시킨다.
		}
		System.out.println("총 제품 구매 비용: " + sum + "만원");
		System.out.println("구매한 제품 목록: " + itemList);
		System.out.println("누적 보너스 점수: " + bonus);
		System.out.println("남은 금액: " + myMoney);
	}
}
//-----------------------------------------------------------------------------
	
public class PolyArgumentExam {

	public static void main(String[] args) {
		Tv tv = new Tv();
		Computer com = new Computer();
		Mobile mobile = new Mobile();
		
		Buyer man = new Buyer();
		man.buy(tv);
		man.buy(com);
		man.summary();
		
		System.out.println("===============================");
		
		Buyer man2 = new Buyer();
		man2.buy(com);
		man2.buy(mobile);
		man2.summary();
		

	}

}
//-----------------------------------------------------------------------------