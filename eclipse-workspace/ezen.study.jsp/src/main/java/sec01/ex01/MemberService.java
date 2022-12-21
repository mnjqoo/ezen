package sec01.ex01;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//---------------------------------------------------------------------
@WebServlet("/member11")
public class MemberService extends HttpServlet{ //회원정보 테이블의 회원정보 조회하기

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		
		PrintWriter out = response.getWriter();
		MemberDAO dao = new MemberDAO();
		
		//MemberDAO에서 회원목록을 가져와서 
		List<MemberVO> list = dao.listMembers();
		//화면에 출력한다.
		
		out.print("<html>");
		out.print("<body>");
		out.print("<table border=1>");
			out.print("<tr align='center' bgcolor='lightgreen'>");
				out.print("<td>아이디</td>");
				out.print("<td>비밀번호</td>");
				out.print("<td>이 름</td>");
				out.print("<td>이메일</td>");
				out.print("<td>가입 일자</td>");
			out.print("</tr>");
			
		for(int i = 0; i < list.size(); i++) {
			//가져온 데이터를 한 건씩 처리한다.
			MemberVO memberVO = (MemberVO) list.get(i);
			String id = memberVO.getId();
			String pwd = memberVO.getPwd();
			String name = memberVO.getName();
			String email = memberVO.getEmail();
			Date joinDate = memberVO.getJoinDate();
			out.print("<tr>");
				out.print("<td>" + id + "</td>");
				out.print("<td>" + pwd + "</td>");
				out.print("<td>" + name + "</td>");
				out.print("<td>" + email + "</td>");
				out.print("<td>" + joinDate + "</td>");
			out.print("</tr>");		
		}
			
		out.print("</table>");
		out.print("</body>");
		out.print("</html>");
	}

		
}
//---------------------------------------------------------------------