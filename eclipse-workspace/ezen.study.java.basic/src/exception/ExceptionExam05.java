package exception;

public class ExceptionExam05 {

	public static void main(String[] args) {
		
		try {
			Exception e = new Exception("고의로 예외를 발생했습니다.");
			throw e;
		} catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		System.out.println("프로그램이 정상적으로 종료되었습니다.");

	}

}
