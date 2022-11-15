package condition;

public class Star01 {

	public static void main(String[] args) {

		/* 별그리기
		★
		★★
		★★★
		★★★★
		*/
		for(int line = 1; line <= 5; line++ ) {
			for(int j = 0; j < line; j++) {
				System.out.print("★");
			}
			System.out.println();
		}
		
		int line = 1;
		while(line <= 5) {
			int j = 0;
			while(j < line) {
				System.out.print("★");
				j++;
			}
			System.out.println();
			line++;
		}
	}

}






