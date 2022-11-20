package condition;

public class HighAndLowExample {

	public static void main(String[] args) {
		// 1-100사이의 임의의 정수를 맞추는 게임
		// 1-100사이의 임의의 정수를 추출한다.
		
		int answer = (int)(Math.random() * 100) +1; 
		int count = 0; //정답을 맞추기 위해서 시도한 횟수를 저장할 변수
		int input = 0; //사용자가 입력한 값을 저장할 변수
		int a = 0;
		// 화면으로 부터 사용자의 입력을 맏기 위해서 사용할 Scanner 클래스
		java.util.Scanner s = new java.util.Scanner(System.in);
		
		
		// 게임 과정
		do {
			System.out.println("================");
			System.out.println("숫자 맞추기 게임");
			System.out.println("0. 게임종료");
			System.out.println("1. 게임시작");
			System.out.println("================");
			input = s.nextInt();
			if(input == 1) {
				do {			
					System.out.print("1과 100사이의 정수를 입력하세요 : ");
					input = s.nextInt();
					count++;
					if(input == answer) {
						System.out.println("정답입니다. 시도한 횟수는 " + count + "입니다.");
						a++;
					} else if(input > answer) {
						System.out.println("더 작은 수 입니다.");
					} else if(input < answer) {
						System.out.println("더 큰 수 입니다.");
					}
					
					
				} while(input != answer);
			} else if (input == 0) {
				System.out.println("게임이 종료되었습니다.");
				break;
			} else {
				System.out.println("올바른 숫자를 입력하세요.");
			}
		} while(a == 0);	s.close();

	}

}
