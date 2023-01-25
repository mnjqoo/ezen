package com.edu.util.upload;

import java.io.File;
import java.util.UUID;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
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
			System.out.println(file.getOriginalFilename());
			System.out.println(file.getSize());
			System.out.println(file.getContentType());
		} else {
			System.out.println("첨부된 파일이 없습니다.");
		}
		
		String savedName = file.getOriginalFilename(); //파일의 원본 이름을 저장한다.
		savedName = uploadFile(savedName, file.getBytes()); //파일 이름이 중복되지 않도록 처리하는 메소드를 이용해 이름을 붙인다.
		
		mav.setViewName("/util/upload/uploadResult"); //처리 후 넘겨줄 화면(iframe안에 나타난다.)
		mav.addObject("savedName", savedName);
		
		return mav;
		
	}
	
	String uploadFile(String originalName, byte[] fileData) throws Exception { //파일 이름이 중복되지 않도록 처리하는 메소드 (원본 이름, 실제 파일)
		
		//Universal Unique IDentifier(범용 식별자) => 코드를 랜덤으로 만들어 낸다.
		UUID uuid = UUID.randomUUID();
		
		//랜덤 코드 뒤에 원본 이름을 붙인다.
		String savedName = uuid.toString() + "_" + originalName;
		
		//저장할 디렉토리를 지정한다.
		File target = new File(uploadPath, savedName); //new File(디렉토리, 파일이름)
		
		//첨부파일을 임시 디렉토리에서 우리가 지정한 디렉토리로 복사한다.
		FileCopyUtils.copy(fileData, target);
		
		return savedName;
	}
	
	
}
