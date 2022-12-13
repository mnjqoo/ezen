package ch02;

import java.io.*;

import javax.servlet.ServletException;
import javax.servlet.http.*;

//--------------------------------------------------------------------
public class AdderServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		//두개의 숫자를 받아서 더한 결과를 화면에 보여주자.
		
		//req로 받는 변수는 대소문자를 구분한다. 값들은 문자열로 넘어온다.
		String str1 = req.getParameter("NUM1");
		String str2 = req.getParameter("NUM2");
		
		System.out.println(str1 + ":" + str2);
		
		//웹페이지로부터 넘겨받은 문자열을 숫자로 바꾼후 더해준다.
		int num1 = Integer.parseInt(str1);
		int num2 = Integer.parseInt(str2);
		int sum = num1 + num2;
		
		//결과를 화면에 보여준다.
		resp.setContentType("text/html;charset=UTF-8");
		PrintWriter out = resp.getWriter();
		out.println("<html>");
		out.println("<head>");		
			out.println("<title>더하기 Servlet</title>");					
		out.println("</head>");		
		out.println("<body>");		
			out.printf("<h1>%d와 %d를 더한 값은 %d 입니다.</h1>",num1, num2, sum);
		out.println("</body>");		
		out.println("<html>");
	}
	
	
}
//--------------------------------------------------------------------