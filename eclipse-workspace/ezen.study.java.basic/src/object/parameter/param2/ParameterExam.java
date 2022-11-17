package object.parameter.param2;

//-----------------------------------------------------------------------------------------------------------
// class Data
//-----------------------------------------------------------------------------------------------------------
class Data {
	int x;
} // End - class Data
//-----------------------------------------------------------------------------------------------------------
// public class ParameterExam
//-----------------------------------------------------------------------------------------------------------
public class ParameterExam {

	//-----------------------------------------------------------------------------------------------------------
	public static void main(String[] args) {
		Data d = new Data();
		d.x = 10;
		System.out.println("main() : x => " + d.x);
		System.out.println(d);

		change(d);
		System.out.println("After change().....");
		System.out.println("main() : x => " + d.x);
	}
	//-----------------------------------------------------------------------------------------------------------
	static void change(Data d) {	// 참조형 매개변수
		System.out.println(d);
		d.x = 1000;
		System.out.println("change() : x => " + d.x);
	}
} // End - public class ParameterExam






