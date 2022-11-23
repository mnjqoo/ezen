package exception;

public class ExceptionExam09 {
	public static void main(String[] args) {
		
		System.out.println(1);
		System.out.println(2);
		
		try {
			System.out.println(3);
			System.out.println(0/0);
			System.out.println(4);
		} catch(ArithmeticException ae) {
			System.out.println("수학적인 예외가 발생하였습니다");
			//ae.getMessage(); : 발생한 예외클래스의 인스턴스에 저장된 메세지를 얻을 수 있다.
			//ae.printStackTrace(); : 예외 발생 당시의 호출스택(Call Stack)에 있었던 메소드의 정보와 예외 메세지를 화면에 출력한다.
		} catch(Exception e) {
			System.out.println("예외가 발생하였습니다.");
		}
		System.out.println(6);
	}
}
