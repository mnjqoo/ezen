package sec04.ex02;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/second42")
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
				out.println("<h1>setAttribute를 이용한 dispatcher 바인딩 방식입니다.</h1>");
				out.println("<h1>주소: " + address + "</h1>");
			out.println("</body>");
		out.println("</html>");
		
	}
	
	
}
