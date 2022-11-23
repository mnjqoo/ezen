package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

//--------------------------------------------------------------------------
public class DBConnection { // DB 접속 클래스

	public static Connection getConnection() { // DB에 접속한 정보를 가져오는 method
		Connection conn = null;
		try {
			String url = "jdbc:mysql://localhost:3306/scott?serverTimezone=Asia/Seoul&useSSL=false";
			String user = "scott";
			String pass = "tiger";
			
			Class.forName("com.mysql.cj.jdbc.Driver"); // 1. Driver를 loading 한다.
			conn = DriverManager.getConnection(url, user, pass);// 2. DB에 접속한다.
			System.out.println("Database에 연결이 되었습니다.");
		} catch(ClassNotFoundException cnfe) {
			System.out.println("DB Driver Loading Failed :" + cnfe.toString());
		} catch(SQLException sqle) {
			System.out.println("DB 접속 실패 : " + sqle.toString());
		} catch(Exception e) {
			System.out.println("Unknown Error...");
			e.printStackTrace();
		}
		
		return conn; // 접속된 정보를 반환한다.
	}
}
//--------------------------------------------------------------------------