package exception;

public class ExceptionExam04 {
	
	public static void main(String[] args) {
		
		System.out.println(1);
		System.out.println(2);
		
		try {
			System.out.println(3);
			System.out.println(0 / 0);
			System.out.println(4); //이 부분은 실행되지않는다.
		} catch(ArithmeticException e) {
			
		} catch(Exception e) {
			System.out.println(5);
		}
		
		System.out.println(6);
	}
}
