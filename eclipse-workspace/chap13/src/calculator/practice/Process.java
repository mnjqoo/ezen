package calculator.practice;

public class Process {

	static void signChange() {
		String str = Display.getDisplayString();
		if(!str.equals("0")) {
			if(str.indexOf("-") == 0) {
				Display.setDisplayString(str.substring(1));
			} else {
				Display.setDisplayString("-" + str);
			}
		}
	}
	
	static void addDecimalPoint() {
		String str = Display.getDisplayString();
		if(str.indexOf(".") < 0) {
			Display.setDisplayString(str + ".");
		}
	}
	
	static void operator(String op) {
		if(!Calculator.lastOperator.equals("0")) {
			double result = calculation();
			Display.setDisplayResult(result);
			Calculator.lastNumber = result;
		} else {
			Calculator.lastNumber = Display.getDisplayNum();
		}
		Calculator.lastOperator = op;
		Calculator.cleanNextDigit = true;
		System.out.println("lastNumber: " + Calculator.lastNumber);
		System.out.println("lastOperator: " + Calculator.lastOperator);
	}
	
	static double calculation() {
		double result = 0;
		double lastNumber = Calculator.lastNumber;
		double inputNumber = Display.getDisplayNum();
		switch(Calculator.lastOperator) {
			case "/":
				try {
					result = lastNumber / inputNumber;
				} catch(ArithmeticException e) {
					Display.setDisplayString("0으로 나눌 수 없습니다.");
				} break;
			case "x":
				result = lastNumber * inputNumber; break;
			case "-":
				result = lastNumber - inputNumber; break;
			case "+":
				result = lastNumber + inputNumber; break;
		}
		return result;
	}
	
	static void equals() {
		double result = calculation();
		Display.setDisplayResult(result);
		Calculator.cleanNextDigit = true;
	}
	
	static void clearAll() {
		Calculator.cleanNextDigit = true;
		Calculator.lastOperator = "0";
		Calculator.lastNumber = 0;
		Display.setDisplayString("0");
	}
}
