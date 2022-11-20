package array;

public class NumberBaseball {

	public static void main(String[] args) {
		
		int[] com = new int[3]; // 컴퓨터가 추출한 문제
		int[] user = new int[3]; // 사용자가 입력한 3개의 숫자
		int num = 0; // 사용자가 입력한 숫자를 저장할 변수
		int counter = 0; // 몇번만에 맞추었는지 저장할 변수
		boolean randomBall = true; 
		
		// 1-9 사이의 서로 다른 임의의 정수를 3개 추출하여 배열 com에 저장한다.
		// 사용자가 숫자를 3개 입력한다.
		// 사용자가 입력한 숫자와 컴퓨터가 추출한 숫자가 같은지 비교한다.
		// 맞춘 갯수와 틀린 갯수를 보여준다. 값 + "스트라이크" + 값 + "볼"
		// 3 스트라이크면 3개의 숫자를 모두 맞추었으므로 게임을 끝낸다.
		while(randomBall) {
			com[0] = (int)(Math.random() * 9) + 1;
			com[1] = (int)(Math.random() * 9) + 1;
			com[2] = (int)(Math.random() * 9) + 1;
			if(com[0] != com[1] && com[1] != com[2] && com[0] != com[2])
				randomBall = false;
		}
		//System.out.println(com[0] + ", " + com[1] + ", " + com[2]);
		randomBall = true;
		
		System.out.println("==========★☆야구 게임 시작☆★==========");
		
		while(randomBall) {
			System.out.println(">>1 ~ 9 사이의 정수를 입력하세요.");
			
			java.util.Scanner sc = new java.util.Scanner(System.in);
			user[0] = sc.nextInt();
			user[1] = sc.nextInt();
			user[2] = sc.nextInt();	
			int strike = 0;
		    int ball = 0;
			for(int i = 0; i < user.length; i++) {
				for(int j = 0; j < com.length; j++) {
					if(i == j) {
						if(user[i] == com[j])
							strike++;
					} else {
						if(user[i] == com[j])
							ball++;
					}
				}
			}
			System.out.println("[" + strike + " 스트라이크, " + ball + " 볼]");
			counter++;
			if(strike == 3) {
			    randomBall = false;		    	
			}
		}
		System.out.println(counter + " 회 시도하였습니다.");
	} //public static void main(String[] args)

} //public class NumberBaseball
