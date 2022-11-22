package calculator.practice;

public class Display {

	static String getDisplayString() { //출력창의 값을 String으로 가져온다.
		return Calculator.jlOutput.getText();
	}
	
	static void setDisplayString(String s) { //String 값을 출력창에 출력한다.
		Calculator.jlOutput.setText(s);
	}
	
	static double getDisplayNum() {
		return Double.parseDouble(Calculator.jlOutput.getText());
	}
	
	static void setDisplayResult(double result) {
		setDisplayString(String.valueOf(result));
	}
	
	static void addDigitToDisplay(int digit) { //숫자버튼에 해당하는 숫자를 출력창에 출력한다.
		if(Calculator.cleanNextDigit == true) {
			setDisplayString("");
		}
		String output = getDisplayString();
		if(!output.equals("0")) {
			setDisplayString(output + (String.valueOf(digit)));
		} else {
			setDisplayString("");
			setDisplayString(String.valueOf(digit));
		}
		Calculator.cleanNextDigit = false;
	}
}
