package sec04.ex03;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class MemberDAO {
	
	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;
	private DataSource dataFactory;
	
	public MemberDAO() { //생성자 호출 시 데이터에 연결한다.
		
		try {
			Context ctx = new InitialContext();
			Context env = (Context) ctx.lookup("java:/comp/env");
			dataFactory = (DataSource) env.lookup("jdbc/mysql");
			
			System.out.println("MemberDAO가 호출되었습니다.");
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	public List listMembers() {
		
		List list = new ArrayList();
		String query = "";
		
		try {
			conn = dataFactory.getConnection(); //작업할 DB에 접속한 정보를 가져온다.
			query = "SELECT * FROM t_member ORDER BY id"; //query문 준비
			pstmt = conn.prepareStatement(query); //query문 넣기
			rs = pstmt.executeQuery(); //결과값 받기
			System.out.println(pstmt.toString());
			
			while(rs.next()) {
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
		} catch(Exception e) {
			e.printStackTrace();
		}
		return list;
	}
}
