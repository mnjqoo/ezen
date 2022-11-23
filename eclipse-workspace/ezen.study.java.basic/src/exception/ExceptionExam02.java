package exception;

public class ExceptionExam02 {

	public static void main(String[] args) {
		
		int number = 100; //나누어지는 숫자를 저장할 변수
		int result = 0 ; //나눈 결과를 저장할 변수
		
		for(int i = 0; i < 10; i++) {
			try {
				result = number / (int)(Math.random() * 10);
				System.out.println("[" + (i + 1) + "] 나누기 결과: " + result);
			} catch(ArithmeticException ae) {
				i--;
			}
		}

	}

}
