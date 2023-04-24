package com.edu.common.image;

import java.io.File;
import java.text.DecimalFormat;
import java.util.Calendar;

import org.springframework.util.FileCopyUtils;
import org.springframework.web.multipart.MultipartFile;

//이미지 업로드 할 때 사용할 메소드를 모아놓은 클래스
public class UploadFileUtils {

	//============================================================================
	//※파일 업로드 총괄 메소드(최종 업로드 된 파일 이름을 반환한다.)※
	public static String uploadFile(String uploadPath, MultipartFile file, String email) throws Exception {
		System.out.println("UploadFileUtils의 uploadFile() 시작...");
		
		//메소드를 통해 현재 날짜를 이용한 파일 저장 경로를 구한다.
		String savedPath = calculatePath(uploadPath);
		//파일의 확장자를 구한다.
		String name = file.getOriginalFilename();
		String extentionName = name.substring(name.lastIndexOf(".") ); //.부터 자른다
		//이메일에 확장자를 붙여 파일 이름을 만든다.
		String savedName = email + extentionName;
		
		//저장할 경로와 이름으로 파일 변수를 만든다.
		File image = new File(savedPath, savedName);
		
		//파일 변수에 file 데이터를 붙여 넣는다.
		FileCopyUtils.copy(file.getBytes(), image);
		
		//db에 저장, 이미지 찾기를 위해 경로 + 파일 이름을 리턴해준다.
		String uploadedName = savedPath + File.separator + savedName;
		
		//file.separator를 인식하지 못하는 경우가 있기 때문에 /로 바꿔준다.
		return uploadedName.replace(File.separator, "/");
	}
	
	//============================================================================
	//현재 날짜를 활용해 경로이름을 지정한 후 경로를 만드는 메소드
	private static String calculatePath(String uploadPath) throws Exception {
		System.out.println("UploadFileUtils의 calculatePath() 시작...");
		
		//현재 날짜 정보를 캘린더 인스턴스를 이용해 얻는다.
		Calendar cal = Calendar.getInstance();
		
		//만들어줄 연도 경로 이름(\2023)
		String yearPath = File.separator + cal.get(Calendar.YEAR);
		//만들어줄 월 경로 이름(\2023\01), "00" 형식으로 만들어준다.(01, 02)
		String monthPath = yearPath + File.separator + new DecimalFormat("00").format(cal.get(Calendar.MONTH) + 1); //월은 0부터 시작한다.
		//만들어줄 일 경로 이름(\2023\01\27), "00" 형식으로 만든다.
		String datePath = monthPath + File.separator + new DecimalFormat("00").format(cal.get(Calendar.DATE));
		
		//경로 이름을 이용해 실질적으로 폴더를 만든다.
		if(new File(uploadPath + datePath).exists()) {
			//해당 경로에 폴더가 있으면 만들지 않고 이름만 반환한다.
			return uploadPath + datePath;
		} else {
			//없는 경우 경로를 만들고 경로 이름을 반환한다.
			new File(uploadPath + datePath).mkdirs();
			return uploadPath + datePath;
		}
	}
}
