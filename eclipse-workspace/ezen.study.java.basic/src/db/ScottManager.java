package db;

import java.sql.*;
import java.util.*;

public class ScottManager { //scott schema를 관리하는 클래스
	
	static Scanner keyboard = new Scanner(System.in);
	static Connection conn = null; // DB에 연결된 상태(객체)를 담을 객체
	static PreparedStatement pstmt = null; //SQL문을 나타내는 객체
	static ResultSet rs = null; //Query문을 실행한 반환값을 담을 객체
	static ResultSetMetaData rsmd = null; //테이블의 메타데이터를 사용할 객체
	static String sql = ""; //Query문을 저장할 변수
	static String[] fromTable = {"EMP", "DEPT", "SALGRADE"};
	static int choice1 = 0; //선택한 테이블 번호를 저장할 변수
	
	
	public static void main(String[] args) {
		
		
		
		while(true) {
			ScottMenu.showMenu1();
			choice1 = keyboard.nextInt();
			keyboard.nextLine();
			
			switch(choice1) {
				case 0: System.out.println("프로그램을 종료합니다.");
						return;
				case 1: case 2: case 3: ScottMenu.subMenu(choice1); break;
				default : System.out.println("올바른 번호를 입력해주세요."); break;
			}
		}

	}

}
