package exception;

import java.io.FileOutputStream;
import java.io.PrintStream;

public class ExceptionExam08 {
	
	public static void main(String[] args) {
		
		PrintStream ps = null;
		FileOutputStream fos = null;
		try {
			
		} catch (Exception e) {
			e.printStackTrace(ps);
			//화면 대신에 error.log 파일에 출력을 하도록 한다.
			ps.println("에외 메시지: " + e.getMessage());
		}
		System.out.println("프로그램을 종료합니다.");
	}
}
