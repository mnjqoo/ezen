package com.edu.common.interceptor;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

//브라우저의 요청을 해당 컨트롤러의 매소드가 처리하기 전후에 인터셉터를 두어 특정한 작업을 실행한다.
//인터셉터는 필터와 비슷한 기능을 하지만, 
//필터는 웹 어플리케이션의 특정한 위치에서만 동작하는데 반해서
//인터셉터는 좀 더 자유롭게 위치를 변경해서 기능을 수행 할 수 있다.
//어플리케이션에서 필터와 인터셉터가 동시에 적용되면 필터 기능이 먼저 수행된다.

//redirect: 특정 조건에 만족하지 않으면 특정 페이지로 이동시키는 것.(회원 관련 페이지에서 로그인이 되어있지 않다면 다른 페이지로 보낸다.)
//*Controller에서 매 요청마다 로그인을 체크하고 redirect를 하는 것은 비효율적이다.
//이런 경우가 많을 때 인터셉터(HandlerInterceptor)를 이용한다.

//HandlerInterceptor는 interface로 3가지 method를 포함한다.
//preHandle() : Controller가 작동되기 전
//postHandle() : Controller가 작업을 마친 후
//afterCompletion() : Controller, view가 모두 작업을 마친 후

//*기존에 클라이언트의 요청이 작동되던 순서:
//Request => DispatcherServlet => Handler(Controller) => view => Response

//*인터셉터를 적용했을 때 요청이 작동되는 순서(해당 interface에 있는 3가지 method를 모두 적용시킨다는 가정하에):
//Request => DispatcherServlet => preHandle => Handler(Controller) => postHandle => View => afterCompletion => Response

//컨트롤러로 요청이 가기 전에 가로챈다.
//컨트롤러가 작동되기 전에 세션이 있는지 검사하는 메소드
@SuppressWarnings("deprecation")
public class LoginInterceptor extends HandlerInterceptorAdapter {

	private static Logger logger = LoggerFactory.getLogger(LoginInterceptor.class);

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		logger.info("====================================");
		logger.info("loginInterceptor의 preHandle");
		logger.info("====================================");
		
		//세션 객체를 가져온다.
		HttpSession session = request.getSession();
		
		//login 처리를 담당하는 사용자 정보를 담고있는 객체를 가져온다.
		Object obj = session.getAttribute("member");
		if(obj == null) {
			logger.info("LoginInterceptor preHandle 세션이 없습니다.");
			
			//alert창에서 한글이 깨지지 않도록 설정한다.
			response.setContentType("text/html;charset=UTF-8");
			
			PrintWriter pw = response.getWriter();
			//java.lang.IllegalStateException: 응답이 이미 커밋된 후에는 sendRedirect()를 호출할 수 없다.(replace사용)
			pw.print("<script>alert('LoginInterceptor 메시지 - 먼저 로그인을 해주십시오.');location.replace('/member/loginForm.do');</script>");
			pw.flush();
			pw.close();
			
			return false; //더이상 컨트롤러의 요청으로 가지 않도록 하기 위해
		}
		
		//preHandle의 return은 컨트롤러의 요청 url로 가도 되는지(true) 안되는지(false)의 의미이다.
		return true;
	}

	//컨트롤러에서 클라이언트로 요청할 때 가로챈다.
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		logger.info("====================================");
		logger.info("loginInterceptor의 postHandle");
		logger.info("====================================");
		super.postHandle(request, response, handler, modelAndView);
	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		logger.info("====================================");
		logger.info("loginInterceptor의 afterCompletion");
		logger.info("====================================");
		super.afterCompletion(request, response, handler, ex);
	}
	
	
	
}
