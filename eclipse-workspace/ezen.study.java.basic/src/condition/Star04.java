package condition;

public class Star04 {

	public static void main(String[] args) {
		/* 별그리기
		★★★★★
		 ★★★★
		  ★★★
		   ★★
		    ★
		*/
		int lineNumber = 5;	// 줄의 수
		for(int i = 0; i < lineNumber; i++) {
			for(int j = 0; j < i; j++) { // 먼저 row(0부터 시작)만큼 공백을 그린다.
				System.out.print(" ");
			}
			for(int j = 0; j < lineNumber - i; j++) { // 공백을 그린 이후부터 ★을 그린다.
				System.out.print("★");
			}
			System.out.println();
		}
		
		System.out.println("============================================");
		lineNumber = 5;	// 줄의 수
		for(int i = 0; i < lineNumber; i++) {
			for(int j = 0; j < lineNumber; j++) {
				if(i > j) {
					System.out.print(" ");
				} else {
					System.out.print("★");
				}
			}
			System.out.println();
		}
		
	}

}





