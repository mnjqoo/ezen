package object.interfaceExam.inter1;

//-----------------------------------------------------------------------------------------------------------
interface Repairable {}

//-----------------------------------------------------------------------------------------------------------
class Unit {
			int	hitPoint;
	final 	int MAX_HP;
	
	Unit(int hp) {
		MAX_HP = hp;
	}
} // End - class Unit

//-----------------------------------------------------------------------------------------------------------
class GroundUnit extends Unit {	// 자손 클래스에는 부모 생성자가 있어야 한다.
	GroundUnit(int hp) {
		super(hp);
	}
} // End - class GroundUnit extends Unit

//-----------------------------------------------------------------------------------------------------------
class AirUnit extends Unit {
	AirUnit(int hp) {
		super(hp);
	}
}

//-----------------------------------------------------------------------------------------------------------
class Tank extends GroundUnit implements Repairable {
	Tank() {
		super(150);	// Tank의 HP를 150으로 초기화한다.
		hitPoint	= MAX_HP;
	}
	public String toString() {	// 오버라이딩
		return "탱크";
	}
} // End - class Tank extends GroundUnit implements Repairable

//-----------------------------------------------------------------------------------------------------------
class Dropship extends AirUnit implements Repairable {
	Dropship() {
		super(200);
		hitPoint	= MAX_HP;
	}
	public String toString() {
		return "수송선";
	}
} // End - class Dropship extends AirUnit implements Repairable 

//-----------------------------------------------------------------------------------------------------------
class Marine extends GroundUnit {
	Marine() {
		super(50);
		hitPoint	= MAX_HP;
	}
	public String toString() {
		return "해병";
	}
} // End - class Marine extends GroundUnit

//-----------------------------------------------------------------------------------------------------------
class SCV extends GroundUnit implements Repairable {
	SCV() {
		super(50);
		hitPoint	= MAX_HP;
	}
	public String toString() {
		return "SCV";
	}
	
	void repair(Repairable r) {
		if(r instanceof Unit) {
			Unit u = (Unit)r;
			while(u.hitPoint != u.MAX_HP) {
				// Unit의 HP를 증가시킨다.
				u.hitPoint++;
			}
			System.out.println(u + "의 수리가 모두 끝났습니다.");
			System.out.println(u.toString() + "의 수리가 모두 끝났습니다.");
		}
	}
} // End - class SCV extends GrounUint implements Repairable

//-----------------------------------------------------------------------------------------------------------
// public class RepaireableExam
//-----------------------------------------------------------------------------------------------------------
public class RepaireableExam {
	public static void main(String[] args) {
		Tank		tank		= new Tank();
		Dropship	dropship	= new Dropship();
		
		Marine		marine		= new Marine();
		SCV			scv			= new SCV();
		
		scv.repair(tank);
		scv.repair(dropship);
		
		// 에러발생
		// The method repair(Repairable) in the type SCV is not applicable for the arguments (Marine)
		// scv.repair(marine);
	}
} // End - public class RepaireableExam



















