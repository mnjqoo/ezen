package sec01.exam04;

public class SuperSonicAirPlaneExample {

	public static void main(String[] args) {
		SuperSonicAirPlane sa = new SuperSonicAirPlane();
		sa.takeOff();
		sa.fly();
		sa.flyMode = sa.SUPERSONIC;
		sa.fly();
		sa.flyMode = sa.NORMAL;
		sa.fly();
		sa.land();

	}

}
