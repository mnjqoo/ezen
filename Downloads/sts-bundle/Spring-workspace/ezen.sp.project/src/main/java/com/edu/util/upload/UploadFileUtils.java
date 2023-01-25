package com.edu.util.upload;

import java.awt.image.BufferedImage;
import java.io.File;
import java.text.DecimalFormat;
import java.util.Calendar;
import java.util.UUID;

import javax.imageio.ImageIO;

import org.imgscalr.Scalr;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.FileCopyUtils;

public class UploadFileUtils {

	private static final Logger logger = LoggerFactory.getLogger(UploadFileUtils.class);
	
	//파일을 업로드하면 호출되는 메소드
	//날짜별로 디렉토리를 만들어서 파일을 올리도록 한다.
	public static String uploadFile(String uploadPath, String originalName, byte[] fileData) throws Exception {
		logger.info("UploadFileUtils의 uploadFile() 시작....");
		
		//UUID(랜덤코드) 발급
		UUID uuid = UUID.randomUUID();
		//UUID + _ + fileName 형태로 만든다.
		String savedName = uuid.toString() + "_" + originalName;
		
		//메소드를 이용해 업로드할 디렉토리 생성
		String savedPath = calculatePath(uploadPath);
		
		//경로와 이름으로 파일변수를 만든다.
		File target = new File(uploadPath + savedPath, savedName);
		
		//들어온 파일 데이터와 만든 파일 변수(경로, 이름)를 이용해서 파일을 붙여넣는다.
		FileCopyUtils.copy(fileData, target);
		
		//파일의 확장자를 검사해서 이미지파일인지 아닌지 확인한다.
		//마지막 마침표 이후의 확장자를 가지고 구분한다. ( ex) a.jpg, ab.cdf.jpg등)
		String extensionName = originalName.substring(originalName.lastIndexOf(".") + 1);
		
		//올라간 파일의 이름을 받을 변수
		String uploadedFileName = null;
		
		System.out.println("확장자:" + extensionName);
		
		//MediaUtils의 getMediaType()을 호출하여 이미지파일인지 검사한다.
		if(MediaUtils.getMediaType(extensionName) != null) { //이미지 파일인 경우
			//썸네일을 만든다.
			uploadedFileName = makeThumbnail(uploadPath, savedPath, savedName);
		} else { //이미지파일이 아닌 경우
			//아이콘을 생성한다.
			uploadedFileName = makeIcon(uploadPath, savedPath, savedName);
		}
		System.out.println(uploadedFileName);
		
		//만들어진 썸네일 혹은 아이콘 파일 이름을 반환한다.
		return uploadedFileName;
	}
	
	//경로를 계산는 메소드
	private static String calculatePath(String uploadPath) {
		logger.info("UploadFileUtils의 calculatePath() 시작....");
		
		//날짜 정보를 얻기 위해 캘린더 인스턴스를 가져온다.
		Calendar cal = Calendar.getInstance();
		
		//연,월,일을 구분해서 변수에 저장한다.(File.seperator : "\")
		String yearPath = File.separator + cal.get(Calendar.YEAR);
		String monthPath = yearPath + File.separator + new DecimalFormat("00").format(cal.get(Calendar.MONTH) + 1); //Calendar.MONTH는 0부터 시작한다.
		String datePath = monthPath + File.separator + new DecimalFormat("00").format(cal.get(Calendar.DATE));
		
		//메소드로 연월일에 맞게 디렉토리를 생성한다.
		makeDir(uploadPath, yearPath, monthPath, datePath);
		logger.info("Date 경로: " + datePath);
		
		return datePath;
	}
	
	//경로에 맞게 디렉토리를 만드는 메소드
	private static void makeDir(String uploadPath, String ... paths) { //String ... paths : 가변 사이즈의 매개변수(String 타입의 매개변수가 path[i]로 들어간다.)
		logger.info("UploadFileUtils의 makeDir() 시작....");
		
		//만들고자 하는 디렉토리가 이미 존재하면 그냥 돌아간다.
		if(new File(paths[paths.length - 1]).exists()) {
			return;
		}
		
		//paths에 있는 모든 정보만큼 반복해서 디렉토리를 만든다.
		for(String path: paths) {
			File dirPath = new File(uploadPath + path);
			if(!dirPath.exists()) { //디렉토리가 존재하지 않는 경우
				dirPath.mkdir(); //디렉토리를 생성한다.
			}
		}
	}
	
	//아이콘 만드는 메소드
	private static String makeIcon(String uploadPath, String path, String fileName) throws Exception{
		logger.info("UploadFileUtils의 makeIcon() 시작....");
		
		//아이콘의 이름
		String iconName = uploadPath + path + File.separator + fileName;
		
		return iconName.substring(uploadPath.length()).replace(File.separatorChar, '/');
	}
	
	//썸네일 만드는 메소드
	private static String makeThumbnail(String uploadPath, String path, String fileName) throws Exception {
		logger.info("UploadFileUtils의 makeThumbnail() 시작....");
		
		//이미지를 읽어서 버퍼에 저장한다.
		BufferedImage sourceImg = ImageIO.read(new File(uploadPath + path, fileName));
		
		//만들 썸네일의 크기를  설정한다. scalr.resize: 원본 이미지보다 축소하기 위해서 사용. 높이를 맞추면 폭은 자동조정된다.
		//Scalr.resize(source, scalingMethodm resizeMode, targetSize);
		BufferedImage destImg = Scalr.resize(sourceImg,  Scalr.Method.AUTOMATIC, Scalr.Mode.FIT_TO_HEIGHT, 100); //높이가 100
		
		//만들 썸네일 파일의 이름 설정(s_이 붙으면 썸네일 파일, 아니면 원본 파일)
		String thumbnailName = uploadPath + path + File.separator + "s_" + fileName;
		
		//만들어진 썸네일 파일 설정으로 파일을 만들기 위한 준비를 한다.
		File newFile = new File(thumbnailName);
		String extensionName = fileName.substring(fileName.lastIndexOf(".") + 1);
		
		//실질적으로 파일을 생성한다.
		ImageIO.write(destImg, extensionName.toUpperCase(), newFile);
		
		return thumbnailName.substring(uploadPath.length()).replace(File.separatorChar, '/');
	}
}
