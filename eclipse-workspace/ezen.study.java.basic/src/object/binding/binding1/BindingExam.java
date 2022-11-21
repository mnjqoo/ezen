package object.binding.binding1;
//-----------------------------------------------------------------------------
class Parents{
	int x = 100;
	void method() {System.out.println("Parents Method");}
}
//-----------------------------------------------------------------------------
class Child extends Parents{
	int x = 200;
	void method() {System.out.println("Child method");}
}
//-----------------------------------------------------------------------------
public class BindingExam {

	public static void main(String[] args) {
		Parents p = new Child();
		Child c = new Child();
		
		System.out.println(p.x);
		System.out.println(c.x);
		p.method();
		c.method();

	}

}

//-----------------------------------------------------------------------------