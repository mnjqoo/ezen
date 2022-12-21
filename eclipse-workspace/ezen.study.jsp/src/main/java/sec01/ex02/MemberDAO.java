package sec01.ex02;

import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;


public class MemberDAO {
	
	private static final String driver = "com.mysql.cj.jdbc.Driver";
	private static final String url = "jdbc:mysql://127.0.0.1:3306/jspdb?serverTimezone=Asia/Seoul&useSSL=false";
	private static final String user = "scott";
	private static final String pwd = "tiger";
	
	private Connection conn;
	private PreparedStatement pstmt;
	
	private void connectionDB() {//DB 접속 메소드
		
		try {
			Class.forName(driver);			
			System.out.println("MySQL Driver Loading....");
			
			conn = DriverManager.getConnection(url, user, pwd);
			System.out.println("DB Connection Success....");
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public List<MemberVO> listMembers() { //회원 목록 추출하기
		
		List<MemberVO> list = new ArrayList<MemberVO>();
		
		try {
			connectionDB();
			String query = "SELECT * FROM t_member ORDER BY name";
			pstmt = conn.prepareStatement(query);//쿼리문을 넣는다.
			ResultSet rs =  pstmt.executeQuery(); //쿼리문을 실행해 결과를 얻는다.
			
			while(rs.next()) {
				MemberVO memberVO = new MemberVO();
				
				memberVO.setId(rs.getString("id"));
				memberVO.setPwd(rs.getString("pwd"));
				memberVO.setName(rs.getString(3));
				memberVO.setEmail(rs.getString(4));
				memberVO.setJoinDate(rs.getDate("joinDate"));
				
				list.add(memberVO); //데이터 1건에 대한 작업이 끝날 때 마다 list에 올린다.
			}
			
			rs.close();
			pstmt.close();
			conn.close();
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		return list;
	}
}
