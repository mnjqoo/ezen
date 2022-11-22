package object.interfaceExam.inter1;
//----------------------------------------------------------------------------------------------
interface Repairable {}
//----------------------------------------------------------------------------------------------
class Unit {
	
	int hitPoint;
	final int MAX_HP;
	
	Unit(int hp) { //상수 초기화
		MAX_HP = hp;
	}
}
//----------------------------------------------------------------------------------------------
class GroundUnit extends Unit { //지상유닛
	
	GroundUnit(int hp) {
		super(hp);
	}
}
//----------------------------------------------------------------------------------------------
class AirUnit extends Unit { //공중유닛
	
	AirUnit(int hp) {
		super(hp);
	}
}
//----------------------------------------------------------------------------------------------
class Tank extends GroundUnit implements Repairable {

	Tank() { //Tank의 HP를 150으로 초기화한다.
		super(150);
		hitPoint = MAX_HP;
	}
	
	public String toString() {
		return "탱크";
	}
}
//----------------------------------------------------------------------------------------------
class Dropship extends AirUnit implements Repairable {

	Dropship() {
		super(200);
		hitPoint = MAX_HP;
	}
	
	public String toString() {
		return "수송선";
	}
}
//----------------------------------------------------------------------------------------------
class Marine extends GroundUnit {

	Marine() {
		super(50);
		hitPoint = MAX_HP;
	}
	
	public String toString() {
		return "해병";
	}
}
//----------------------------------------------------------------------------------------------
class SCV extends GroundUnit implements Repairable {

	SCV() {
		super(50);
		hitPoint = MAX_HP;
	}
	
	public String toString() {
		return "SCV";
	}
	void repair(Repairable r) {
		if(r instanceof Unit) {
			Unit u = (Unit) r;
			while(u.hitPoint != u.MAX_HP) {
				u.hitPoint++; //Unit의 HP를 증가시킨다.
			}
			System.out.println(u + "의 수리가 모두 끝났습니다.");
		}
	}
}
//----------------------------------------------------------------------------------------------
public class RepairableExam {

	public static void main(String[] args) {
		Tank tank = new Tank();
		Dropship dropship = new Dropship();
		
		Marine marine = new Marine();
		SCV scv = new SCV();
		
		scv.repair(tank);
	}

}
//----------------------------------------------------------------------------------------------