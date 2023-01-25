package com.edu.common.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller("localeController")
public class LocaleController { //요청에 대해서 jsp 이름만 view resolver로 반환한다.

	Logger logger = LoggerFactory.getLogger(LocaleController.class);
	
	@RequestMapping(value="/test/locale.do", method=RequestMethod.GET)
	public String locale(HttpServletRequest request, HttpServletResponse response) throws Exception {
		logger.info("LocaleController의 locale 시작");
		return "locale"; //컨트롤러는 뷰 이름만 반환한다.
	}
}
