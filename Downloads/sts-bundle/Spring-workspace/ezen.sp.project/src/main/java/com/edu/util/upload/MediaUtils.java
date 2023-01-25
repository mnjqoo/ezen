package com.edu.util.upload;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;

public class MediaUtils { //파일 올리기에 공통으로 사용할 메소드를 가진 클래스(AjaxUploadController에서 사용하는 클래스

	private static final Logger logger = LoggerFactory.getLogger(MediaUtils.class);
	
	private static Map<String, MediaType> mediaMap;
	
	static { //초기화 블록 생성자보다 우선순위가 높다. 클래스를 로딩 할 때 제일 먼저 실행되는 코드
		mediaMap = new HashMap<String, MediaType>();
		
		mediaMap.put("JPG", MediaType.IMAGE_JPEG);
		mediaMap.put("GIF", MediaType.IMAGE_GIF);
		mediaMap.put("PNG", MediaType.IMAGE_PNG);
		
	}
	
	//이미지 파일인지 아닌지 구분하는 메소드
	public static MediaType getMediaType(String type){ //업로드된 파일이 이미지파일이면 썸네일 파일을 만들어준다.
		logger.info("MediaUtils의 getMediaType() 시작....");
		
		//static{}에 존재하면 이미지파일이고, 아니면 일반파일이다.
		return mediaMap.get(type.toUpperCase()); //map에 있는지 아닌지(null) 리턴한다. (받은 파일의 타입을 모두 대문자로 변경해준다.)
	}
}
