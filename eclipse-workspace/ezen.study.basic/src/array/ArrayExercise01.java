package array;

public class ArrayExercise01 {

	public static void main(String[] args) {
		java.util.Scanner sc = new java.util.Scanner(System.in);

		int[] coinUnit = {500, 100, 50, 10};	// 동전의 종류
		
		System.out.print("동전으로 교환할 금액은 얼마인가요? : ");
		int myMoney = sc.nextInt();
		
		// 가지고 있는 금액을 큰 금액의 동전부터 먼저 거슬러 주면,
		// 각 동전은 몇 개씩 필요한가요?

		// 작업의 횟수는 동전의 종류만큼만 할 수 있다.
		for(int i = 0; i < coinUnit.length; i++) {
			// 금액을 동전으로 나눈 몫이 그 동전으로 거슬러 줄 수 있는 개수이다.
			System.out.println(coinUnit[i] + "원 : " + (myMoney / coinUnit[i]) + "개");
			
			// 나머지를 가지고 다음 동전으로 작업할 수 있게 한다.
			myMoney = myMoney % coinUnit[i];
		}
		// 여기서는 거슬르는 금액이 1단위가 있어야 남은 금액에 값이 나온다.
		// 아니면 모두 0원으로 나온다.
		System.out.println("남은 금액 : " + myMoney + "원");
		
		
	} // End - public static void main(String[] args)

} // End - public class ArrayExercise01





