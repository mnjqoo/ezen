package object.abstractExam.abst3;

//-----------------------------------------------------------------------------------------------------------
abstract class Computer {
	public abstract void display();	// 추상 메서드
	public abstract void typing();	// 추상 메서드
	
	public void turnOn() {			// 일반 메서드 - 모든 제품에 사용하는 기능이 같다.
		System.out.println("전원을 켭니다.");
	}
	public void turnOff() {			// 일반 메서드 - 모든 제품에 사용하는 기능이 같다.
		System.out.println("전원을 끕니다.");
	}
}
//-----------------------------------------------------------------------------------------------------------
// 상위 클래스에서는 하위 클래스에서도 공통으로 사용할 메서드를 구현하고,
// 하위 클래스마다 다르게 구현할 메서드는 추상메서드로 선언한다.
//-----------------------------------------------------------------------------------------------------------
class DeskTop extends Computer {
	public void display() {	// 추상 메서드를 구현한다.
		System.out.println("데스크탑입니다.");
	}
	public void typing() {	// 추상 메서드를 구현한다.
		System.out.println("데스크탑에서 키보드로 입력합니다.");
	}
	public void turnOn() {	// 부모 클래스가 가지고 있는 turnOn() 메서드를 오버라이딩한다.
		System.out.println("데스크탑의 전원을 켭니다.");
	}
} // End - class DeskTop extends Computer
//-----------------------------------------------------------------------------------------------------------
// 부모클래스에서 물려받아 구현하지 않은 추상메서드가 있으므로 추상 클래스가 된다.
abstract class NoteBook extends Computer { 
	public void display() {
		System.out.println("노트북입니다. 잘 부탁드려요.");
	}
} // End - abstract class NoteBook extends Computer
//-----------------------------------------------------------------------------------------------------------
// 모든 추상메서드를 구현하였으므로 class에 abstract 예약어를 사용하지 않는다.
class MyNoteBook extends NoteBook {
	public void typing() {
		System.out.println("내 노트북에서 타이핑을 합니다.");
	}
} // End - class MyNoteBook extends NoteBook
//-----------------------------------------------------------------------------------------------------------
// public class ComputerExam
//-----------------------------------------------------------------------------------------------------------
public class ComputerExam {
	public static void main(String[] args) {
		// 추상 클래스는 인스턴스로 생성할 수 없다.
		// Computer	com1	= new Computer();	

		// DeskTop 클래스는 추상메서드를 모두 구현하였으므로, 인스턴스를 생성할 수 있다.
		Computer	com2	= new DeskTop();	
		
		// 추상메서드를 가지고 있으므로, 인스턴스를 생성할 수 없다.
		// Computer	com3	= new NoteBook();
		
		// MyNoteBook 클래스는 하나 있던 추상메서드를 구현하였으므로, 인스턴스를 생성할 수 있다.
		NoteBook	com4	= new MyNoteBook();
		
		com2.display();
		com2.typing();
		
		com4.display();
		com4.typing();
	}
} // End - public class ComputerExam








