package sec01.ex01;

import java.sql.Connection; 
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

//---------------------------------------------------------------------
public class MemberDAO { //회원테이블을 access 하는 객체
	
	//private static final String driver = "oracle.jdbc.driver.OracleDriver"; (Oracle)
	//private static final String url = "jdbc:oracle:thin:@localhost:1521:XE;
	private static final String driver = "com.mysql.cj.jdbc.Driver"; //(MySQL)
	private static final String url = "jdbc:mysql://localhost:3306/jspdb?serverTimezone=Asia/Seoul&useSSL=false";
	private static final String user = "scott";
	private static final String pwd = "tiger";
	
	private Connection conn;
	private Statement stmt;
	
	//DB 연결하는 메소드
	private void connectionDB() {
		
		try {
			Class.forName(driver);
			System.out.println("MySQL Driver 로딩 성공");
			
			conn = DriverManager.getConnection(url, user, pwd);
			System.out.println("Connection 생성 성공");
			
			stmt = conn.createStatement();
			System.out.println("Statement 생성 성공");
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	//회원목록을 추출하는 메소드
	public List<MemberVO> listMembers() {
		
		List<MemberVO> list = new ArrayList<MemberVO>(); //ArrayList : Collection 프레임워크의 일부이며 java.util 패키지에 소속되어있다.
																	 //List 인터페이스에서  상속받아서 사용한다.
		
		try {
			//DB를 연결하고
			connectionDB();
			//모든 정보를 추출하자
			String query = "SELECT * FROM t_member";
			ResultSet rs = stmt.executeQuery(query);
			
			while(rs.next()) { // 다음줄에 데이터가 있을 때(첫번째 줄은 column이다)
				String id = rs.getString("id");
				String pwd = rs.getString("pwd");
				String name = rs.getString("name");
				String email = rs.getString("email");
				Date joinDate = rs.getDate("joinDate");
				MemberVO memberVO = new MemberVO();
				memberVO.setId(id);
				memberVO.setPwd(pwd);
				memberVO.setName(name);
				memberVO.setEmail(email);
				memberVO.setJoinDate(joinDate);
				list.add(memberVO);
			}
			
			rs.close();
			stmt.close();
			conn.close();
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		return list;
	}

}
//---------------------------------------------------------------------