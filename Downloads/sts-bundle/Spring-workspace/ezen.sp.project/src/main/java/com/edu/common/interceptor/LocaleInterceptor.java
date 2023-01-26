package com.edu.common.interceptor;

import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

//사용자 정의 인터셉터는 반드시 HandlerInterceptorAdapter를 상속받아야한다.
@SuppressWarnings("deprecation")
public class LocaleInterceptor extends HandlerInterceptorAdapter{

	private static Logger logger = LoggerFactory.getLogger(LoginInterceptor.class);

	
	//요청에 따라 페이지를 한글 또는 영어로 보여준다.
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		logger.info("====================================");
		logger.info("LocaleInterceptor의 preHandle");
		logger.info("====================================");
		
		System.out.println(request.getParameter("locale"));
		HttpSession session = request.getSession();
		String locale = request.getParameter("locale"); //브라우저에서 전달한 locale 정보를 가져온다.
		if(locale == null) { //최초 요청시
			locale = "ko"; //locale을 한국어로 설정한다.
		} else {
			locale = "ko";
		}
		System.out.println(request.getParameter("locale"));
		//locale속성값을 session에 저장하여 SessionLocaleResolver가 사용할 수 있게 한다.
		session.setAttribute("org.springframework.web.servlet.i18n.SessionLocaleResolver.LOCALE", new Locale(locale));
		
		return true;
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		logger.info("====================================");
		logger.info("LocaleInterceptor의 postHandle");
		logger.info("====================================");
	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		logger.info("====================================");
		logger.info("LocaleInterceptor의 afterCompletion");
		logger.info("====================================");
	}
	
	
	
}
