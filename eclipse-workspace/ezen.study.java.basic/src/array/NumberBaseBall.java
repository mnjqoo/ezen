package array;

import java.util.Scanner;

public class NumberBaseBall {

	public static void main(String[] args) {
		// 숫자로 야구게임하기
		int		com[]		= new int[3];	// 컴퓨터가 추출한 문제
		int		user[]		= new int[3];	// 사용자 입력한 3개의 값
		int		num			= 0;			// 사용자가 입력한 숫자를 저장할 변수
		int		counter		= 0;			// 몇 번만에 맞추었는지 저장할 변수
		boolean	randomBall	= true;
		
		// 1 부터 9 사이의 서로 다른 임의의 정수를 3개 추출하여 배열 com에 저장한다.
		while(randomBall) {
			for(int i = 0; i < com.length; i++) {
				com[i] = (int)(Math.random() * 9) + 1; // 1부터 9사이의 정수를 추출한다.
			}
			// 3개의 숫자가 모두 다르면 while문을 벗어난다.
			if(com[0] != com[1] && com[0] != com[2] && com[1] != com[2]) {
				randomBall = false;
			}
		}
		randomBall = true;
		
		System.out.println("====================================");
		System.out.println("========== 야구 게임 시작 ==========");
		System.out.println("====================================");
		while(randomBall) {
			int	strike	= 0;
			int	ball	= 0;
			
			System.out.println("1 ~ 9 사이의 정수를 입력하세요.");
			// java.util.Scanner input = new java.util.Scanner(System.in);
			Scanner input = new Scanner(System.in);
			
			// 사용자가 숫자를 3개 입력한다.
			for(int i = 0; i < user.length; i++) {
				try {
					System.out.print(i+1 + "번째 숫자를 입력하세요 : ");
					num = input.nextInt();
					if(num < 1 || num > 9) {
						System.out.println("1 ~ 9 사이의 숫자를 입력하세요.");
						i--;
						continue;
					}
					user[i] = num;
				} catch(Exception e) {
					System.out.println("잘못된 값을 입력하셨습니다.");
				}
			}
			// for(int i = 0; i < user.length; i++)
			//	System.out.print(user[i] + " ");
			
			// 사용자가 입력한 숫자와 컴퓨터가 추출한 숫자가 같은지 비교한다.
			for(int i = 0; i < com.length; i++) { // 컴퓨터배열(숫자)과 사용자배열(숫자)을 비교한다.
				for(int j = 0; j < user.length; j++) {
					if(com[i] == user[j] && i == j) { // 배열이 같고(숫자) 위치까지 같으면 스트라이크
						strike++;
					} else if(com[i] == user[j] && i != j) { // 배열이 같고(숫자) 위치가 다르면 볼
						ball++;
					}
				}
			}
			counter++;
			
			// 맞춘 개수와 틀린 개수를 보여준다.
			System.out.println("----------------------------------");
			System.out.println(strike + "스트라이크 " + ball + "볼");
			System.out.println("----------------------------------");
			
			// 3 스트라이크이면 3개의 숫자를 모두 맞추었으므로 게임을 끝낸다.
			if(strike == 3) { // 스트라이크가 3개이면 모두 맞추었으므로 반복문을 벗어난다.
				randomBall = false;
				input.close();
			}
			
		} // End - while(게임 중)
		System.out.println("횟수 : " + counter);
		System.out.println("게임이 끝났습니다.");

	} // End - public static void main(String[] args)

} // End - public class NumberBaseBall




