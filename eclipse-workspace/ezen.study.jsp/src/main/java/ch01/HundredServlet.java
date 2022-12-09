package ch01;

import javax.servlet.http.*;
import java.io.*;
import javax.servlet.*;

//--------------------------------------------------------------------
public class HundredServlet extends HttpServlet{

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
		
		int result = 0; //1부터 100까지 더한 값을 저장할 변수
		for(int i = 0; i <= 100; i++) {
			result += i;
		}
		
		//화면에 출력하는 부분
		response.setContentType("text/html;charset=UTF-8"); //컨텐츠의 타입을 설정한다.
		PrintWriter out = response.getWriter(); //
		
		out.println("<html>");
		out.println("<head>");		
			out.println("<title>1부터 100까지 더하는 서블릿</title>");					
		out.println("</head>");		
		out.println("<body>");		
			out.printf("<h1>1부터 100까지 더한 값은 %d 입니다.</h1>", result); //%d : 정수형 printf("", 값);
		out.println("</body>");		
		out.println("<html>");
	}
}
//--------------------------------------------------------------------