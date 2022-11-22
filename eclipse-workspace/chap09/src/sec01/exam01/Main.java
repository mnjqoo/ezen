package sec01.exam01;

public class Main {

	public static void main(String[] args) {
		A a = new A();
		A.B b = a.new B();
		
		b.field = 3;
		b.method();
		
		A.C c = new A.C();
		c.field1 = 1;
		A.C.field2 = 2;
		c.method1();
		A.C.method2();
		
		a.method();

	}

}
