package db;

import java.sql.*;

//--------------------------------------------------------------------------
public class ScottSelectEmp { // Scott Schema에 있는 emp 테이블의 정보를 가져오는 클래스

	public static void main(String[] args) {
		
		Connection conn = null; // DB에 연결된 상태(세션)을 담을 객체
		PreparedStatement pstmt = null; // sql문을 나타내는 객체
		ResultSet rs = null; //query문을  실행할 결과를 담을 객체
		
		try {
			String sql = "SELECT * FROM emp ORDER BY empno"; //물어보고 싶은 정보의 질문을 준비한다.
			
			conn = DBConnection.getConnection(); //드라이버를 로딩하고, db에 접속한다.
			pstmt = conn.prepareStatement(sql);// 커넥션을 맺은 곳에 질문할 준비를 한다.
			rs = pstmt.executeQuery();//준비한 질문을 실행시키고, 결과값을 resultSet에 넣는다.
			System.out.println("EMPNO\tENAME\tJOB\tMGR\tHIREDATE\tSAL\tCOMM\tDEPTNO"); // 찾은 정보를 화면에 보여준다.
			System.out.println("===============================================================================");
			while(rs.next()) { // 다음줄에 데이터가 있을 때(첫번째 줄은 column이다)
				int empno = rs.getInt("empno"); //column명을 쓸 수도
				String ename = rs.getString(2); // 몇번째 column인지를 쓸 수도 있다.
				String job = rs.getString("job");
				int mgr = rs.getInt(4);
				Date hiredate = rs.getDate(5);
				int sal = rs.getInt(6);
				int comm = rs.getInt(7);
				int deptno = rs.getInt(8);
				
				String result = empno + "\t" +ename + "\t" + job + "\t" + mgr + "\t" + hiredate + "\t" + sal + "\t" + comm + "\t" + deptno;
				System.out.println(result);
			}
		} catch(SQLException sqle) {
			System.out.println("SELECT문에서 예외가 발생했습니다.");
		} finally { // DB 연결을 종료하기 전에 열려진 자원을 닫는다.
			try {
				if(rs != null) {rs.close();}
				if(pstmt != null) {pstmt.close();}
				if(conn != null) {conn.close();}
			} catch(Exception e) {
				throw new RuntimeException(e.getMessage());
			}
		}
	}

}
//--------------------------------------------------------------------------