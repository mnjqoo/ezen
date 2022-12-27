package sec01.ex01;

import java.io.IOException;

import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/first11")
public class FirstServlet extends HttpServlet{

	private static final long serialVersionUID = 1L; //redirect를 이용한 포워딩하기

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		response.sendRedirect("second11"); //redirect는 주소를 바꾼다.
	}

	
}
