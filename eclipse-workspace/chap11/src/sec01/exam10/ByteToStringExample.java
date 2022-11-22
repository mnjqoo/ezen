package sec01.exam10;

public class ByteToStringExample {

	public static void main(String[] args) throws Exception {

		byte[] bytes = {72, 101, 108, 108, 111, 32, 74, 97, 118, 97};
		
		String str = new String(bytes);
		System.out.println(str);
		
		String str2 = new String(bytes, 6, 4);
		System.out.println(str2);
	}

}
