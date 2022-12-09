package ch02;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.*;

public class PersonalInfoServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		req.setCharacterEncoding("UTF-8"); //파라미터로 넘겨받은 문자열의 언어셋을 처리한다.
		
		String name = req.getParameter("NAME");
		String id = req.getParameter("ID");
		String password = req.getParameter("PASSWORD");
		String gender = req.getParameter("GENDER");
			if(gender.equals("FEMALE")) gender = "여자";
			else gender = "남자";
		String iNotice = req.getParameter("INOTICE");
		String cNotice = req.getParameter("CNOTICE");
		String dNotice = req.getParameter("DNOTICE");
		String job = req.getParameter("JOB");
		String myInfo = req.getParameter("MYINFO");
		
		resp.setContentType("text/html;charset=UTF-8");
		PrintWriter out = resp.getWriter();
		out.println("<html>");
		out.println("<head>");		
			out.println("<title>개인 정보 입력 결과 화면</title>");					
		out.println("</head>");		
		out.println("<body>");	
			out.printf("<h1>개인정보</h1>");
			out.printf("<h1>이름: %s</h1>", name);
			out.printf("<h1>아이디: %s</h1>", id);
			out.printf("<h1>비밀번호: %s</h1>", password);
			out.printf("<h1>성별: %s</h1>", gender);
			out.printf("------------------------");
			out.printf("<h1>공지 메일: %s</h1>", noticeMsgChange(iNotice));
			out.printf("<h1>광고 메일: %s</h1>", noticeMsgChange(cNotice));
			out.printf("<h1>배송 확인 메일: %s</h1>", noticeMsgChange(dNotice));
			out.printf("------------------------");
			out.printf("<h1>직업: %s</h1>", job);
			out.printf("<h1>자기소개:</h1> <pre>%s</pre>", myInfo);
			out.printf("------------------------");
			out.printf("게시글을 등록하였습니다.");
		out.println("</body>");		
		out.println("<html>");
		
	}
	
	private String noticeMsgChange(String notice) { //메일 수신 여부의 값(on, null)을 한글로 바꾸는 메소드
		
		String returnMsg = "";
		
		if(notice == null) returnMsg  = "메일을 받지 않겠습니다.";
		else if(notice.equals("on")) returnMsg = "메일을 받겠습니다.";
		else returnMsg = notice;
		
		return returnMsg;
	}
	
}
