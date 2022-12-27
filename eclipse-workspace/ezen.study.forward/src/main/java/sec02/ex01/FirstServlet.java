package sec02.ex01;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/first21")
public class FirstServlet extends HttpServlet{

	private static final long serialVersionUID = 1L; //redirect를 이용한 포워딩하기

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();

		//get 방식을 이용하여 이름/값의 쌍으로 데이터를 다른 서블릿에 전달한다.
		//refresh나 location도 역시 get 방식을 이용해서 다른 서블릿으로 데이터를 전달 할 수 있다.
		response.sendRedirect("second21?name=HongGildong");
		
	}

	
}
