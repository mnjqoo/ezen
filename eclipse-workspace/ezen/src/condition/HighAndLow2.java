package condition;

public class HighAndLow2 {

	public static void main(String[] args) {
		// 1 ~ 100사이의 임의의 정수를 맞추는 게임
		
		int	count	= 0;	// 정답을 맞추기 위해서 시도한 횟수를 저장할 변수
		int	input	= 0;	// 사용자가 입력한 값을 저장할 변수
		int startYN = 0;	// 게임종료와 게임시작을 구분하기 위한 변수
		
		// 화면으로 부터 사용자의 입력을 받기 위해서 사용할 Scanner 클래스
		java.util.Scanner s = new java.util.Scanner(System.in);
		
		do {
			System.out.println("================");
			System.out.println("숫자 맞추기 게임");
			System.out.println("0. 게임종료");
			System.out.println("1. 게임시작");
			System.out.println("================");
			
			startYN	= s.nextInt();
			if(startYN == 0) {
				System.out.println("게임을 종료합니다.");
				break;
			} else if(startYN != 1) {
				System.out.println("잘못된 번호를 입력하셨습니다.\n다시 선택하십시오.");
				continue;
			} else {
				System.out.println("게임을 시작합니다.");
			}
			
			// 1 ~ 100 사이의 임의의 정수를 추출한다.(문제)
			int answer 	= (int)(Math.random() * 100) + 1;
			input	= 0;	// 게임이 시작되면 시도한 횟수를 0으로 초기화 한다.

			// 게임과정
			do {
				count++;
				System.out.print("1과 100사이의 정수를 입력하세요 : ");
				input = s.nextInt();
				
				if(answer > input) {
					System.out.println("더 큰 수를 입력하세요.");
				} else if(answer < input) {
					System.out.println("더 작은 수를 입력하세요.");
				} else {
					System.out.println("정답입니다.");
					System.out.println(count + "번만에 맞추셨습니다.");
					break; // 반복문을 벗어난다.
				}
			} while(true);	// 무한반복
		} while(startYN != 0);	// 1.게임시작을 누르면 반복 실행한다.
		s.close(); // 사용이 끝난 자원을 닫는다.
	} // End - public static void main(String[] args)

} // End - public class HighAndLow











