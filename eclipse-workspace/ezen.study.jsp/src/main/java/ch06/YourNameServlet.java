package ch06;

import java.io.*;
import java.util.GregorianCalendar;

import javax.servlet.ServletException;
import javax.servlet.http.*;

public class YourNameServlet extends HttpServlet{
	
	private PrintWriter logFile;
	
	
	@Override
	public void init() throws ServletException {
		
		try {
			logFile = new PrintWriter(new FileWriter("c:\\data\\log.txt", true));
		} catch (IOException e) {
			throw new ServletException(e);
		}
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		//로그인한 시간과 이름을 logFile에 기록한다.
		String name = req.getParameter("NAME");
		
		if(logFile != null) {
			GregorianCalendar now = new GregorianCalendar();
			logFile.printf("%TF %TT - %s %n", now, now, name);
		}
		
		//환영 메세지를 화면에 출력한다.
		String greeting = "안녕하세요?" + name + "님 오랜만에 뵙습니다.";
		resp.setContentType("text/html;charset=UTF-8");
		PrintWriter out = resp.getWriter();
		
		out.println("<html>");
			out.println("<head>");
				out.println("<title>환영 인사말</title>");
			out.println("</head>");
			out.println("<body>");
				out.println("<h1>환영인사</h1>");
				out.print("<h2>");
					out.println(greeting);
				out.print("</h2>");
			out.println("</body>");
		out.println("</html>");
	}

	@Override
	public void destroy() { //끝날때
		System.out.println("방문해주셔서 감사합니다. \n조심히 들어가십시오.");
		if(logFile != null) {
			logFile.close(); //열려져 있는 자원을 닫는다.
		}
	}

	
	
}
