package object.parameter.param1;

//-----------------------------------------------------------------------------------------------------------
// class Data
//-----------------------------------------------------------------------------------------------------------
class Data {
	int	x;
} // End - class Data
//-----------------------------------------------------------------------------------------------------------
// public class ParameterExam
//-----------------------------------------------------------------------------------------------------------
public class ParameterExam {

	//-----------------------------------------------------------------------------------------------------------
	public static void main(String[] args) {
		Data d = new Data();
		d.x	= 10;
		System.out.println("main() : x => " + d.x);
		
		//ParameterExam pe = new ParameterExam();
		//pe.change(d.x);
		ParameterExam.change(d.x);
		System.out.println("After change().....");
		System.out.println("main() : x => " + d.x);
	}

	//-----------------------------------------------------------------------------------------------------------
	static void change(int x) {	// 기본형 매개변수
		x = 1000;
		System.out.println("change() : x => " + x);
	}
	
} // End - public class ParameterExam









