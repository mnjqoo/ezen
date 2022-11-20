package condition;

public class Star05 {

	public static void main(String[] args) {
		//     ☆
		//    ☆☆☆
		//   ☆☆☆☆☆
		//  ☆☆☆☆☆☆☆
		// ☆☆☆☆☆☆☆☆☆
		
		int lineNumber = 5;
		for(int i = 0; i < lineNumber; i++) {
			for(int j = 1; j <= lineNumber; j++) {
				if(i <= lineNumber - j) {
					System.out.print(" ");
				} else {
					System.out.print("☆");
				}
			}
			
			for(int j = 0; j <= i; j++) {
				System.out.print("☆");
			}
			
			System.out.println();
	    }
		
		for(int i = 0; i < lineNumber; i++) {
			for(int j = lineNumber - i; j > 1; j--) {
				System.out.print(" ");
			}
			
			for(int j = 0; j < i * 2 + 1; j++) {
				System.out.print("☆");
			}
			System.out.println();
		}
		
		for(int i = 0; i < lineNumber; i++) {
			for(int j = 0; j < lineNumber + i; j++) {//한 줄에 그려야 될 것이 하나씩 늘어나므로 (5개, 6개, 7개...)
				if(j < lineNumber - (i + 1)) {
				System.out.print(" ");
			    } else {
			    System.out.print("☆");
			    }
			}
			System.out.println();
		}

	}

}
