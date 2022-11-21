package object.basic;

import java.text.SimpleDateFormat;
import java.util.Date;

public class ImportExam {

	public static void main(String[] args) {
		Date today = new Date();
		System.out.println("오늘의 날짜 : " + today);
		
		SimpleDateFormat date = new SimpleDateFormat("yyyy/MM/dd/E요일");
		SimpleDateFormat time = new SimpleDateFormat("a hh:mm:ss");
		System.out.println("오늘의 날짜 : " + date.format(today));
		System.out.println("현재의 시간 : " + time.format(today));

	}

}
