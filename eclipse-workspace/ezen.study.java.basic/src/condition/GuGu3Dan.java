package condition;

public class GuGu3Dan {

	public static void main(String[] args) {
		// 구구단
		for(int x = 2; x < 10; x++) {
			for(int y = 1; y < 10; y++) {
				System.out.print(x + "x" + y + "=" + (x*y) + "\t");
			}
			System.out.println();
		}
		System.out.println("========================================================================");
		
		//구구단을 출력하는데 1, 2, 3단 출력 4, 5, 6단 출력 7, 8, 9단 순으로 출력해주세요.
		for(int x = 1; x < 10; x++) {
			for(int y = 1; y < 4; y++) {
				System.out.print(y + "x" + x + "=" + (x*y) + "\t");
			}
			System.out.println();
		}
		System.out.println("========================================================================");
		for(int x = 1; x < 10; x++) {
			for(int y = 4; y < 7; y++) {
				System.out.print(y + "x" + x + "=" + (x*y) + "\t");
			}
			System.out.println();
		}
		System.out.println("========================================================================");
		for(int x = 1; x < 10; x++) {
			for(int y = 7; y < 10; y++) {
				System.out.print(y + "x" + x + "=" + (x*y) + "\t");
			}
			System.out.println();
		}
		System.out.println("========================================================================");

	} // End -public static void main(String[] args) 

} // End - public class GuGu3Dan
