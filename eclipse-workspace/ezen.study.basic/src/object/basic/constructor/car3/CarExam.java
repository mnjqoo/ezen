package object.basic.constructor.car3;

//-----------------------------------------------------------------------------------------------------------
// 자동차 클래스
//-----------------------------------------------------------------------------------------------------------
class Car {
	String	color;	String	gearType;	int	door;
	Car()	{
		// color = "검정"; gearType = "수동"; door = 4;
		// 생성자에서 다른 생성자를 호출할 경우는 
		// 생성자이름 대신에 this()를 사용하고, 맨 위에 기술해야 합니다.
		this("검정", "수동", 4);
		System.out.println("기본 생성자를 실행합니다.");
	}
	Car(Car c) {	// 인스턴스의 복사를 하기 위해서 만든 생성자
		color		= c.color;
		gearType	= c.gearType;
		door		= c.door;
	}
	Car(String color, String g, int d) {
		this.color 		= color;
		this.gearType	= g;
		door			= d;
	}
	
	void drive() {
		System.out.println("자동차가 움직입니다.");
	}
	
} // End - class Car
//-----------------------------------------------------------------------------------------------------------
// public class CarExam
//-----------------------------------------------------------------------------------------------------------
public class CarExam {

	public static void main(String[] args) {
		
		Car	c1	= new Car("보라", "수동", 3);
		System.out.println("c1 => " + c1.color +", " + c1.gearType + ", " + c1.door);
		
		Car c2	= new Car();
		System.out.println("c2 => " + c2.color +", " + c2.gearType + ", " + c2.door);
		
		Car c3	= new Car(c1);
		System.out.println("c3 => " + c3.color +", " + c3.gearType + ", " + c3.door);
		
		System.out.println("------------------------------------------");
		c1.door	= 10;
		System.out.println("c1 => " + c1.color +", " + c1.gearType + ", " + c1.door);
		System.out.println("c2 => " + c2.color +", " + c2.gearType + ", " + c2.door);
		System.out.println("c3 => " + c3.color +", " + c3.gearType + ", " + c3.door);
	
		System.out.println("------------------------------------------");
		c2.drive();
		
		int num;
		// 지역변수는 선언하고 사용하기 전에 꼭 초기화를 해야한다.
		// System.out.println(num); 
		num = 0;
		int sum = num + 1;
		System.out.println(sum);
		
		int x, y;
		// int a, long b;
	} // End - public static void main(String[] args)

} // End - public class CarExam














