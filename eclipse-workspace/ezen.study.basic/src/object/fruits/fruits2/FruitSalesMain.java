package object.fruits.fruits2;

//-----------------------------------------------------------------------------------------------------------
// 과일 판매자(사과장수)
//-----------------------------------------------------------------------------------------------------------
class FruitSeller {
	int numOfApple	= 0;	// 사과 보유 개수
	int	myMoney		= 0;	// 판매 수익 금액
	int	APPLE_PRICE	= 0;	// 사과 1개당 판매 금액
	
	// 사과를 파는 행위 : 돈을 받고(매개변수), 사과를 건네준다.(return)
	public int saleApple(int money) {
		int num		= money / APPLE_PRICE;	// 받은 금액에 해당하는 사과의 개수를 구한다.
		myMoney		+= money;	// myMoney += num * APPLE_PRICE;
		numOfApple	-= num;		// 판매한 개수만큼 매대에서 차감한다.
		return num;	// 사과의 개수;
	}
	
	// 판매현황 알아보기
	public void showSaleResult() {
		System.out.println("사과판매 수익금 : " + myMoney);
		System.out.println("남은 사과 개수  : " + numOfApple);
	}
	
	// 과일 판매를 하기 전에 필요한 변수들을 초기화한다.
	public void initFruitSeller(int money, int appleNum, int price) {
		myMoney		= money;	// 시장에 나갈 때 가지고 나가는 금액
		numOfApple	= appleNum;	// 사과 보유 개수
		APPLE_PRICE	= price;	// 사과 1개당 판매금액
	}
	
} // End - class FruitSeller
//-----------------------------------------------------------------------------------------------------------
// 과일 구매자
//-----------------------------------------------------------------------------------------------------------
class FruitBuyer {
	int myMoney		= 50000;	// 보유금액
	int	numOfApple	= 0;		// 장바구니
	
	// 어떤 사과장수에게 돈을 주고, 사과를 건네 받는다.
	public void buyApple(FruitSeller seller, int money) {
		money		= (money / seller.APPLE_PRICE) * seller.APPLE_PRICE;
		myMoney		-= money;
		numOfApple	+= seller.saleApple(money);
	}
	
	// 구매현황 알아보기
	public void showBuyResult() {
		System.out.println("구매 개수 : " + numOfApple);
		System.out.println("보유 금액 : " + myMoney);
	}
	
} // End - class FruitBuyer
//-----------------------------------------------------------------------------------------------------------
// 시장
//-----------------------------------------------------------------------------------------------------------
public class FruitSalesMain {
	public static void main(String[] args) {
		FruitSeller	seller1	= new FruitSeller();	// 사과장수1 등장
		seller1.initFruitSeller(0, 150, 1000);
		
		FruitSeller	seller2	= new FruitSeller();	// 사과장수2 등장
		seller2.initFruitSeller(10000, 200, 1200);
		
		FruitSeller	seller3	= new FruitSeller();	// 사과장수3 등장
		seller3.initFruitSeller(5000, 100, 1300);
		
		FruitBuyer	buyer	= new FruitBuyer();		// 과일구매자 등장
		
		// 돈을 주고 과일(사과)을 구매한다.
		buyer.buyApple(seller1, 13500);
		buyer.buyApple(seller2,  3400);
		buyer.buyApple(seller3,  1700);

		System.out.println("=== 구매자 현황 ===");
		buyer.showBuyResult();
	
		System.out.println("=== 판매자 1 현황 ===");
		seller1.showSaleResult();
		System.out.println("=== 판매자 2 현황 ===");
		seller2.showSaleResult();
		System.out.println("=== 판매자 3 현황 ===");
		seller3.showSaleResult();
		
	}
} // End - public class FruitSalesMain










