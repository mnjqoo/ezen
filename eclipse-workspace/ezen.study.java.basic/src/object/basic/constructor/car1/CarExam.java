package object.basic.constructor.car1;

class Car{
	String color; // 색상
	String gearType; // 변속기 종류(auto, manual)
	int door; // 문의 갯수
	
	Car(){}
	Car(String c, String g, int d){
		color = c;
		gearType = g;
		door = d;
	}
}

public class CarExam {

	public static void main(String[] args) {
		Car c1 = new Car();
		c1.color = "노랑";
		c1.gearType = "수동";
		c1.door = 4;
		System.out.println(c1.color + ", " + c1.gearType + ", " + c1.door);
		Car c2 = new Car("빨강", "자동", 3);
		System.out.println(c2.color + ", " + c2.gearType + ", " + c2.door);

	}

}
