package object.interfaceExam.inter2;

//-----------------------------------------------------------------------------------------------------------
class A {
	public void methodA(B b) {
		b.methodB();
	}
}
//-----------------------------------------------------------------------------------------------------------
class B {
	public void methodB() {
		System.out.println("methodB()");
	}
}
//-----------------------------------------------------------------------------------------------------------
// public abstract class InterfaceExam
//-----------------------------------------------------------------------------------------------------------
public class InterfaceExam {
	public static void main(String[] args) {
		A a = new A();
		a.methodA(new B());
	}
} // End - public abstract class InterfaceExam
