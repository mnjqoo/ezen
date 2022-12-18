package ch08;

import java.io.IOException;

import javax.servlet.*;
import javax.servlet.ServletException;
import javax.servlet.http.*;

public class PersonalInfoSaver extends HttpServlet{
	
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PersonalInfo pinfo = new PersonalInfo();
		pinfo.setName("심순애");
		pinfo.setGender('여');
		pinfo.setAge(18);
		
		request.setAttribute("pinfo", pinfo);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/ch08/PersonalInfoViewer.jsp");
		dispatcher.forward(request, response);
	}
	
	
}
