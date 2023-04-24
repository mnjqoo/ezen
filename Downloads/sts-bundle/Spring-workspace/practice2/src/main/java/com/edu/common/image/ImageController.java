package com.edu.common.image;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequestMapping(value="/image")
public class ImageController {
	
	//==============================================================================
	@Resource(name="uploadPath")
	String uploadPath; //c:/data/upload
	
	//파일의 확장자를 이용해 mediaType을 가져오기 위한 변수
	private static Map<String, MediaType> mediaMap; //제공되는 미디어 타입
	static { //초기화 블록
		mediaMap = new HashMap<String, MediaType>();
		
		mediaMap.put("JPG", MediaType.IMAGE_JPEG);
		mediaMap.put("GIF", MediaType.IMAGE_GIF);
		mediaMap.put("PNG", MediaType.IMAGE_PNG);
	}
	
	//=============================================================================
	
	//이미지 업로드 하기
	@ResponseBody
	@RequestMapping(value="/uploadImage.do", method=RequestMethod.POST)
	public ResponseEntity<String> upload(MultipartFile file, String email) throws Exception {
		System.out.println("ImageController의 이미지 업로드 처리 시작....");
		
		//이미지 업로드 클래스의 메소드를 이용해 이미지를 업로드 한 후 성공시 파일 이름을 리턴받는다.
		//uploadPath, 파일의 바이트, 파일의 이름이 될 이메일을 넣어준다.
		String fileName = UploadFileUtils.uploadFile(uploadPath, file, email);
		System.out.println("이미지 업로드 결과: " + fileName);
		
		ResponseEntity<String> entity = new ResponseEntity<String>(fileName, HttpStatus.OK);
		
		return entity;
	}
}
