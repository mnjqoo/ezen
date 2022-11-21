package object.abstractExam.abst1;
//----------------------------------------------------------------------------
abstract class Animal {
	int height;
	int weight;
	
	abstract void cry(); //추상메소드(선언부만 작성)
	void run() { //일반메소드
		System.out.println("동물이 달려갑니다.");
	}
}
//----------------------------------------------------------------------------
class Dog extends Animal{

	@Override
	void cry() { //조상 클래스에서 받은 추상메소드를 구현한다.
		System.out.println("강아지가 멍멍");
	}
	
}
//----------------------------------------------------------------------------
class Cat extends Animal{

	@Override
	void cry() {
		System.out.println("고양이는 야옹");
	}
	
}
//----------------------------------------------------------------------------
public class AnimalCry {

	public static void main(String[] args) {
		Dog dog = new Dog();
		Cat cat = new Cat();
		dog.cry();
		cat.cry();

	}

}
//----------------------------------------------------------------------------