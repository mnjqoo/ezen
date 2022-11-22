package calculator.practice;

import java.awt.*;

import javax.swing.JFrame;

public class CalculatorMain {

	public static void main(String[] args) {

		Calculator myCalc = new Calculator();
		
		myCalc.setTitle("My Calculator");
		myCalc.setSize(441, 450);
		myCalc.setBackground(Color.LIGHT_GRAY);
		myCalc.setLocation(500, 200);
		myCalc.pack();
		myCalc.requestFocus();
		myCalc.getContentPane().setFocusable(true);
		myCalc.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		myCalc.setVisible(true);
		myCalc.setResizable(false);
		
	}

}
