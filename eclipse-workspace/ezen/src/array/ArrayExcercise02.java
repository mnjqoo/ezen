package array;

public class ArrayExcercise02 {

	public static void main(String[] args) {

		java.util.Scanner sc = new java.util.Scanner(System.in);
		
		int[]	coinUnit	= {500, 100, 50, 10};	// 동전의 종류
		int[]	coin		= {  5,   5,  5,  5};	// 동전단위별 보유개수
		
		System.out.print("동전으로 교환할 금액은 얼마인가요? ");
		int myMoney = sc.nextInt();
		System.out.println("==============================================");
		
		// 더 큰 값의 동전으로 먼저 거슬러준다.
		// 남은 동전의 개수?  거슬르고 남은 금액?
		for(int i = 0; i < coinUnit.length; i++) { // 동전단위별 작업(500=>100=>50=>10)
			int coinNum = 0;	// 동전의 개수를 저장할 변수
			
			// 금액을 동전단위로 나누어서 필요한 동전의 개수를 구한다.
			coinNum = myMoney / coinUnit[i];
			
			// 거슬러 줄 동전의 개수가 모자란다면 있는 개수 모두 거슬러 준다.
			if(coin[i] >= coinNum) { // 0,1,2,3,4,5인 경우
				coin[i] -= coinNum;
			} else {
				coinNum = coin[i];
				coin[i]	= 0;
			}
			
			// 금액에서 동전의 개수x동전 단위 만큼 차감한다.
			myMoney -= coinNum * coinUnit[i];
			System.out.println(coinUnit[i] + "원짜리 " + coinNum + "개를 거슬러 주었습니다.");
			
		} // End - for // 동전단위별 작업(500=>100=>50=>10)

		System.out.println("==============================================");
		System.out.println("거슬르고 남은 금액 : " + myMoney + "원");
		System.out.println("남은 동전의 개수");
		for(int i = 0; i < coinUnit.length; i++)
			System.out.println(coinUnit[i] + "원 : " + coin[i] + "개");
		

	} // End - public static void main(String[] args)

} // End - public class ArrayExcercise02









