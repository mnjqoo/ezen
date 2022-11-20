package condition;

public class Star02 {

	public static void main(String[] args) {
		//    ☆
		//   ☆☆
		//  ☆☆☆
		// ☆☆☆☆
		//☆☆☆☆☆
		
		for(int i = 5; i > 0; i--) {
			for(int j = 1; j < 6; j++) {
				if(j >= i) {
					System.out.print("☆");
				} else {
					System.out.print(" ");
				}
			}
			System.out.println();
		}
		
		int lineNumber = 5;
		for(int i = 1; i <= lineNumber; i++) {
			for(int j = 1; j <= lineNumber; j++) {
				if(i <= lineNumber - j) {
					System.out.print(" ");
				} else {
					System.out.print("☆");
				}
			}
			System.out.println();

	    }

    }
}
