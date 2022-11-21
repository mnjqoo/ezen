package object.basic.constructor.car2;


class Car{
	String color; // 색상
	String gearType; // 변속기 종류(auto, manual)
	int door; // 문의 갯수
	
	Car(){
		this("black", "manual", 4);
	}
	Car(String color){
		this(color, "manual", 4);
	}
	Car(String color, String gearType, int door){
		this.color = color;
		this.gearType = gearType;
		this.door = door;
	}
}

public class CarExam {

	public static void main(String[] args) {
		
		Car c1 = new Car();
		System.out.println(c1.color + ", " + c1.gearType + ", " + c1.door);
		Car c2 = new Car("red");
		System.out.println(c2.color + ", " + c2.gearType + ", " + c2.door);
		Car c3 = new Car("blue", "auto", 3);
		System.out.println(c3.color + ", " + c3.gearType + ", " + c3.door);

	}

}
