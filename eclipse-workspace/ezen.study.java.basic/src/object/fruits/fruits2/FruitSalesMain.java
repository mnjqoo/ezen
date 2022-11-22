package object.fruits.fruits2;
//-----------------------------------------------------------------------------
class FruitSeller {
	int numOfApple = 0; //사과 보유 갯수
	int myMoney = 0; //판매 수익 금액
	int APPLE_PRICE = 0; //사과 한개당 금액
	
	public int saleApple(int money) {
		numOfApple -= money / APPLE_PRICE;
		myMoney += money;
		return money / APPLE_PRICE;
	}
	
	public void showSaleResult() {
		System.out.println("판매수익금액: " + myMoney);
		System.out.println("남은 사과 개수: " + numOfApple);
	}
	
	public void initFruitSeller(int numOfApple, int money, int price) { //과일 판매를 하기 전에 필요한 변수들을 초기화 한다.
		this.numOfApple = numOfApple;
		myMoney = money;
		APPLE_PRICE = price;
	}
}
//-----------------------------------------------------------------------------
class FruitBuyer {
	int myMoney = 50000; //보유금액
	int numOfApple = 0; //장바구니
	
	public void buyApple(FruitSeller seller, int money) {
		myMoney -= seller.saleApple(money) * seller.APPLE_PRICE;
		numOfApple += seller.saleApple(money);
	}
	
	public void showBuyResult() {
		System.out.println("구매 개수: " + numOfApple);
		System.out.println("보우 금액: " + myMoney);
	}
	
}
//-----------------------------------------------------------------------------
public class FruitSalesMain {

	public static void main(String[] args) {
		FruitSeller seller1 = new FruitSeller(); //사과장수1 등장
		seller1.initFruitSeller(150, 0, 1000);
		FruitSeller seller2 = new FruitSeller(); //사과장수2 등장
		seller2.initFruitSeller(100, 5000, 1300);
		FruitSeller seller3 = new FruitSeller(); //사과장수3 등장
		seller3.initFruitSeller(200, 10000, 1200);
		
		FruitBuyer buyer = new FruitBuyer(); // 과일구매자 등장
		
		// 돈을 주고 과일을 구매한다.
		System.out.println("===구매자 현황===");
		buyer.buyApple(seller1, 13500);
		buyer.showBuyResult();
		buyer.buyApple(seller2, 3400);
		buyer.showBuyResult();
		buyer.buyApple(seller3, 1700);
		buyer.showBuyResult();
		System.out.println("===판매자1 현황===");
		seller1.showSaleResult();
		System.out.println("===판매자2 현황===");
		seller2.showSaleResult();
		System.out.println("===판매자3 현황===");
		seller3.showSaleResult();
	}

}
//-----------------------------------------------------------------------------