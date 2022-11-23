package swing.calculator;

public class CalculatorMain {
	
	public static void main(String[] args) {
		Calculator calc = new Calculator();
		
		calc.setTitle("계산기");
		calc.setSize(441, 417);
		
		calc.pack(); //사용하지 않는 공간을 차지한다.
		
		calc.setLocation(500, 200);
		calc.setVisible(true);
		calc.setResizable(false); //프레임의 크기를 변경하지 못하게 한다.
		
	}
}
