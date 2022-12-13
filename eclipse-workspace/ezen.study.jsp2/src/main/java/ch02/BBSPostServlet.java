package ch02;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.*;

public class BBSPostServlet extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String name = req.getParameter("NAME");
		String title = req.getParameter("TITLE");
		String content = req.getParameter("CONTENT");
		System.out.println(name + title + content);
		
		resp.setContentType("text/html;charset=UTF-8");
		PrintWriter out = resp.getWriter();
		out.println("<html>");
		out.println("<head>");		
			out.println("<title>게시글 등록 결과 화면</title>");					
		out.println("</head>");		
		out.println("<body>");		
			out.printf("<h1>이름: %s</h1>", name);
			out.printf("<h1>제목: %s</h1>", title);
			out.printf("------------------------");
			out.printf("<pre>%s</pre>", content);
			out.printf("------------------------");
			out.printf("게시글을 등록하였습니다.");
		out.println("</body>");		
		out.println("<html>");
	}

	
}
