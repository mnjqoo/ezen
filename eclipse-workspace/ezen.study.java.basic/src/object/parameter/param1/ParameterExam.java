package object.parameter.param1;

class Data{
	int x;
} //class Data

public class ParameterExam {

	public static void main(String[] args) {
		Data d = new Data();
		d.x = 10;
		System.out.println("main() : x => " + d.x);
		change(d.x);
		System.out.println("After change().....");
		System.out.println("main() : x => " + d.x);

	} //public static void main(String[] args)
	
	static void change (int x) { //기본형 매개변수
		x = 1000;
		System.out.println("change() : x => " + x);
	}

} //public class ParameterExam

