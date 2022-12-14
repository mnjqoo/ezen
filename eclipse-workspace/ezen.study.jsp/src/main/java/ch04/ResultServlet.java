package ch04;

import java.io.*;

import javax.servlet.ServletException;
import javax.servlet.http.*;

public class ResultServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		//넘겨받은 세션을 사용할 준비를 한다.
		HttpSession session = req.getSession();
		
		//넘겨받은 세션값과 input값을 변수에 저장한다. session값은 object타입이기 때문에 형변환을 해야한다.
		String food = (String) session.getAttribute("FOOD");
		String animal = req.getParameter("ANIMAL");
		
		//세션을 없앤다.
		session.invalidate();
		
		resp.setContentType("text/html;charset=UTF-8");
		PrintWriter out = resp.getWriter();
		
		out.println("<html>");
		out.println("<head>");
			out.println("<title>성격 테스트</title>");			
		out.println("</head>");
		out.println("<body>");
			out.println("<h1>내가 좋아하는 것들</h1>");
			out.printf("<h2>당신은 %s와 %s을 좋아하는 성격입니다.</h2>", food, animal);
		out.println("</body>");
		out.println("</html>");
	}
	
	
}
