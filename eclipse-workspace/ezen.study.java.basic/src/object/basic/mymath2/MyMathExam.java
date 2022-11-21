package object.basic.mymath2;

class MyMath{
	long num1, num2; //인스턴스 변수
	
	static long plus(long num1, long num2) {return num1 + num2;}
	static long minus(long num1, long num2) { return num1 - num2;}
	static long multiply(long num1, long num2) { return num1 * num2;}	
	static long divide(long num1, long num2) { return num1 / num2;}
	//인스턴스 변수 num1, num2를 이용해서 작업하므로 매개변수가 필요없다.
	long plus() {return num1 + num2;}
	long minus() { return num1 - num2;}
	long multiply() { return num1 * num2;}
	long divide() { return num1 / num2;}
}

public class MyMathExam {

	public static void main(String[] args) {
		//클래스 메소드를 호출한다.
		System.out.println(MyMath.plus(200L, 100L));
		System.out.println(MyMath.minus(200L, 100L));
		System.out.println(MyMath.multiply(200L, 100L));
		System.out.println(MyMath.divide(200L, 100L));
		
		//인스턴스 매소드는 클래스를 생성한 후에 사용한다.
		MyMath mm = new MyMath();
		mm.num1 = 300L;
		mm.num2 = 200L;
		System.out.println(mm.plus());
		System.out.println(mm.minus());
		System.out.println(mm.multiply());
		System.out.println(mm.divide());

	}

}
