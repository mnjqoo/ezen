package object.abstractExam.abst1;

//-----------------------------------------------------------------------------------------------------------
abstract class Animal {
	int	height;
	int	weight;
	
	abstract void cry();	// 추상메서드 : 선언부만 있고, 구현부가 없는 메서드
	void run() {			// 일반메서드
		System.out.println("동물이 달려갑니다.");	
	}
} // End - abstract class Animal
//-----------------------------------------------------------------------------------------------------------
class Dog extends Animal {
	void cry() {	// 조상클래스에서 받은 추상메서드를 구현한다.
		System.out.println("강아지가 멍멍하고 짖습니다.");
	}
} // End - class Dog extends Animal
//-----------------------------------------------------------------------------------------------------------
class Cat extends Animal {
	void cry() {	// 조상클래스에서 받은 추상메서드를 구현한다.
		System.out.println("고양이가 야옹하고 웁니다.");
	}
} // End - class Cat extends Animal
//-----------------------------------------------------------------------------------------------------------
// public class AnimalCry
//-----------------------------------------------------------------------------------------------------------
public class AnimalCry {
	public static void main(String[] args) {
		Dog	dog	= new Dog();
		Cat	cat	= new Cat();
		
		dog.cry();
		cat.cry();
	}
} // End - public class AnimalCry







