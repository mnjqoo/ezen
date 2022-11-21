package object.basic.mymath1;

class MyMath{
	int plus(int num1, int num2) {
		int result = num1 + num2;
		return result;
	}
	int minus(int num1, int num2) { 
		return num1 - num2;
	}
	int multiply(int num1, int num2) { 
		return num1 * num2;
	}
	int divide(int num1, int num2) { 
		return num1 / num2;
	}
	void hi() {
		System.out.println("사칙연산 계산기 프로그램입니다.");
	}
}

public class MyMathExam {

	public static void main(String[] args) {
		MyMath mm = new MyMath();
		int result1 = mm.plus(10, 3);
		int result2 = mm.minus(10, 3);
		int result3 = mm.multiply(10, 3);
		int result4 = mm.divide(10, 3);
		mm.hi();
		System.out.println(result1);
		System.out.println(result2);
		System.out.println(result3);
		System.out.println(result4);

	}

}
