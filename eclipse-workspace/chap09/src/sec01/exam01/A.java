package sec01.exam01;

public class A {
	A() {
		System.out.println("클래스 A가 생성되었습니다.");
	}
	
	class B {
		int field;
		B() {
			System.out.println("클래스 B가 생성되었습니다.");
		}
		public void method() {
			System.out.println("B의 field: " + field);
		}
	}
	
	static class C {
		int field1;
		static int field2;
		C(){
			System.out.println("클래스 C가 생성되었습니다.");
		}
		
		void method1() {
			System.out.println("C의 인스턴스 field1: " + field1);
		}
		static void method2() {
			System.out.println("C의 정적 field2: " + field2);
		}
	}
	
	void method() {
		class D{
			int field3;
			D(){
				System.out.println("D 클래스가 생성되었습니다.");
			}
			void method() {
				System.out.println("D의 field3 : " + field3);
			}
		}
		D d = new D();
		d.field3 = 4;
		d.method();
	}
}
