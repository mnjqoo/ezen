package sec04.ex03;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/member43")
public class MemberServlet extends HttpServlet{//두 서블릿 간에 회원 정보 조회 바인딩하기.

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doHandle(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doHandle(request, response);
	} 
	
	protected void doHandle(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		
		MemberDAO memberDAO = new MemberDAO();
		List memberList = memberDAO.listMembers();
		
		request.setAttribute("memberList", memberList); //조회한 회원 목록을 ArrayList 객체로 request에 바인딩한다.
		RequestDispatcher dispatcher = request.getRequestDispatcher("viewMembers");
		dispatcher.forward(request, response);
	}
}
