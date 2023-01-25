package com.edu.util.upload;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

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
@RequestMapping(value="/util/upload")
public class AjaxUploadController { //AJAX를 이용하여 파일 올리기
	
	private static final Logger logger = LoggerFactory.getLogger(AjaxUploadController.class);
	
	//업로드할 디렉토리는 servlet-context.xml에 설정해놓았다.
	@Resource(name="uploadPath")
	String uploadPath;
	
	//파일올리기(AJAX) 화면 불러오기
	@RequestMapping(value="/uploadAjax", method=RequestMethod.GET)
	public String uploadAjax() { 
		logger.info("AjaxUploadController의 uploadAjax(GET) 불러오기....");
		
		return "/util/upload/uploadAjax";
	}
	
	//파일을 드래그해서 업로드 했을 경우에 진행되는 메소드(AJAX) 업로드 된 파일은 MultipartFile 변수에 저장된다.
	@ResponseBody //jsp로 넘어가지 않고 데이터를 되돌려준다. json 형식으로 리턴한다.
	@RequestMapping(value="/uploadAjax", method=RequestMethod.POST, produces="text/plain;charset=UTF-8")
	public ResponseEntity<String> uploadAjax(MultipartFile file) throws Exception { //ResponseEntity<String>: 메세지와 에러코드를 같이 돌려준다.
		logger.info("AjaxUploadController의 uploadAjax(POST) 불러오기....");
		System.out.println(file.getOriginalFilename());
		System.out.println(file.getSize());
		System.out.println(file.getContentType());
		
		return new ResponseEntity<String>(UploadFileUtils.uploadFile(uploadPath, file.getOriginalFilename(), file.getBytes()), HttpStatus.OK);
	}
	
	//이미지 표시 기능 메소드
	@ResponseBody //view가 아닌 data를 리턴한다.
	@RequestMapping(value="/displayFile", method=RequestMethod.GET)
	public ResponseEntity<byte[]> displayFile(String fileName) throws Exception {
		logger.info("AjaxUploadController의 displayFile 불러오기....");
		
		ResponseEntity<byte[]> entity = null;
		
		//서버의 파일을 다운로드하기 위해 스트림을 준비한다.
		InputStream in = null;
		
		try {
			//넘겨받은 파일 이름에서 확장자를 검사한다.
			//substring(int a) : a 위치부터 모두, substring(int a, int b) : a부터 b앞까지
			String extensionName = fileName.substring(fileName.lastIndexOf(".") + 1); //확장자를 추출한다.(.다음부터 전부)
			MediaType mType = MediaUtils.getMediaType(extensionName); //map에서 타입을 확인한다(없으면 null리턴).
			
			//헤더 구성 객체
			HttpHeaders headers = new HttpHeaders();
			
			//파일 다운받을 inputStream으로 설정
			in = new FileInputStream(uploadPath + fileName);
			
			//이미지 파일인지 아닌지에 따라 처리를 다르게 한다.
			if(mType != null) { //이미지 파일인 경우
				
				//헤더에 타입을 설정한다
				headers.setContentType(mType);
				
			} else { //이미지파일이 아닌 경우
				
				//실제 업로드 된 파일 이름
				fileName = fileName.substring(fileName.indexOf("_") + 1);
				
				//파일 이름에 한글이 들어간 경우 String.getBytes("언어셋")로 String을 바이트 배열로 변환한다.
				//new String(바이트 배열, 언어셋) 문자열의 인코딩 변경
				//바이트 배열로 변환 할 때 utf-8로 읽어서 서유럽언어 형식으로 바꾸어서 넘겨줘야 한다.
				fileName = new String(fileName.getBytes("UTF=8"), "iso-8859-1");
				
				headers.add("content-Disposition", "attachment; filename=\"" + "\""); // \" : 역슬래쉬를 나타내는 문자표기
			}
			
			//바이트 배열로 된 스트림, 헤더를 넣어준다.
			entity = new ResponseEntity<byte[]>(IOUtils.toByteArray(in), headers, HttpStatus.OK);
			
		} catch(Exception e) {
			e.printStackTrace();
			entity = new ResponseEntity<byte[]>(HttpStatus.BAD_REQUEST);
		} finally {
			if(in != null) { //스트림을 닫아준다.
				in.close();
			}
		}
		
		System.out.println("entity: " + entity);
		return entity;
	}
	
	//받은 이름에 해당하는 파일 삭제하기
	@ResponseBody
	@RequestMapping(value="/deleteFile", method=RequestMethod.POST)
	public ResponseEntity<String> deleteFile(String fileName) { //fileName에는 썸네일 파일 이름이 넘어온다.
		logger.info("AjaxUploadController의 deleteFile 처리 시작....");
		
		//넘겨받은 파일 이름에서 확장자를 검사한다.
		//substring(int a) : a 위치부터 모두, substring(int a, int b) : a부터 b앞까지
		String extensionName = fileName.substring(fileName.lastIndexOf(".") + 1); //확장자를 추출한다.(.다음부터 전부)
		MediaType mType = MediaUtils.getMediaType(extensionName); //map에서 타입을 확인한다(없으면 null리턴).
		
		//이미지 파일이면 썸네일 파일에서 원본 이미지의 이름을 추출해 원본 이미지를 삭제한다.
		if(mType != null) { //이미지 파일이면
			
			//원본파일 이름을 추출한다.
			String front = fileName.substring(0, 12);
			String end = fileName.substring(14);
			String orginalFileName = front + end;
			
			//원본파일 이름으로 파일을 찾아서 삭제를 한다.
			new File(uploadPath + orginalFileName.replace('/', File.separatorChar)).delete();
			//썸네일 파일도 삭제한다.
			new File(uploadPath + fileName.replace('/', File.separatorChar)).delete();
			
			
		} else { //이미지 파일이 아니면
			
			//받은 파일 이름으로 파일을 찾아서 삭제한다.
			new File(uploadPath + fileName.replace('/', File.separatorChar)).delete();
		}
		
		return new ResponseEntity<String>("deleted", HttpStatus.OK);
	}
}
