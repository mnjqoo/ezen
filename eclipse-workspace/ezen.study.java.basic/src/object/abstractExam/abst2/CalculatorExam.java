package object.abstractExam.abst2;
//----------------------------------------------------------------------------
abstract class Calculator {
	int left, right;
	
	public void setOprands(int left, int right) {
		this.left = left;
		this.right = right;
	}
	public abstract void calculate();
	public abstract void avg();
	public void go() {
		calculate();
		avg();
	}
}
//----------------------------------------------------------------------------
class Plus extends Calculator{

	@Override
	public void calculate() {
		System.out.println("더하기: " + (this.left + this.right));
	}
	@Override
	public void avg() {
		System.out.println("평균: " + (this.left + this.right) / 2);
	}
	
}
//----------------------------------------------------------------------------
class Minus extends Calculator{

	@Override
	public void calculate() {
		System.out.println("빼기: " + (this.left - this.right));
	}
	@Override
	public void avg() {
		System.out.println("평균: " + (this.left + this.right) / 2);
	}
	
}
//----------------------------------------------------------------------------
public class CalculatorExam {

	public static void main(String[] args) {
		Plus p1 = new Plus();
		p1.setOprands(10, 20);
		p1.go();
		
		Minus m1 = new Minus();
		m1.setOprands(20, 10);
		m1.go();

	}

}
//----------------------------------------------------------------------------