package sec01.exam15;

public class StringIndexOfExample {

	public static void main(String[] args) {
		
		String subject = "자바 프로그래밍";
		
		int location = subject.indexOf("프로그래밍");
		System.out.println(location);
		
		if(subject.indexOf("자바") != -1) {
			System.out.println("자바와 관련된 책입니다.");
		} else {
			System.out.println("자바와 관련 없는 책입니다.");
		}
		
		if(subject.contains("자바")) {
			System.out.println("자바와 관련된 책입니다.");
		} else {
			System.out.println("자바와 관련 없는 책입니다.");
		}

	}

}
