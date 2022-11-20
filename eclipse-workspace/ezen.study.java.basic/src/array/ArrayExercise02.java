package array;

public class ArrayExercise02 {

	public static void main(String[] args) {
		
		java.util.Scanner sc = new java.util.Scanner(System.in);
		int[] coinUnit = {500, 100, 50, 10}; //동전의 종류
		int[] coin = {5, 5, 5, 5}; // 동전단위별 보유개수
		
		System.out.println("동전으로 교환할 금액은 얼마인가요?");
		int myMoney = sc.nextInt();
		System.out.println("============================================================");
		
		System.out.print("|| ");
		for(int i = 0; i < coinUnit.length; i++) {
			
			if((myMoney / coinUnit[i]) >= coin[i]) {
				System.out.print(coinUnit[i] + "원 : " + coin[i] + "개 || ");
				myMoney = (myMoney % coinUnit[i]) + (myMoney / coinUnit[i] - coin[i]) * coinUnit[i];
				coin[i] -= coin[i];
			} else {
				System.out.print(coinUnit[i] + "원 : " + (myMoney / coinUnit[i]) + "개 || ");
				coin[i] = coin[i] - myMoney / coinUnit[i];
				myMoney = myMoney % coinUnit[i];
				
			}
			
		}
		// 남은 동전의 개수? 거스르고 남은 금액?
		
		System.out.println();
		System.out.println("남은 동전의 개수 : ");
		System.out.print("|| ");
		for(int i =0; i < coin.length; i++) {
			System.out.print(coinUnit[i] + "원 : " + coin[i] + "개 || ");
		}
		System.out.println();
		System.out.println("남은 금액 : " + myMoney);
		
		

	} //public static void main(String[] args)

} //public class ArrayExercise02 
