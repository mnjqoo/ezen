package condition;

public class Star06 {

	public static void main(String[] args) {
		/* X자 모양으로별 그리기 
			★☆☆☆★
			☆★☆★☆
			☆☆★☆☆
			☆★☆★☆
			★☆☆☆★
		*/
		int lineNumber = 5;
		
		for(int row = 0; row < lineNumber; row++) {
			for(int col = 0; col < lineNumber; col++) {
				if(row == col) {
					System.out.print("★");
				} else if(row + col == lineNumber-1) {
					System.out.print("★");
				} else {
					System.out.print(" ");
				}
			}
			System.out.println();
		}
		
		System.out.println("=========================================");
		for(int row = 0; row < lineNumber; row++) {
			for(int col = 0; col < lineNumber; col++) {
				if(row == col || row + col == lineNumber-1) {
					System.out.print("★");
				} else {
					System.out.print(" ");
				}
			}
			System.out.println();
		}
		
		// X자 모양으로별 그리기
		System.out.println("=========================================");
		for(int row = 1; row <= lineNumber; row++) {
			for(int col = 1; col <= lineNumber; col++) {
				if(row == col || row + col == lineNumber+1) { // [1][5] [2][4]
					System.out.print("★");
				} else {
					System.out.print(" ");
				}
			}
			System.out.println();
		}
		
		
		
		

	}

}
