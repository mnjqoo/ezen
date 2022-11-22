package object.poly.poly1;
//-----------------------------------------------------------------------------
class Product {
	int price; //제품의 가격
	int bonusPoint; // 제품 구매시 제공하는 보너스 점수
	
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
class Buyer { //고객, 물건을 사는 사람
	int myMoney = 1000; //소유금액
	int bonusPoint = 0; //물건 구매 후 받는 보너스 점수
	
	void buy(Product p) {
		if(myMoney < p.price) { //보유 금액이 제품가보다 적은 경우
			System.out.println("돈이 모자라서 " + p + "를 구매 할 수 없습니다.");
			return;
		}
		myMoney -= p.price; //구매자가 판매자에게 돈을 준다.
		bonusPoint += p.bonusPoint; //보너스 점수를 추가한다.
		System.out.println(p + " 제품을 구매하였습니다.");
		System.out.println("남은 금액: " + myMoney);
		System.out.println("누적 보너스 점수: " + bonusPoint);
		System.out.println("===================================");
	}
}
//-----------------------------------------------------------------------------

public class PolyArgumentExam {

	public static void main(String[] args) {
		Buyer man = new Buyer();
		Tv tv = new Tv();
		Computer com = new Computer();
		Mobile mobile = new Mobile();
		man.buy(tv);
		man.buy(com);
		man.buy(mobile);
		man.buy(tv);
		man.buy(com);
		man.buy(mobile);
		man.buy(tv);
		man.buy(com);

	}

}
//-----------------------------------------------------------------------------