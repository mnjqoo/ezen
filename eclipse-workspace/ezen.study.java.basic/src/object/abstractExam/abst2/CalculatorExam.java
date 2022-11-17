package object.abstractExam.abst2;

//-----------------------------------------------------------------------------------------------------------
abstract class Calculator {
	int left, right;
	public void setOprands(int left, int right) {
		this.left	= left;
		this.right	= right;
	}
	public abstract void calculate();
	public abstract void avg();
	public void go() {
		calculate();
		avg();
	}
} // End - abstract class Calculator
//-----------------------------------------------------------------------------------------------------------
class Plus extends Calculator {
	public void calculate() {
		System.out.println("더하기 : " + (this.left + this.right));
	}
	public void avg() {
		System.out.println("평  균 : " + (this.left + this.right)/2);
	}
} // End - class Plus extends Calculator
//-----------------------------------------------------------------------------------------------------------
class Minus extends Calculator {
	public void calculate() {
		System.out.println("빼  기 : " + (this.left - this.right));
	}
	public void avg() {
		System.out.println("평  균 : " + (this.left + this.right)/2);
	}
} // End - class Minus extends Calculator
//-----------------------------------------------------------------------------------------------------------
// public class CalculatorExam
//-----------------------------------------------------------------------------------------------------------
public class CalculatorExam {
	public static void main(String[] args) {
		Plus 	pl	= new Plus();
		pl.setOprands(10, 20);
		pl.go();
		
		Minus	mi	= new Minus();
		mi.setOprands(40, 20);
		mi.go();
	}
} // End - public class CalculatorExam

















