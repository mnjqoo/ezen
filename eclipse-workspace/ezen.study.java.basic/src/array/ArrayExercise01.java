package array;

public class ArrayExercise01 {

	public static void main(String[] args) {
		java.util.Scanner sc = new java.util.Scanner(System.in);
		
		int[] coinUnit = {500, 100, 50, 10}; //동전의 종류
		System.out.print("동전으로 교환할 금액은 얼마인가요? : ");
		int myMoney = sc.nextInt();
		
		//가지고 있는 금액을 큰 금액의 동전부터 먼저 거슬러주면
		//각 동전은 몇개씩 필요한가요?
		System.out.print("|| ");
		for(int i = 0; i < coinUnit.length; i++) {
			System.out.print(coinUnit[i] + "원 : " + (myMoney / coinUnit[i]) + "개 || ");
			myMoney = myMoney % coinUnit[i];
		}
		
		System.out.println();
		System.out.println("남은 금액 : " + myMoney);

	} //public static void main(String[] args)

} //public class ArrayExercise01
