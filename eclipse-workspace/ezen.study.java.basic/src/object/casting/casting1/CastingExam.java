package object.casting.casting1;
//-----------------------------------------------------------------------------
class Car{
	String color;
	int door;
	
	void drive() {
		System.out.println("자동차가 움직입니다.");
	}
	void stop() {
		System.out.println("자동차가 멈춥니다.");
	}
}
//-----------------------------------------------------------------------------
class FireTruck extends Car{
	void water() {
		System.out.println("소방차가 물을 뿌려 불을 끕니다.");
	}
	
}
//-----------------------------------------------------------------------------
public class CastingExam {

	public static void main(String[] args) {
		Car car = null;
		FireTruck ft1 = new FireTruck();
		FireTruck ft2 = null;
		ft1.water();
		car = ft1; //up-casting
		car.drive(); //부모가 가지고 있는 자손의 것만 사용 가능
		car.stop();
		//down casting : 형변환 생략 불가능
		ft2 = (FireTruck) car;
		System.out.println(car + ", " + ft1 + ", " + ft2 );
	}

}
//-----------------------------------------------------------------------------