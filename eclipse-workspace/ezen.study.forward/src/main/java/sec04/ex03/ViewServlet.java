package sec04.ex03;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/viewMembers")
public class ViewServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		
		List membersList = (List) request.getAttribute("memberList");
		
		//회원 목록을 보여준다.
			out.print("<html>");
			out.print("<body>");
			out.print("<table border=1>");
				out.print("<tr align='center' bgcolor='lightgreen'>");
					out.print("<td>아이디</td>");
					out.print("<td>비밀번호</td>");
					out.print("<td>이 름</td>");
					out.print("<td>이메일</td>");
					out.print("<td>가입 일자</td>");
					out.print("<td>수정</td>");
					out.print("<td>탈퇴</td>");
				out.print("</tr>");
				
				for(int i = 0; i < membersList.size(); i++) {
					MemberVO memberVO = (MemberVO) membersList.get(i);
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
					//out.print("<td><a href='/sec02/ex02/memberUpdateForm.jsp?id=" + id  + "'>수정</a></td>");
					//out.print("<td><a href='/member22?command=delMember&id=" + id  + "'>탈퇴</a></td>");
				out.print("</tr>");	
				}
			out.print("</table>");
			//out.print("<a href='/sec02/ex02/memberForm.html'>새 회원 등록하기</a>");
			out.print("</body>");
			out.print("</html>");
	}

	
}
