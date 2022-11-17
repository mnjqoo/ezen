package object.binding.binding2;

//-----------------------------------------------------------------------------------------------------------
class Parent {
	int x = 100;
	void method() {	System.out.println("Parent Method.....");	}
}
//-----------------------------------------------------------------------------------------------------------
class Child extends Parent {}
//-----------------------------------------------------------------------------------------------------------
// public class BindingExam
//-----------------------------------------------------------------------------------------------------------
public class BindingExam {
	public static void main(String[] args) {
		Parent	p	= new Child();
		Child	c	= new Child();
		
		System.out.println("p.x => " + p.x);
		p.method();
		
		System.out.println("c.x => " + c.x);
		c.method();
	}
} // End - public class BindingExam














