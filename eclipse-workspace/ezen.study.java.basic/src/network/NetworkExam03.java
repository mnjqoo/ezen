package network;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;

public class NetworkExam03 {

	public static void main(String[] args) {
		
		URL url = null;
		BufferedReader input = null;
		String address = "https://n.news.naver.com/article/277/0005167092?cds=news_media_pc&type=editn";
		String line = "";
		
		try {
			url = new URL(address);
			
			input = new BufferedReader(new InputStreamReader(url.openStream()));
			//데이터가 있을 때까지 한줄씩 화면에 출력한다.
			while((line = input.readLine()) != null) {
				System.out.println(line);
			}
			input.close();
		} catch(Exception e) {
			e.printStackTrace();
		}

	}

}
