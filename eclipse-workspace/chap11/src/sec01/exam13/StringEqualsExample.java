package sec01.exam13;

public class StringEqualsExample {

	public static void main(String[] args) {

		String strVar1 = new String("홍길동");
		String strVar2 = "홍길동";
		String strVar3 = strVar1;
		
		if(strVar1 == strVar2) {
			System.out.println("같은 객체");
		} else {
			System.out.println("다른 객체");
		}
		
		if(strVar1.equals(strVar2)) {
			System.out.println("같은 문자열");
		} else {
			System.out.println("다른 문자열");
		}
		
		if(strVar1 == strVar3) {
			System.out.println("같은 객체");
		} else {
			System.out.println("다른 객체");
		}
	}

}
