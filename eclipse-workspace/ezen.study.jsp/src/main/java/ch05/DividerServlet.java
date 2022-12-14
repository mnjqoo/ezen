package ch05;

import java.io.*;
import javax.servlet.ServletException;
import javax.servlet.http.*;

public class DividerServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException { //나누기 메소드
		
		String str1 = req.getParameter("NUM1");
		String str2 = req.getParameter("NUM2");
		
		int num1 = Integer.parseInt(str1);
		int num2 = Integer.parseInt(str2);
		int result = num1 / num2;
		
		//response 처리
		resp.setContentType("text/html;charset=UTF-8");
		PrintWriter out = resp.getWriter();
		out.println("<HTML>");
		out.println("<head>");
		out.println("<title>나눗셈 프로그램</title>");
		out.println("</head>");
		out.println("<body>");
		out.println("<h1>나눗셈 프로그램</h1><hr/>");
		out.printf("%d ÷ %d = %d", num1, num2, result);
		out.println("</body>");
		out.println("</HTML>");
	}
	
	
	
}
