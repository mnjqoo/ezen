package object.casting.casting1;

//-----------------------------------------------------------------------------------------------------------
// 자동차 클래스
//-----------------------------------------------------------------------------------------------------------
class Car {
	String	color;		int	door;
	void drive() {	// 운전하는 기능
		System.out.println("자동차가 움직입니다.");
	}
	void stop() {	// 차가 멈추는 기능
		System.out.println("자동차가 멈추었습니다.");
	}
} // End - class Car
//-----------------------------------------------------------------------------------------------------------
// 소방차 클래스
//-----------------------------------------------------------------------------------------------------------
class FireTruck extends Car {
	void water() {	// 물을 뿌리는 기능
		System.out.println("소방차가 물을 뿌려서 불을 끕니다.");
	}
} // End - class FireTruck
//-----------------------------------------------------------------------------------------------------------
// public class CastingExam
//-----------------------------------------------------------------------------------------------------------
public class CastingExam {
	public static void main(String[] args) {
		Car			car		= null;
		FireTruck	ft1		= new FireTruck();
		FireTruck	ft2		= null;
		
		ft1.water();
		// up-casting
		car = ft1;	// car = (Car)ft1; 에서 형변환이 생략된 형태입니다.
		car.drive();
		// car.water(); 컴파일 에러 : Car 타입의 참조변수로는 water()를 호출할 수 없습니다.
		// 부모가 가지고 있는 않는 자손 만의 것을 사용할 수가 없다.
		
		// down-casting : 다운캐스팅은 형변환을 생략할 수가 없다.
		ft2 = (FireTruck)car;
		System.out.println(car + ", " + ft1 + ", " + ft2);
		ft2.water();
	}
} // End - public class CastingExam




