package array;

import java.util.Scanner;

public class NumberBaseballExample {

	public static void main(String[] args) {
		int[] com = new int[3]; // 컴퓨터가 추출한 문제
		int[] user = new int[3]; // 사용자가 입력한 3개의 숫자
		int num = 0; // 사용자가 입력한 숫자를 저장할 변수
		int counter = 0; // 몇번만에 맞추었는지 저장할 변수
		boolean randomBall = true; 
		
		while(randomBall) {
			for(int i = 0; i < com.length; i++) {
				com[i] = (int)(Math.random() * 9) + 1;
			}
			if(com[0] != com[1] && com[1] != com[2] && com[0] != com[2])
				randomBall = false;
		}
		randomBall = true;
		
        System.out.println("==========★☆야구 게임 시작☆★==========");
		
		while(randomBall) {
			int strike = 0;
			int ball = 0;
			Scanner input = new Scanner(System.in);
			for(int i = 0; i < user.length; i++) {
				try {
					System.out.print(i + 1 + "번째 숫자를 입력하세요 : ");
					num = input.nextInt();
					if(num < 1 || num > 9) {
						System.out.println("1-9사이의 숫자를 입력하세요.");
						i--;
						continue;
					}
					user[i] = num;
				} catch(Exception e) {
					System.out.println("잘못된 값을 입력하셨습니다.");
				}
			}
			for(int j = 0; j < com.length; j++) {
				for(int i = 0; i < user.length; i++) {
					if(user[i] == com[j] && i == j) {
						strike++;
					} else if(user[i] == com[j] && i != j) {
							ball++;
					}
				}
			}
			System.out.println("[" + strike + " 스트라이크, " + ball + " 볼]");
			counter++;
			if(strike == 3) {
			    randomBall = false;		 
			    input.close();
			    
			}
		}
		System.out.println(counter + " 회 시도하였습니다.");
		System.out.println("게임이 종료되었습니다.");
	}

}
