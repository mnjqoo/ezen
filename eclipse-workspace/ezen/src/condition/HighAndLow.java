package condition;

public class HighAndLow {

	public static void main(String[] args) {
		// 1 ~ 100사이의 임의의 정수를 맞추는 게임
		
		// 1 ~ 100 사이의 임의의 정수를 추출한다.(문제)
		int answer 	= (int)(Math.random() * 100) + 1;
		int	count	= 0;	// 정답을 맞추기 위해서 시도한 횟수를 저장할 변수
		int	input	= 0;	// 사용자가 입력한 값을 저장할 변수
		
		// 화면으로 부터 사용자의 입력을 받기 위해서 사용할 Scanner 클래스
		java.util.Scanner s = new java.util.Scanner(System.in);
		
		System.out.println("================");
		System.out.println("숫자 맞추기 게임");
		System.out.println("0. 게임종료");
		System.out.println("1. 게임시작");
		System.out.println("================");
		
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
	} // End - public static void main(String[] args)

} // End - public class HighAndLow











