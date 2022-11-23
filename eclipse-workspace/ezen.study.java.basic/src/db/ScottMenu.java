package db;

import java.sql.*;
import java.sql.SQLException;
import java.util.Scanner;

public class ScottMenu {
	
	static Scanner keyboard = new Scanner(System.in);
	
	public static void showMenu1() { //테이블 선택
		System.out.println("작업하고자 하는 테이블을 선택하십시오");
		System.out.println("0. 프로그램 종료");
		System.out.println("1. EMP TABLE");
		System.out.println("2. DEPT TABLE");
		System.out.println("3. SALGRADE TABLE");
		System.out.print("선택 >> ");
	}
	
	public static void showMenu2() { //조회, 입력, 수정, 삭제를 선택
		System.out.println("==============================================================");
		System.out.println("수행할 작업을 선택하십시오.");
		System.out.println("0. 메인메뉴");
		System.out.println("1. 조회");
		System.out.println("2. 입력");
		System.out.println("3. 수정");
		System.out.println("4. 삭제");
		System.out.print("선택 >> ");
	}
	
	public static void selectTable(int selectTB) { //선택한 테이블의 모든 정보를 보여주자.
		System.out.println("선택한 테이블: " + ScottManager.fromTable[selectTB - 1]);
		try {
			ScottManager.sql = ""; //초기화
			ScottManager.sql = "SELECT * FROM " + ScottManager.fromTable[selectTB - 1];
			ScottManager.conn = DBConnection.getConnection(); //DB 접속
			ScottManager.pstmt = ScottManager.conn.prepareStatement(ScottManager.sql); //Query문 준비
			ScottManager.rs = ScottManager.pstmt.executeQuery(); //Query문을 실행하고 결과값을 가져온다.
			ScottManager.rsmd = ScottManager.rs.getMetaData(); //Column명들을 가져온다.
			
			System.out.println("==============================================================");
			System.out.println(ScottManager.fromTable[selectTB - 1]);
			System.out.println("==============================================================");
			int cols = ScottManager.rsmd.getColumnCount(); //선택한 테이블의 Column의 개수를 알려준다.
			for(int i = 1; i <= cols; i++) {
				System.out.print(ScottManager.rsmd.getColumnName(i) + "\t"); //Column명을 출력한다.
			}
			System.out.println();
			System.out.println("==============================================================");
			while(ScottManager.rs.next()) { //데이터를 출력한다.
				for(int i = 1; i <= cols; i++) {
					System.out.print(ScottManager.rs.getString(i) + "\t");
				}
				System.out.println(); //1건의 데이터를 화면에 출력하고 나면 줄 바꿈
			}
			System.out.println("==============================================================");
		} catch(SQLException sqle) {
			System.out.println("SELECT문을 실행하는데 문제가 발생하였습니다.");
		} finally { //DB 종료 하기 전에 열려진 자원을 닫는다.
			try {
				if(ScottManager.rs != null) { ScottManager.rs.close(); }
				if(ScottManager.pstmt != null) { ScottManager.pstmt.close(); }
				if(ScottManager.conn != null) { ScottManager.conn.close(); }
			} catch(Exception e) {
				throw new RuntimeException(e.getMessage());
			}
		}
		
	}
	
	public static void insertTable(int selectTB) {
		System.out.println("선택한 테이블: " + ScottManager.fromTable[selectTB - 1]);
		try {
			ScottManager.conn = DBConnection.getConnection(); //DB 접속
			if(selectTB == 1) { 
				System.out.print("사원번호: ");
				int empno = keyboard.nextInt(); keyboard.nextLine();
				System.out.print("이름: ");
				String ename = keyboard.nextLine();
				System.out.print("직책: ");
				String job = keyboard.nextLine();
				System.out.print("매니저번호: ");
				int mgr = keyboard.nextInt(); keyboard.nextLine();
				System.out.print("월급: ");
				int sal = keyboard.nextInt(); keyboard.nextLine();
				System.out.print("커미션: ");
				int comm = keyboard.nextInt(); keyboard.nextLine();
				System.out.print("부서번호: ");
				int deptno = keyboard.nextInt(); keyboard.nextLine();
				
				ScottManager.sql = ""; //초기화
				ScottManager.sql = "INSERT INTO " + ScottManager.fromTable[selectTB - 1] + " VALUES(?, ?, ?, ?, NOW(), ?, ?, ?)";
				ScottManager.pstmt = ScottManager.conn.prepareStatement(ScottManager.sql); //Query문 준비
				ScottManager.pstmt.setInt(1,  empno);
				ScottManager.pstmt.setString(2,  ename);
				ScottManager.pstmt.setString(3,  job);
				ScottManager.pstmt.setInt(4,  mgr);
				ScottManager.pstmt.setInt(5,  sal);
				ScottManager.pstmt.setInt(6,  comm);
				ScottManager.pstmt.setInt(7,  deptno);
			} else if(selectTB == 2) {
				System.out.println("부서번호: ");
				int deptno = keyboard.nextInt(); keyboard.nextLine();
				System.out.println("부서명: :");
				String dname = keyboard.nextLine();
				System.out.println("지역: ");
				String loc = keyboard.nextLine();
				ScottManager.sql = ""; //초기화
				ScottManager.sql = "INSERT INTO " + ScottManager.fromTable[selectTB - 1] + " VALUES(?, ?, ?)";
				ScottManager.pstmt = ScottManager.conn.prepareStatement(ScottManager.sql); //Query문 준비
				ScottManager.pstmt.setInt(1,  deptno);
				ScottManager.pstmt.setString(2,  dname);
				ScottManager.pstmt.setString(3,  loc);
			} else if(selectTB == 3) {
				System.out.println("등급: ");
				int grade = keyboard.nextInt(); keyboard.nextLine();
				System.out.println("최저월급: ");
				int losal = keyboard.nextInt(); keyboard.nextLine();
				System.out.println("최대월급: ");
				int hisal = keyboard.nextInt(); keyboard.nextLine();
				ScottManager.sql = ""; //초기화
				ScottManager.sql = "INSERT INTO " + ScottManager.fromTable[selectTB - 1] + " VALUES(?, ?, ?)";
				ScottManager.pstmt = ScottManager.conn.prepareStatement(ScottManager.sql); //Query문 준비
				ScottManager.pstmt.setInt(1,  grade);
				ScottManager.pstmt.setInt(2,  losal);
				ScottManager.pstmt.setInt(3,  hisal);
			}
			//실행 부분은 공동으로 사용
			int resultCount = ScottManager.pstmt.executeUpdate(); //Query문을 실행하고, 데이터 입력, 수정, 삭제가 실행된 건수가 반환된다.
			if(resultCount > 0) {
				System.out.println(resultCount + "건이 입력되었습니다.");
			} else {
				System.out.println("데이터 입력에 실패하였습니다.");
			}
			
		} catch(SQLException sqle) {
			System.out.println("INSERT문을 실행하는데 문제가 발생하였습니다.");
		} finally { //DB 종료 하기 전에 열려진 자원을 닫는다.
			try {
				if(ScottManager.rs != null) { ScottManager.rs.close(); }
				if(ScottManager.pstmt != null) { ScottManager.pstmt.close(); }
				if(ScottManager.conn != null) { ScottManager.conn.close(); }
			} catch(Exception e) {
				throw new RuntimeException(e.getMessage());
			}
		}
	}
	
	public static void updateTable(int selectTB) { //사원번호를 조회  후, 사원의 이름을 수정한다.
		System.out.println("선택한 테이블: " + ScottManager.fromTable[selectTB - 1]);
		try {
			ScottManager.conn = DBConnection.getConnection(); //DB 접속
			if(selectTB == 1) { 
				System.out.print("수정할 사원번호: ");
				int empno = keyboard.nextInt(); keyboard.nextLine();
				System.out.print("이름: ");
				String ename = keyboard.nextLine();
				
				ScottManager.sql = ""; //초기화
				ScottManager.sql = "UPDATE " + ScottManager.fromTable[selectTB - 1] + " SET ENAME = ? WHERE EMPNO = ?";
				ScottManager.pstmt = ScottManager.conn.prepareStatement(ScottManager.sql); //Query문 준비
				ScottManager.pstmt.setString(1,  ename);
				ScottManager.pstmt.setInt(2,  empno);
			
			}
			int resultCount = ScottManager.pstmt.executeUpdate(); //Query문을 실행하고, 데이터 입력, 수정, 삭제가 실행된 건수가 반환된다.
			if(resultCount > 0) {
				System.out.println(resultCount + "건이 입력되었습니다.");
			} else {
				System.out.println("데이터 입력에 실패하였습니다.");
			}
			
		} catch(SQLException sqle) {
			System.out.println("INSERT문을 실행하는데 문제가 발생하였습니다.");
		} finally { //DB 종료 하기 전에 열려진 자원을 닫는다.
			try {
				if(ScottManager.rs != null) { ScottManager.rs.close(); }
				if(ScottManager.pstmt != null) { ScottManager.pstmt.close(); }
				if(ScottManager.conn != null) { ScottManager.conn.close(); }
			} catch(Exception e) {
				throw new RuntimeException(e.getMessage());
			}
		}
	}
	
	public static void deleteTable(int selectTB) {
		System.out.println("선택한 테이블: " + ScottManager.fromTable[selectTB - 1]);
		try {
			ScottManager.conn = DBConnection.getConnection(); //DB 접속
			if(selectTB == 1) { 
				System.out.print("삭제할 사원번호: ");
				int empno = keyboard.nextInt(); keyboard.nextLine();
				
				ScottManager.sql = ""; //초기화
				ScottManager.sql = "DELETE FROM " + ScottManager.fromTable[selectTB - 1] + " WHERE EMPNO = ?";
				ScottManager.pstmt = ScottManager.conn.prepareStatement(ScottManager.sql); //Query문 준비
				ScottManager.pstmt.setInt(1,  empno);
			
			}
			int resultCount = ScottManager.pstmt.executeUpdate(); //Query문을 실행하고, 데이터 입력, 수정, 삭제가 실행된 건수가 반환된다.
			if(resultCount > 0) {
				System.out.println(resultCount + "건이 입력되었습니다.");
			} else {
				System.out.println("데이터 입력에 실패하였습니다.");
			}
			
		} catch(SQLException sqle) {
			System.out.println("INSERT문을 실행하는데 문제가 발생하였습니다.");
		} finally { //DB 종료 하기 전에 열려진 자원을 닫는다.
			try {
				if(ScottManager.rs != null) { ScottManager.rs.close(); }
				if(ScottManager.pstmt != null) { ScottManager.pstmt.close(); }
				if(ScottManager.conn != null) { ScottManager.conn.close(); }
			} catch(Exception e) {
				throw new RuntimeException(e.getMessage());
			}
		}
	}
	
	public static void subMenu(int choice) { //테이블 선택 후 테이블에서 할 수 있는 작업을 선택, 수행
		int choice2; //조회, 입력, 수정, 삭제를 선택할 값을 저장할 변수
		
		while(true) {
			showMenu2();
			choice2 = keyboard.nextInt();
			keyboard.nextLine();
			
			switch(choice2) {
				case 0: return;
				case 1: selectTable(ScottManager.choice1); break;
				case 2: insertTable(ScottManager.choice1); break;
				case 3: updateTable(ScottManager.choice1); break;
				case 4: deleteTable(ScottManager.choice1); break;
				default : System.out.println("올바른 번호를 입력해주세요."); break;
			}
		}
	}
	
	
}
