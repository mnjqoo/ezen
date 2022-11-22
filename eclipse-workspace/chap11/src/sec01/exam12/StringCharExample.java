package sec01.exam12;

public class StringCharExample {

	public static void main(String[] args) {
		
		String ssn = "010123-1234567";
		
		char sex = ssn.charAt(7);
		switch(sex) {
		case '1':
		case '3':
			System.out.println("남자입니다.");
			break;
		case '2':
		case '4':
			System.out.println("여자입니다.");
			break;
		}

	}

}
