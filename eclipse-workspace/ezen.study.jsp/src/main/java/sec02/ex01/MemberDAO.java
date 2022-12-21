package sec02.ex01;

import java.sql.Connection;
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
	private DataSource dataFactory;
	
	public MemberDAO() {
		
		try {
			Context ctx = new InitialContext();
			Context envContext = (Context) ctx.lookup("java:comp/env");
			dataFactory = (DataSource) envContext.lookup("jdbc/mysql");
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public List<MemberVO> listMembers(){
		
		List<MemberVO> list = new ArrayList<MemberVO>();
		
		try {
			conn = dataFactory.getConnection();
			
			//String query = "SELECT * FROM t_member ORDER BY name";
			String query = "SELECT * FROM t_member WHERE id=? AND name=? ORDER BY name";//미완성인 상태
			
			pstmt = conn.prepareStatement(query);//쿼리문을 넣는다.
			pstmt.setString(1, "shim");
			pstmt.setString(2, "심순애");//id가 shim이면서 이름이 심순애
			
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
