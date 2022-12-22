package sec02.ex02;

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

	String query = "";
		String id;
		String pwd;
		String name;
		String email;
		Date joinDate;
	
	private DataSource dataFactory;
	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	public MemberDAO() { //생성자를 통해서 작업할 Schema를 준비해놓는다.
		try {
			Context ctx = new InitialContext();
			Context env = (Context) ctx.lookup("java:/comp/env");
			dataFactory = (DataSource) env.lookup("jdbc/mysql"); //context.xml 에 등록해놓은 이름
			
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	
	public List<MemberVO> ListMembers() {
		
		List<MemberVO> list = new ArrayList<MemberVO>();
		
		try {
			conn = dataFactory.getConnection(); //DB접속
			query = "SELECT * FROM t_member "; //쿼리문 준비
			query += "ORDER BY id"; //띄어쓰기 주의
			
			pstmt = conn.prepareStatement(query); //쿼리문을 넣어서 질문할 준비
			rs = pstmt.executeQuery(); //쿼리 실행
			
			while(rs.next()) {
				id = rs.getString("id");
				pwd = rs.getString("pwd");
				name = rs.getString(3);
				email = rs.getString(4);
				joinDate = rs.getDate("joinDate");
				
				MemberVO memberVO = new MemberVO();
				memberVO.setId(id);
				memberVO.setPwd(pwd);
				memberVO.setName(name);
				memberVO.setEmail(email);
				memberVO.setJoinDate(joinDate);
				
				list.add(memberVO);
			}
			rs.close();
			pstmt.close();
			conn.close();
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		return list;
	}
	
	public void addMember(MemberVO memberVO) {
		
		try {
			conn = dataFactory.getConnection();
			
			id = memberVO.getId();
			pwd = memberVO.getPwd();
			name = memberVO.getName();
			email = memberVO.getEmail();
			
			query = "INSERT INTO t_member ";
			query += "(id, pwd, name, email) ";
			query += "VALUES(?, ?, ?, ?)";
			
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, id);
			pstmt.setString(2, pwd);
			pstmt.setString(3, name);
			pstmt.setString(4, email);
			pstmt.executeUpdate();
			System.out.println(pstmt.toString());
			pstmt.close();
			conn.close();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void delMember(String id) {
		
		try {
			conn = dataFactory.getConnection();
			
			query = "DELETE FROM t_member WHERE id=?";
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, id);
			pstmt.executeUpdate();
			System.out.println("회원삭제");
			
			pstmt.close();
			conn.close();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public MemberVO getMember(String id) {
		
		MemberVO memberVO = new MemberVO();
		try {
			conn = dataFactory.getConnection();
			
			query = "SELECT * FROM t_member WHERE id=?";
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, id);
			pstmt.execute();
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				memberVO.setId(rs.getString("id"));
				memberVO.setPwd(rs.getString("pwd"));
				memberVO.setName(rs.getString("name"));
				memberVO.setEmail(rs.getString("email"));
				memberVO.setJoinDate(rs.getDate("joinDate"));
			}
			System.out.println(pstmt.toString());
			rs.close();
			pstmt.close();
			conn.close();
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		return memberVO;
	}
	
	public void updateMember(MemberVO memberVO) {
		
		id = memberVO.getId();
		pwd = memberVO.getPwd();
		name = memberVO.getName();
		email = memberVO.getEmail();
		
		try {
			conn = dataFactory.getConnection();
			
			query ="UPDATE t_member SET pwd=?, name=?, email=? WHERE id=?";
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, pwd);
			pstmt.setString(2, name);
			pstmt.setString(3, email);
			pstmt.setString(4, id);
			pstmt.executeUpdate();
			System.out.println("회원정보 수정 완료");
			
			pstmt.close();
			conn.close();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
}
