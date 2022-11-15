package condition;

public class Star02 {

	public static void main(String[] args) {
			/* 별그리기
		____★
		   ★★
		  ★★★
		 ★★★★
		★★★★★
		*/
		int lineNumber = 5;
		
		for(int i = 1; i <= lineNumber; i++) { // 줄 수
			for(int j = 1; j <= lineNumber; j++) { // 한 줄에 그리는 횟수
				if(i <= lineNumber -j) {
					System.out.print(" ");
				} else {
					System.out.print("★");
				}
			}
			System.out.println(); // 한 줄에서 그리기가 끝나면 줄 바꿈을 한다.
		}

		System.out.println("==========================================");
		for(int i = 1; i <= lineNumber; i++) { // 줄 수
			for(int j = lineNumber; j >= 1; j--) { // 한 줄에 그리는 횟수
				if(i < j) {
					System.out.print(" ");
				} else {
					System.out.print("★");
				}
			}
			System.out.println(); // 한 줄에서 그리기가 끝나면 줄 바꿈을 한다.
		}

	}

}













