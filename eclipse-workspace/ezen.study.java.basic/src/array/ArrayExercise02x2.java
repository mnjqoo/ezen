package array;

public class ArrayExercise02x2 {

	public static void main(String[] args) {

		java.util.Scanner sc = new java.util.Scanner(System.in);
		int[] coinUnit = {500, 100, 50, 10}; //동전의 종류
		int[] coin = {5, 5, 5, 5}; // 동전단위별 보유개수
		
		System.out.println("동전으로 교환할 금액은 얼마인가요?");
		int myMoney = sc.nextInt();
		System.out.println("============================================================");
		for(int i = 0; i < coinUnit.length; i++) {
			//금액을 동전단위로 나누어서 필요한 동전의 개수를 구한다.
			int coinNum = 0;
			coinNum = myMoney / coinUnit[i];
			
			// 거슬러 줄 동전의 개수가 모자란다면 있는 개수 모두 거슬러준다.
			if(coin[i] >= coinNum) {
				coin[i] -= coinNum;
			} else {
				coinNum = coin[i];
				coin[i] = 0;
			}
			
			// 금액에서 동전의 개수 * 동전 단위 만큼 차감한다.
			myMoney -= coinNum * coinUnit[i];
			System.out.println(coinUnit[i] + "원짜리 " + coinNum + "개를 거슬러 주었습니다.");
		}
		
		System.out.println("============================================================");
		System.out.println("거스르고 남은 금액 : " + myMoney + "원");
		System.out.println("남은 동전의 개수");
		for(int i = 0; i < coinUnit.length; i++) {
			System.out.println(coinUnit[i] + "원 : " + coin[i] + "개");
		}

	}

}
