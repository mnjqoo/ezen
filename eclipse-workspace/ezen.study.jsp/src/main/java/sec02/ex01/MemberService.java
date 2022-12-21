package sec02.ex01;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/member21")
public class MemberService extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		MemberDAO memberDAO = new MemberDAO();
		
List<MemberVO> list = memberDAO.listMembers();
		
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
