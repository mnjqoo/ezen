package ch06;

import javax.servlet.ServletException;
import javax.servlet.http.*;
import java.io.*;
import java.math.*;

public class FibonacciServlet extends HttpServlet{

	private BigInteger arr[];

	@Override
	public void init() throws ServletException { //1과 1로 시작하는 피보나치 수열을 100개 만들어 놓는다.
		
		arr = new BigInteger[100];
		//0, 1번째 방의 값은 먼저 저장한다.
		arr[0] = new BigInteger("1");
		arr[1] = new BigInteger("1");
		
		//2번째 방 부터 반복문을 사용해 값을 저장한다.
		for(int i = 2; i < arr.length; i++) {
			arr[i] = arr[i - 2].add(arr[i - 1]);
		}
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException { //피보나치 수열의 몇번째까지 보여줄 것인지를 받아들인다.
		
		String str = req.getParameter("NUM");
		int num = Integer.parseInt(str);
		
		//100이 넘는 매개변수는 100으로 설정한다.
		if(num > 100) num = 100;
		
		//response 부분
		resp.setContentType("text/html;charset=UTF-8");
		PrintWriter out = resp.getWriter();
		
		//피보나치 수열을 보여준다.
		out.println("<HTML>");
			out.println("<head>");
				out.println("<title>피보나치 수열</title>");
			out.println("</head>");
			out.println("<body>");
				out.println("<h1>피보나치 수열</h1><hr/>");
				out.println("<h2>1과 1로 시작하는 피보나치 수열의 " + num + "번째까지 </h2>");
				out.println("<h3>");
					for(int i = 0; i < num - 1; i++) {
						out.print(arr[i] + ", ");
					}
					out.print(arr[num - 1]);
				out.println("</h3>");
			out.println("</body>");
		out.println("</HTML>");
	}

}
