package sec04.ex01;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/first41")
public class FirstServlet extends HttpServlet{//HttpServletRequest를 이용한 redirect 포워딩시 바인딩
											  //서블릿에서 서블릿 또는 jsp로 대량의 데이터를 공유하거나 전달하고 싶을 때는 binding 기능을  사용한다.
											  //웹 프로그램 실행 시 자원(데이터)을 서블릿 관련 객체에 저장하는 방법.
	private static final long serialVersionUID = 1L; 

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		request.setAttribute("address", "서울특별시 종로구 관철동"); //웹 브라우저의 첫 요청을 request에 바인딩한다.
		response.sendRedirect("second41");
	}

	
}
