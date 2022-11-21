package object.abstractExam.abst3;


//----------------------------------------------------------------------------
abstract class Computer {

	public abstract void display(); //추상메소드
	public abstract void typing(); //추상메소드
	
	public void turnOn() { //일반메소드
		System.out.println("전원을 켭니다.");
	}
	public void turnOff() {
		System.out.println("전원을 끕니다.");
	}
}
//----------------------------------------------------------------------------
class DeskTop extends Computer {//상위 클래스에서는 하위 클래스에서도 공통으로 사용할 메소드를 구현하고, 하위 클래스마다 다르게 구현할 메소드는 추상메소드로 선언한다.

	@Override
	public void display() { //추상메소드를 구현
		System.out.println("데스크탑의 화면 출력");
	}
	@Override
	public void typing() {
		System.out.println("데스크탑의 문자 입력");
	} 
	
	@Override
	public void turnOn() {
		System.out.println("데스크탑의 전원을 켭니다.");
	}
	@Override
	public void turnOff() {
		System.out.println("데스크탑의 전원을 끕니다.");
	}
}
//----------------------------------------------------------------------------
abstract class NoteBook extends Computer{ //부모 클래스에서 물려받아 구현하지 않은 추상메소드가 있으므로 추상클래스가 된다.
	@Override
	public void display() {
		System.out.println("노트북의 화면 출력");
	}
}
//----------------------------------------------------------------------------
class MyNoteBook extends NoteBook{
	@Override
	public void typing() {
		System.out.println("나의 노트북의 문자 입력");
	}
}
//----------------------------------------------------------------------------
public class ComputerExam {

	public static void main(String[] args) {
		// Computer com1 = new Computer(); > 추상클래스는 인스턴스로 생성할 수 없다.
		Computer com2 = new DeskTop();
		com2.display();
		com2.typing();
		com2.turnOn();
		com2.turnOff();
		//Computer com3 = new NoteBook(); > 추상클래스
		NoteBook myNoteBook = new MyNoteBook();
		myNoteBook.display();
		myNoteBook.typing();
		myNoteBook.turnOn();
		myNoteBook.turnOff();
		
	}

}
//----------------------------------------------------------------------------