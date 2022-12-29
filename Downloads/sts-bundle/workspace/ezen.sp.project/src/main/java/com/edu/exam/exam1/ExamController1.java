package com.edu.exam.exam1;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/exam/exam1") //url 주소:포트번호/exam/exam1로 요청되는 것을 처리한다.
public class ExamController1 {
	
	@RequestMapping("/doA") //servlet-context.xml의 prefix + 리퀘스트매핑 + suffix
	public void doA() {//주소:포트번호/exam/exam1/doA로 요청되는 것을 처리 하는 메소드. /WEB-INF/views/exam/exam1/doA.jsp
		System.out.println("doA가 실행되었습니다."); 
		
	}
	
	@RequestMapping("/doB") ///WEB-INF/views/exam/exam1/doB.jsp
	public void doB() {
		System.out.println("doB 요청을 처리합니다.");
	}
	
}
