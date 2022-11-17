package object.basic.constructor.car2;

//-----------------------------------------------------------------------------------------------------------
//자동차 클래스
//-----------------------------------------------------------------------------------------------------------
class Car {
	String	color;
	String	gearType;
	int		door;
	
	Car() {
		this("black", "manual", 4);
	}
	Car(String color) {
		this(color, "manual", 4);
	}
	Car(String color, String gearType, int door) {
		this.color		= color;
		this.gearType	= gearType;
		this.door		= door;
	}
} // End - class Car
//-----------------------------------------------------------------------------------------------------------
// public class CarExam
//-----------------------------------------------------------------------------------------------------------
public class CarExam {

	public static void main(String[] args) {

		Car	c1	= new Car();
		System.out.println(c1.color + " " + c1.gearType + " " + c1.door);
		
		Car c2	= new Car("Red");
		System.out.println(c2.color + " " + c2.gearType + " " + c2.door);

		Car	c3	= new Car("Blue", "Auto", 3);
		System.out.println(c3.color + " " + c3.gearType + " " + c3.door);
	}

} // End - public class CarExam
