package exception;

import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.Date;

public class ExceptionExam10 {
	public static void main(String[] args) {
		
		PrintStream ps = null;
		FileOutputStream fos = null;
		try {
			fos = new FileOutputStream("c:\\temp\\error.log", true); //error.log 파일에 출력할 준비를 한다.
			ps = new PrintStream(fos); 
			//System.setErr(ps); // system.err의 출력 방향을 error.log라는 파일로 변경한다.
			System.out.println(1);
			System.out.println(2);
			System.err.println("==================================");
			System.out.println(3);
			System.out.println(0/0);
			System.out.println(4);
		} catch (Exception e) {
			System.err.println("==================================");
			System.err.println("예외발생시간: " + new Date()); //현재 시간 출
			e.printStackTrace(System.err);
			System.err.println("예외메세지: " + e.getMessage());
			System.out.println("-------------------------");
			
		}
		System.out.println("프로그램을 종료합니다.");
	}
}
