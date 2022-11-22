package sec01.exam14;

import java.io.UnsupportedEncodingException;

public class StringGetBytesExample {

	public static void main(String[] args) {

		String str1 = "안녕하세요";
		
		byte[] bytes = str1.getBytes();
		System.out.println(bytes.length);
		
		String str2 = new String(bytes);
		System.out.println(str2);
		
		try {
			byte[] bytes2 = str1.getBytes("EUC-KR");
			System.out.println(bytes2.length);
			String str3 = new String(bytes2, "EUC-KR");
			System.out.println(str3);
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		
		try {
			byte[] bytes3 = str1.getBytes("UTF-8");
			System.out.println(bytes3.length);
			String str4 = new String(bytes3, "UTF-8");
			System.out.println(str4);
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}

	}

}
