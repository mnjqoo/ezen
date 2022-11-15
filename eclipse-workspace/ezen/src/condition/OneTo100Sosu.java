package condition;

public class OneTo100Sosu {

	public static void main(String[] args) {
		// 소수는 1과 자기자신으로만 나누어지는 수를 말합니다.
		// 1부터 100까지의 정수에서 모든 소수를 구하십시오.
		// 작업대상이 되는 수(1~100)가 1과 자신을 제외한 나머지 수로 나누어지지 않는 수를 찾는다.
		// 2 3 5 7 11 13 17 19 23 29 31 37 41 43 47 53 59 61 67 71 73 79 83 89 97
		
		int count = 0;	// 나누어 지는 회수를 저장할 변수
		
		// 1은 소수가 아니므로 2부터 작업을 시작한다.
		for(int num = 2; num <= 100; num++) {
			for(int j = 2; j <= num; j++) {
				if(num % j == 0) {
					count++;
				}
			} // End - 하나의 수에 대해서 나누는 작업이 끝나면
			// 하나의 숫자에 대해서 나누기가 모두 끝났으면
			if(count == 1) {
				System.out.print(num + " ");
			}
			// 하나의 숫자에 대해서 모두 작업이 끝나면 count를 초기화 한다.
			count = 0;
		}
		
	}

}
