package network;

import java.io.*;
import java.net.URL;

public class NetworkExam04 {

	public static void main(String[] args) {

		URL url = null;
		InputStream in = null;
		FileOutputStream out = null;
		
		String address = "https://n.news.naver.com/article/277/0005167092?cds=news_media_pc&type=editn";
		
		int ch = 0;
		try {
			url = new URL(address);
			in = url.openStream();
			out = new FileOutputStream("c:\\temp\\file_down.txt");
			
			while((ch = in.read()) != -1) {
				out.write(ch);
			}
			in.close();
			out.close();
			
		} catch(Exception e ) {
			e.printStackTrace();
		}

	}

}
