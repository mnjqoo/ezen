package condition;

public class Star03 {

	public static void main(String[] args) {
		// ☆☆☆☆☆
		// ☆☆☆☆
		// ☆☆☆
		// ☆☆
		// ☆
		
		int lineNumber = 5;
		for(int i = 0; i < lineNumber; i++) {
			for(int j = 0; j < lineNumber - i; j++) {
				System.out.print("☆");
			}
			System.out.println();

	    }
		
		
		for(int i = lineNumber; i >0; i--) {
			for(int j = 1; j <= i; j++) {
				System.out.print("☆");
			}
			System.out.println();

	    }
		
		for(int i = 0; i < lineNumber; i++) {
			for(int j = lineNumber; j > i; j--) {
				System.out.print("☆");
			}
			System.out.println();

	    }
		
		

	}

}
