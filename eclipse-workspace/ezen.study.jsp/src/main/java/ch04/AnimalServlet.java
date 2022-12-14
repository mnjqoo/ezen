package ch04;

import java.io.*;
import javax.servlet.ServletException;
import javax.servlet.http.*;

public class AnimalServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//전 페이지에서 넘겨준 음식 정보를 가져다 변수에 저장한다.
		String food = req.getParameter("FOOD");
		
		//세션을 생성해서 전 페이지에서 넘겨준 정보를 세션에 저장한다.
		HttpSession session = req.getSession();
		session.setAttribute("FOOD", food); //session.setAttribute(속성명, 값);
		
		resp.setContentType("text/html;charset=UTF-8");
		PrintWriter out = resp.getWriter();
		
		out.println("<html>");
			out.println("<head>");
				out.println("<title>내가 좋아하는 동물</title>");
			out.println("</head>");
			out.println("<body>");
				out.println("<h1>좋아하는 동물은 무엇인가요?</h1>");
				out.println("<form action='/ptest/result'>");
					out.println("<input type='text' name='ANIMAL'/><br/><br/>");
					out.println("<input type='reset' value='다시입력'/>");
					out.println("<input type='submit' value='확인'/>");
				out.println("</form>");
			out.println("</body>");
		out.println("</html>");
	}

}
