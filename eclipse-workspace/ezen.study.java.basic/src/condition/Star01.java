package condition;

public class Star01 {

	public static void main(String[] args) {
		//별그리기
		
		for(int a = 1; a <=5; a++) {
			for(int b = 1; b <= a; b++) {
				System.out.print("☆");
			}
			System.out.println();
		}
		
		int line = 1;
		while(line <= 5) {
			int j = 1;
			while(j <= line) {
				j++;
				System.out.print("☆");
			}
			System.out.println();
			line++;
		}

	}

}
