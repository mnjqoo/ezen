package sec04.ex01;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/second41")
public class SecondServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		String address = (String) request.getAttribute("address");
		
		
		out.println("<html>");
			out.println("<body>");
				out.println("<h1>setAttribute를 이용한 redirec 바인딩 방식입니다.</h1>");
				out.println("<h1>주소: " + address + "</h1>");
			out.println("</body>");
		out.println("</html>");
		//주소 : null 이 출력된다.
		//첫번째 request와 세번째 request는 다른 요청이다.
		//redirect는 서블릿에서 바인딩한 데이터를 다른 서버로 전송해주지 않는다.
	}
	
	
}
