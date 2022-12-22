package sec02.ex02;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/member22")
public class MemberServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
       
    public MemberServlet() {
       
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doHandle(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doHandle(request, response);
	}
	
	private void doHandle(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException { 
		//get or post 방식으로 member22로 요청이 오면 모두 처리하는 메소드 
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		MemberDAO memberDAO = new MemberDAO();
		
		//어떤 작업을 해야하는지 파라미터에서 넘겨준 값을 비교해서 처리한다.
		String command = request.getParameter("command");
		if(command != null && command.equals("addMember")) { //회원가입인 경우
			System.out.println("회원정보 등록");
			//회원가입 화면에서 넘어온 정보를 MemberVO 객체에 담아서
			String id = request.getParameter("id");
			String pwd = request.getParameter("pwd");
			String name = request.getParameter("name");
			String email = request.getParameter("email");
			
			MemberVO memberVO = new MemberVO();
			memberVO.setId(id);
			memberVO.setPwd(pwd);
			memberVO.setName(name);
			memberVO.setEmail(email);
			
			//MemberDAO에 있는 메소드를 이용하여 회원정보를 등록한다.
			memberDAO.addMember(memberVO);
			
		} else if(command != null && command.equals("delMember")) { //회원삭제일 경우
			String id = request.getParameter("id");
			//아이디를 넘겨주어 탈퇴하는 메소드를 호출한다.
			memberDAO.delMember(id);
		} else if(command != null && command.equals("updateMember")) { //회원정보 수정일 경우
			System.out.println("회원정보수정");
			String id = request.getParameter("id");
			String pwd = request.getParameter("pwd");
			String name = request.getParameter("name");
			String email = request.getParameter("email");
			
			MemberVO memberVO = new MemberVO();
			memberVO.setId(id);
			memberVO.setPwd(pwd);
			memberVO.setName(name);
			memberVO.setEmail(email);
			System.out.println(memberVO.toString());
			memberDAO.updateMember(memberVO);
			
		}
		
		//회원 목록을 가져온다.
		List<MemberVO> list = memberDAO.ListMembers();
		
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
				out.print("<td><a href='/sec02/ex02/memberUpdateForm.jsp?id=" + id  + "'>수정</a></td>");
				out.print("<td><a href='/member22?command=delMember&id=" + id  + "'>탈퇴</a></td>");
			out.print("</tr>");	
			}
		out.print("</table>");
		out.print("<a href='/sec02/ex02/memberForm.html'>새 회원 등록하기</a>");
		out.print("</body>");
		out.print("</html>");
	}


	
}
