package sec01.exam18;

public class StringSubstringExample {

	public static void main(String[] args) {

		String ssn = "123456-1234567";
		
		String firstNum = ssn.substring(0, 6);
		System.out.println(firstNum);
		
		String  secNum = ssn.substring(7);
		System.out.println(secNum);

	}

}
