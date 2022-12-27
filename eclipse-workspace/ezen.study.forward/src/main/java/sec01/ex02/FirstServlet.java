package sec01.ex02;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/first12")
public class FirstServlet extends HttpServlet{

	private static final long serialVersionUID = 1L; //Refresh를 이용한 포워딩하기

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		response.addHeader("Refresh", "1;url=second12"); //웹 브라우저에 1초 후 second12로 재요청한다.
	}

	
}
