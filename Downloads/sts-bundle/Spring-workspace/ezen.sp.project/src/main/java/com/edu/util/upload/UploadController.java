package com.edu.util.upload;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value="/util/upload/")
public class UploadController { //파일 올리기 컨트롤러

	private static final Logger logger = LoggerFactory.getLogger(UploadController.class);
	
	@Resource(name="uploadPath") //servlet-context.xml에서 선언한 파일 올리기 설정을 참조한다. (자바11부터는 pom에 http://mvnrepository.com.....javax.annotation-api를 추가해야한다.
	String uploadPath; //파일 경로를 공통으로 사용하기 위해 선언한다.
	
	
	@RequestMapping(value="/uploadForm", method=RequestMethod.GET)
	public String uploadForm() {//파일 올리기 화면을 불러온다.
		logger.info("UploadController의 uploadForm 불러오기....");
		
		return "/util/upload/uploadForm";
	}
	
	// MultipartFile file : 업로드한 파일이 저장된다.(임시경로)
	@RequestMapping(value = "/uploadForm", method = RequestMethod.POST)
	public ModelAndView uploadForm(MultipartFile file, ModelAndView mav) throws Exception { // 업로드된 파일을 처리하기
		
		if(!file.isEmpty()) {
			System.out.println("첨부된 파일이 있습니다.");
		} else {
			System.out.println("첨부된 파일이 없습니다.");
		}
		
		return mav;
		
	}
}
