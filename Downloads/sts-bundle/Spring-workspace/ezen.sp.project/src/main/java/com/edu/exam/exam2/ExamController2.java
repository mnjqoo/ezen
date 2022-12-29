package com.edu.exam.exam2;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/exam/exam2") //url 주소:포트번호/exam/exam1로 요청되는 것을 처리한다.
public class ExamController2 {
	
	@RequestMapping("/doC") //return 타입이 String 인 경우 prefix + 문자열 + suffix 파일을 찾아서 실행한다.
	public String doC(@ModelAttribute("msg") String msg) { //주소창에서 msg라는 파라미터 값을 가져온다. ex) ~/exam/exam2/doC?msg=hello 일 때 hello를 가져온다.
														   //request.getParameter("msg")를 사용하지 않아도 된다.
		System.out.println("doC가 실행되었습니다. msg => " + msg);
		
		return "exam/exam2/doC"; //view의 이름이 된다.
	}
	
	//@RequestMapping("/gugudanForm.do")
	@RequestMapping(value = "gugudanForm.do") //구구단 입력 화면 보내주기 (.do는 빼고 gugudanForm.jsp 로 보내진다.)
	public void guguForm() {//return값이 void면 value값이 페이지가 된다.
		System.out.println("구구단 입력 화면을 호출하였습니다.");
	}
	
	@RequestMapping(value="gugu.do", method=RequestMethod.GET)
	//public String gugu(int dan, Model model)
	//public String gugu(@RequestParam(defaultValue="3") int dan, Model model) { //단의 값이 없을 때 사용할 기본 단을 설정한다.
	public String gugu(int dan, String msg, Model model) { //매개변수명만 맞으면 순서는 상관 없다.
		System.out.println("구구단 계산 결과를 보여주세요");

		//스프링에서는 get방식에서 아래와 같은 방식으로 사용하지 않는다.
		//int dan = Integer.parseInt(request.getParameter("dan"));
		//<a href="http://localhost:8090/exam/exam2/gugu.do?dan=3>구구단</a>
		//public String gugu(HttpServletRequest request Model model)을 사용하지 않고
		//public String gugu(int dan, Model model)을 사용한다.
		
		//값을 넘겨주는 페이지에서 값은 String으로 넘어오지만, 스프링에서 정수형으로 받는다. 이러한 점이 스프링의 장점이다.
		
		System.out.println("계산할 구구단은 " + dan +"입니다.");
		
		String result = "";
		for(int i = 1; i <= 9; i++) {
			result += "<h3>" + dan + " x " + i + " = " + dan * i + "<h3>";
		}
		model.addAttribute("result", result);
		
		System.out.println("전송받은 메세지: " + msg);
		
		return "exam/exam2/gugudan";
		
	}
	
	
}
