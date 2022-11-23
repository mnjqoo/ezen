package exception;

public class ExceptionExam06 {
	public static void main(String[] args) {
		
		try {
			throw new Exception("예외를 강제로 발생시켰습니다."); // Exception을 강제로 발생시킨다.
		} catch (Exception e) {
			System.out.println("예외를 처리합니다.");
			e.getMessage();
			e.printStackTrace();
		}
		System.out.println("try - catch 문이 모두 끝났습니다.");
	}
}
