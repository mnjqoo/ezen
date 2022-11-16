package object.basic.constructor.car1;

//-----------------------------------------------------------------------------------------------------------
// 자동차 클래스
//-----------------------------------------------------------------------------------------------------------
class Car {
	String	color;		// 색상
	String	gearType;	// 변소기 종류 - auto(자동), manual(수동)
	int		door;		// 문의 개수
	
	Car() {}	// 기본 생성자
	Car(String c, String g, int d) {	// 매개변수 있는 생성자
		color		= c;
		gearType	= g;
		door		= d;
	}
	
} // End - Car
//-----------------------------------------------------------------------------------------------------------
// public class CarExam
//-----------------------------------------------------------------------------------------------------------
public class CarExam {

	public static void main(String[] args) {

		Car c1		= new Car();
		c1.color	= "yellow";
		c1.gearType	= "manual";
		c1.door		= 4;
		
		Car c2		= new Car("Red", "auto", 3);
		
		System.out.println(c1.color + ", " + c1.gearType + ", " + c1.door);
		System.out.println(c2.color + ", " + c2.gearType + ", " + c2.door);
	}

} // End - public class CarExam






