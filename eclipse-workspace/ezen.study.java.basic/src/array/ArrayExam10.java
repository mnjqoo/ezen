package array;

public class ArrayExam10 {

	public static void main(String[] args) {

		// 계산을 하기 위해서는 매개변수가 3개 필요하다. => 15 ? 4 
		if(args.length != 3) {
			System.out.println("사용법 : java ArrayExam10 숫자 연산자 숫자");
			System.exit(0);	// 프로그램 종료
		}
		
		System.out.println(args[0] + " " + args[1] + " " + args[2]);
		
		// 첫번째 매개변수가 문자열이므로 숫자로 변환한다.
		int num1 = Integer.parseInt(args[0]);
		
		// charAt(위치)
		// 		String으로 저장된 문자열 중에서 한 글자만 선택해서 char타입으로 변환해준다.
		char op	= args[1].charAt(0);
		
		// 세번째 매개변수가 문자열이므로 숫자로 변환한다.
		int num2 = Integer.parseInt(args[2]);
		
		int result = 0;	// 연산결과를 저장할 변수
		
		// switch문의 수식에는 byte, short, char, int가 올 수 있습니다.
		switch(op) {
			case '+':	result = num1 + num2;	break;
			case '-':	result = num1 - num2;	break;
			case 'x':	result = num1 * num2;	break;
			case '/':	result = num1 / num2;	break;
			default:	System.out.println("지원되지 않는 연산입니다.");
		}
		System.out.println("계산결과 : " + result);

	} // End - public static void main(String[] args)

} // End - public class ArrayExam10






