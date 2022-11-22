package chap08.sec01.exam05;

public class SmartTelevisionExample {

	public static void main(String[] args) {
		SmartTelevision st = new SmartTelevision();
		
		//RemoteControl rc = st;
		Searchable s = st;
		s.search("www.naver.com");
		
	}

}
