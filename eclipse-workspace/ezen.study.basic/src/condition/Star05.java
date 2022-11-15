package condition;

public class Star05 {

	public static void main(String[] args) {
		/* 별그리기
		    ★
		   ★★★
		  ★★★★★
		 ★★★★★★★
		★★★★★★★★★
		*/
		int lineNumber = 5;
		for(int i = 0; i < lineNumber; i++) {
			for(int j = lineNumber - i; j > 1; j--) {
				System.out.print(" ");
			}
			for(int j = 0; j < i*2+1; j++) {
				System.out.print("★");
			}
			System.out.println();
		}
		
		System.out.println("===================================");
		for(int i = 0; i < lineNumber; i++) {
			for(int j = 0; j < lineNumber+i; j++) { // lineNumber+i <= 한 줄에 그려야 될 것이 1씩 늘어나므로
				if(j < lineNumber - (i+1))	System.out.print(" ");
				else						System.out.print("★");
			}
			System.out.println();
		}
		
	}

}


