package calculator.example;

import java.awt.*;

public class CalculatorMain {

	public static void main(String[] args) {

		Calculator myCalc = new Calculator();
		
		myCalc.setTitle("My Calculator");
		myCalc.setSize(441, 417);
		myCalc.setBackground(Color.LIGHT_GRAY);
		myCalc.setLocation(500, 200);
		myCalc.setVisible(true);
		myCalc.setResizable(false);
	}

}