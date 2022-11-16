package object.basic.overloading;

//-----------------------------------------------------------------------------------------------------------
// class MyMath
//-----------------------------------------------------------------------------------------------------------
class MyMath {
	int	plus(int num1, int num2) {
		System.out.println("int plus(int num1, int num2)");
		return num1 + num2;
	}
	long plus(int num1, long num2) {
		System.out.println("long plus(int num1, long num2)");
		return num1 + num2;
	}
	long plus(long num1, int num2) {
		System.out.println("long plus(long num1, int num2)");
		return num1 + num2;
	}
	long plus(long num1, long num2) {
		System.out.println("long plus(long num1, long num2)");
		return num1 + num2;
	}
	int plus(int[] num1) {
		System.out.println("int plus(int[] num1)");
		int result = 0;
		for(int i = 0; i < num1.length; i++) {
			result += num1[i];
		}
		return result;
	}
	int plus(int num1, int num2, int num3) {
		System.out.println("int plus(int num1, int num2, int num3)");
		return num1 + num2 + num3;
	}
} // End - class MyMath
//-----------------------------------------------------------------------------------------------------------
// public class OverloadingExam
//-----------------------------------------------------------------------------------------------------------
public class OverloadingExam {

	public static void main(String[] args) {

		MyMath mm = new MyMath();
		System.out.println("mm.plus( 3,  3) ==> " + mm.plus( 3,  3));
		System.out.println("mm.plus(3L,  3) ==> " + mm.plus(3L,  3));
		System.out.println("mm.plus( 3, 3L) ==> " + mm.plus( 3, 3L));
		System.out.println("mm.plus(3L, 3L) ==> " + mm.plus(3L, 3L));
		
		int[] num = {100, 200, 300, 400};
		System.out.println("mm.plus(num) ==> " + mm.plus(num));
		
		System.out.println("mm.plus(1, 2, 3) ==> " + mm.plus(1,2,3));
		
		System.out.println(1234);
		System.out.println("안녕하세요?");
		System.out.println(123.4567);
	}

} // End - public class OverloadingExam






