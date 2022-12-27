package sec04.ex02;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/first42")
public class FirstServlet extends HttpServlet{//HttpServletRequest를 이용한 dispatcher 포워딩시 바인딩
											  //서블릿에서 서블릿 또는 jsp로 대량의 데이터를 공유하거나 전달하고 싶을 때는 binding 기능을  사용한다.
											  //웹 프로그램 실행 시 자원(데이터)을 서블릿 관련 객체에 저장하는 방법.
	private static final long serialVersionUID = 1L; 

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		request.setAttribute("address", "서울특별시 종로구 관철동");//웹 브라우저의 첫 요청을 request에 바인딩한다.
		RequestDispatcher dispatcher = request.getRequestDispatcher("second42");//바인딩 된 요청을 다시 두번째 서블릿으로 바인딩한다.
		dispatcher.forward(request, response);
	}

	
}
