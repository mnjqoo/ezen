package exception;

public class FInallyExam04 {

	public static void main(String[] args) {
		FInallyExam04.method();
		System.out.println("method() 메소드를 실행하고 main() 메소드로 돌아왔습니다.");
	}
	
	static void method() {
		try {
			System.out.println("mothod()가 호출되었습니다.");
			return;
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			System.out.println("method()의 finally블럭이 실행되었습니다.");
		}
	}
	
}
