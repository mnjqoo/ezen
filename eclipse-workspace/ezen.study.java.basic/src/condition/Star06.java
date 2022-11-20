package condition;

public class Star06 {

	public static void main(String[] args) {
		// ★☆☆☆★
		// ☆★☆★☆
		// ☆☆★☆☆
		// ☆★☆★☆
		// ★☆☆☆★
		int lineNumber = 7;
	    for (int i = 0; i < lineNumber; i++) {
	    	for(int j = 1; j <= lineNumber ; j++) {
	    		if(j == i + 1 || j == lineNumber - i) {
	    			System.out.print("★");
	    		} else {
	    			System.out.print("☆");
	    		}
	    	}
	    	System.out.println();	    	
	    }
	    System.out.println();	
	    
	    for(int i = 0; i < lineNumber; i++) {
	    	for(int j = 0; j < lineNumber; j++) {
	    		if(i == j || i + j == lineNumber - 1 ) {
	    			System.out.print("★");
	    		} else {
	    			System.out.print("☆");
	    		}
	    	}
	    	System.out.println();
	    }
		

	}

}
