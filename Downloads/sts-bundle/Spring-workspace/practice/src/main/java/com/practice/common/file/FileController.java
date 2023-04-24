package com.practice.common.file;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.commons.io.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequestMapping(value="/file")
public class FileController {

	Logger logger = LoggerFactory.getLogger(FileController.class);
	
	//메소드에 사용할 베이스 파일 경로를 변수에 주입한다.
	@Resource(name="uploadPath")
	String uploadPath;
	
	//파일의 확장자를 이용해 mediaType을 가져오기 위한 변수
	private static Map<String, MediaType> mediaMap; //제공되는 미디어 타입
	static { //초기화 블록
		mediaMap = new HashMap<String, MediaType>();
		
		mediaMap.put("JPG", MediaType.IMAGE_JPEG);
		mediaMap.put("GIF", MediaType.IMAGE_GIF);
		mediaMap.put("PNG", MediaType.IMAGE_PNG);
	}
	
	//넘어온 파일을 메소드를 이용해 업로드 하고 넘겨 받은 파일 이름과 상태값을 json 형태로 리턴한다. 
	//json: JavaScript에서 객체를 표현하는 방법이지만, 다양한 프로그래밍언어에서 데이터를 주고 받기 위해 사용된다.
	@ResponseBody
	@RequestMapping(value="/upload", method=RequestMethod.POST)
	public ResponseEntity<String> upload(MultipartFile file) throws Exception {
		logger.info("FileController의 upload() 처리 시작....file 정보:" + file);
		
		//메소드를 이용해 파일을 업로드 한 후 썸네일 파일 이름을 받는다.
		//메소드에 파일을 업로드할 경로, 파일 이름 제작을 위한 기존 파일 이름, 실제 파일의 바이트단위를 넣어준다.
		String uploadedFileName = UploadFileUtils.uploadFile(uploadPath, file.getOriginalFilename(), file.getBytes());
		
		System.out.println("파일 이름: " + uploadedFileName);
		//업로드 된 파일 명과 상태값을 변수에 담아서 리턴한다.
		ResponseEntity<String> entity = new ResponseEntity<String>(uploadedFileName, HttpStatus.OK);		
		
		return entity;
	}
	
	//넘어온 파일 이름으로 이미지 파일을 찾고, 바이트 형식으로 반환한다.
	@ResponseBody //data를 그대로 리턴해줄 것이기 때문에 ResponseBody를 써준다.
	@RequestMapping(value="/display", method=RequestMethod.GET)
	public ResponseEntity<byte[]> display(String fileName) throws Exception {
		logger.info("FileController의 display() 불러오기....file 이름:" + fileName);
		
		//결과값, 헤더값, 상태코드를 프론트에 넘겨주기 위해 ReponseEntity 클래스를 사용한다.
		ResponseEntity<byte[]> entity = null; //넘겨줄 ResponseEntity
		
		//서버의 파일을 다운로드 할 inputStream 준비
		InputStream inputStream = null;
		
		try {
			
			//헤더 객체를 준비
			HttpHeaders header = new HttpHeaders();
			
			//파일 이름으로 FileInputStream으로 파일을 다운받아 inputStream에 저장한다.
			//FileInputStream: 파일로 부터 바이트로 입력받아, 바이트 단위로 출력할 수 있는 클래스
			inputStream = new FileInputStream(uploadPath + fileName);
			
			//헤더에 MediaType을 구해서 넣어준다.
			String extentionName = fileName.substring(fileName.lastIndexOf(".") + 1); //확장자 추출
			MediaType mType = mediaMap.get(extentionName.toUpperCase()); //확장자를 대문자로 바꾼 후 map에 키로 대입해서 값을 가져온다.
			header.setContentType(mType);
			
			entity = new ResponseEntity<byte[]>(IOUtils.toByteArray(inputStream), header, HttpStatus.OK);
			
		} catch (Exception e) {
			e.printStackTrace();
			entity = new ResponseEntity<byte[]>(HttpStatus.BAD_REQUEST); //오류반환
		} finally {
			if(inputStream != null) { 
				inputStream.close(); //모든 작업이 끝난 후 inputStream을 닫아준다.
			}
		}
		
		return entity;
	}
}
