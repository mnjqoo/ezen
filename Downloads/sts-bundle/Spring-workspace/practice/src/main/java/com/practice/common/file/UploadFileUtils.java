package com.practice.common.file;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.Calendar;
import java.util.UUID;

import javax.imageio.ImageIO;

import org.imgscalr.Scalr;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.FileCopyUtils;

//파일 업로드에 필요한 메소드를 모아놓은 클래스
public class UploadFileUtils {
	
	private static final Logger logger = LoggerFactory.getLogger(UploadFileUtils.class);
	
	//※파일 업로드 총괄 메소드(최종 업로드 된 파일 이름을 반환한다.)※
	public static String uploadFile(String uploadPath, String originalName, byte[] fileData) throws Exception {
		logger.info("UploadFileUtils의 uploadFile() 시작....");
		
		//넘겨받은 파일을 저장하기 위해 필요한 것들을 만든다.//
		//파일을 날짜별로 저장하기 위해 세부 경로를 만들어서 저장한다.
		String savedPath = calculatePath(uploadPath); //기본 저장 경로 밑에
		
		//넘겨받은 파일을 구분 할 수 있도록 랜덤코드를 덧붙여서 저장할 파일 이름을 만든다.
		String savedName; //데이터에 저장될 파일 이름
		UUID uuid = UUID.randomUUID(); //랜덤코드
		savedName = uuid.toString() + "_" + originalName; //랜덤코드_원본이름
		
		//파일을 저장한다.//
		//만든 경로와 저장할 이름으로 파일 변수를 만든다.
		File file = new File(uploadPath + savedPath, savedName);
		
		//넘겨받은 바이트파일데이터와 만든 파일변수를 이용해 파일을 붙여넣는다.
		FileCopyUtils.copy(fileData, file);
		
		//메소드를 이용해 브라우저에서 보여줄 썸네일 파일을 만들고 이름을 반환받는다..
		String thumbnailName = makeThumbnail(uploadPath, savedPath, savedName);
		
		String uploadedName = savedPath + File.separator + thumbnailName;
		
		//저장한 원본 파일 이름을 반환한다. (/날짜경로 + 이름)
		return uploadedName.replace(File.separator, "/");
		
		
	}
	
	//날짜별로 경로 이름을 만들어서 메소드를 이용해 경로를 만드는 메소드(경로 이름을 반환한다.)
	private static String calculatePath(String uploadPath) {
		logger.info("UploadFileUtils의 calculatePath() 시작....");
		
		//현재 날짜 정보를 캘린더 인스턴스를 이용해 얻는다.
		Calendar cal = Calendar.getInstance();
		
		//만들어줄 연도 경로 이름(\2023)
		String yearPath = File.separator + cal.get(Calendar.YEAR);
		//만들어줄 월 경로 이름(\2023\01), "00" 형식으로 만들어준다.(01, 02)
		String monthPath = yearPath + File.separator + new DecimalFormat("00").format(cal.get(Calendar.MONTH) + 1); //월은 0부터 시작한다.
		//만들어줄 일 경로 이름(\2023\01\27), "00" 형식으로 만든다.
		String datePath = monthPath + File.separator + new DecimalFormat("00").format(cal.get(Calendar.DATE));
		
		System.out.println("monthPath: " + monthPath);
		//생성한 이름을 가지고 메소드를 이용해 실질적으로 경로 폴더를 만든다.
		makeDirectory(uploadPath, yearPath, monthPath, datePath);
		
		//파일 이름에 사용하기 위해 최종 디렉토리 이름(datePath)을 반환한다.
		return datePath;
	}
	
	//경로 이름으로 경로에 해당하는 디렉토리를 만드는 메소드
	private static void makeDirectory(String uploadPath, String ... paths) { //String 타입의 매개변수가 배열로 들어간다.paths[i]
		logger.info("UploadFileUtils의 makeDirectory() 시작....");
		
		//만들려고 하는 디렉토리(datePath)가 이미 존재 할 경우를 처리한다. 
		boolean fileExist = new File(paths[paths.length -1]).exists(); //존재할 경우 true;
		if(fileExist) return; //그냥 돌아가기
		
		//배열 paths만큼 반복해서 디렉토리를 만든다.
		//mkdir(): 지정한 경로 위치에 가기 전까지 폴더가 존재해야지만 새로 만들려고 하는 폴더를 생성할 수 있다.(연,월,일 하나하나 순서대로 만들어야한다.)
		//mkdirs(): 지정한 경로에 가기전에 없는 폴더까지 만들어준다.
		for(String path: paths) {
			//paths에 있는 경로 이름을 이용해 file 객체를 만든다.
			File file = new File(uploadPath + path);
			//각각의 디렉토리가 존재하지 않으면
			if(!file.exists()) {
				file.mkdir(); //mkdir() 함수를 이용해 디렉토리를 생성한다.
			}
		}
	}
	
	//썸네일 만드는 메소드
	private static String makeThumbnail(String uploadPath, String savedPath, String savedName) throws Exception {
		logger.info("UploadFileUtils의 makeThumbnail() 시작....");
		
		//저장한 원본 파일 이미지를 읽어서 버퍼에 저장한다. ImageIO.read(File);
		BufferedImage originalImg = ImageIO.read(new File(uploadPath + savedPath, savedName));
		
		//원본사진을 지정한 크기로 축소해서 만든 썸네일 이미지를 버퍼에 저장한다.
		//Scalr.resize(source, scalingMethod, targetSize) : 지정한 높이에 맞게 이미지를 조정한다
		BufferedImage thumbnailImg = Scalr.resize(originalImg, Scalr.Method.AUTOMATIC, Scalr.Mode.FIT_TO_HEIGHT, 180);
		
		//만들 썸네일 파일의 이름을 만든다.(s_원본이름)
		String thumbnailName = "s_" + savedName;
		
		//버퍼에 저장된 썸네일 이미지를 붙여넣기 위해 파일 변수와 확장자를 준비한다.
		File file = new File(uploadPath + savedPath, thumbnailName);
		String extensionName = savedName.substring(savedName.lastIndexOf(".") + 1); //.다음부터 전부
		
		//준비된 이미지, 확장자, 파일을 이용해 파일을 붙여넣는다.
		//ImageIO.write(RenderedImage im, String formatName, File output)
		ImageIO.write(thumbnailImg, extensionName, file);
		
		return thumbnailName;
	}
	
}
