package condition;

public class OneTo100Sosu {

	public static void main(String[] args) {
		// 1-100의 정수에서 소수 구하기
		/*int a = 100;
		
		System.out.println(2);
		System.out.println(3);
		System.out.println(5);
		System.out.println(7);
		for(int i = 2; i <= a; i++) {
	
			if(i%2 != 0 && i%3 != 0 && i%5 != 0 && i%7 != 0) {
				System.out.println(i);
			}
		}
		*/
		int count = 0;
		
		for(int num = 2; num <=100; num++) {
			for(int j = 2; j <= num; j++) {
				if(num % j == 0) {
					count++;
				}
			}
		    if(count == 1) {
			System.out.println(num + " ");	
		}
		count = 0;
		}

	}

}
