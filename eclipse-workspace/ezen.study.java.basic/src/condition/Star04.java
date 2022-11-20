package condition;

public class Star04 {

	public static void main(String[] args) {
		// ☆☆☆☆☆
		//  ☆☆☆☆
		//   ☆☆☆
		//    ☆☆
		//     ☆
		
		int lineNumber = 5;
		for(int i = 0; i < lineNumber; i++) {
			for(int j = 0; j < lineNumber; j++) {
				if(j < i) {
					System.out.print(" ");
				} else {
					System.out.print("☆");
				}
			}
			System.out.println();

	    }
		
		for(int i = 0; i < lineNumber; i++) {
			for(int j = 0; j < i; j++) {
					System.out.print(" ");
			}
			for(int j = 0; j < lineNumber - i; j++) {
				System.out.print("☆");
		    }
			
			System.out.println();

	    }
		

	}

}
