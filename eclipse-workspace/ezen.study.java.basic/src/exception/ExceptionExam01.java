package exception;
//============================================================================
public class ExceptionExam01 {

	public static void main(String[] args) {
		int number = 200;
		int result = 0;
		
		//number를 0-9 사이에서 추출한 정수로 나눈 값을 보여준다. (10번 시도)
		for(int i = 0; i < 10; i++) {
			result = number/(int)(Math.random() * 10);
			System.out.println(result);
		}
	}

}
//============================================================================