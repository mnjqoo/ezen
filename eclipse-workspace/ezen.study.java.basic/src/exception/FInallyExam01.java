package exception;

public class FInallyExam01 {

	public static void main(String[] args) {
		System.out.println(1);
		
		System.out.println(2);
		
		try {
			System.out.println(3);
			System.out.println(0/0);
			System.out.println(4);
		} catch(Exception e) {
			System.out.println(5);
		} finally {
			System.out.println("finally가 실행됩니다.");
		}
		System.out.println(6);
	}

}
