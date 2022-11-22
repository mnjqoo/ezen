package calculator.practice;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class Calculator extends JFrame implements ActionListener {
	
	static JLabel jlOutput;
	JButton jbButtons[];
	JPanel jpMaster, jpButtons, jpBackspace, jpControl;
	
	static double lastNumber;
	static String lastOperator = "0";
	static boolean cleanNextDigit;
	
	public Calculator() {
		
	//┌──────────────────────────출력창 생성, 디자인───────────────────────────────────┐
		jlOutput = new JLabel("0");
		jlOutput.setBackground(Color.white);
		jlOutput.setOpaque(true); //투명도 조절. true = 불투명, false = 투명
		jlOutput.setFont(new Font("Serif", Font.PLAIN, 30));
		getContentPane().add(jlOutput, BorderLayout.NORTH); //위쪽에 배치
	//└─────────────────────────────────────────────────────────────────────────────────┘
	//┌────────────────────────────────버튼 생성────────────────────────────────────────┐
		jbButtons = new JButton[23];
		
		for(int i = 0; i < 10; i++) { //숫자버튼
			jbButtons[i] = new JButton(String.valueOf(i));
		}
		
		jbButtons[10] = new JButton("+/-"); //기능 버튼
		jbButtons[11] = new JButton(".");
		jbButtons[12] = new JButton("=");
		jbButtons[13] = new JButton("/");
		jbButtons[14] = new JButton("x");
		jbButtons[15] = new JButton("-");
 		jbButtons[16] = new JButton("+");
		jbButtons[17] = new JButton("sqrt");
		jbButtons[18] = new JButton("1/x");
		jbButtons[19] = new JButton("%");
		jbButtons[20] = new JButton("Backspace");
		jbButtons[21] = new JButton("CE");
		jbButtons[22] = new JButton("C");
	//└─────────────────────────────────────────────────────────────────────────────────┘
	//┌──────────────────────────────버튼 디자인────────────────────────────────────────┐
		for(int i = 0; i < jbButtons.length; i++) {
			if(i < 10) {
				jbButtons[i].setForeground(Color.blue);
			} else {
				jbButtons[i].setForeground(Color.black);
			}
		}
	//└─────────────────────────────────────────────────────────────────────────────────┘
	//┌────────────────────────버튼 부분의 판넬 제작 및 배열────────────────────────────┐
		jpMaster = new JPanel(); //버튼 부분의 전체 판넬
		jpButtons = new JPanel(); // 숫자, 연산자 부분의 판넬
		jpButtons.setLayout(new GridLayout(4, 5, 2, 2));
		jpBackspace = new JPanel(); //뒤로가기 버튼의 판넬
		jpBackspace.setLayout(new GridLayout(1, 1, 2, 2));
		jpControl = new JPanel(); //C, CE 버튼의 판넬
		jpControl.setLayout(new GridLayout(1, 2, 2, 2));
		jpMaster.setLayout(new BorderLayout());
		jpMaster.add(jpButtons, BorderLayout.SOUTH);
		jpMaster.add(jpBackspace, BorderLayout.WEST);
		jpMaster.add(jpControl, BorderLayout.EAST);
		getContentPane().add(jpMaster, BorderLayout.SOUTH);
	//└─────────────────────────────────────────────────────────────────────────────────┘
	//┌────────────────────────────────버튼 부착────────────────────────────────────────┐
		for(int i = 7; i <= 9; i++) {//1번째 줄
			jpButtons.add(jbButtons[i]);
		}
		jpButtons.add(jbButtons[13]);
		jpButtons.add(jbButtons[17]);
		
		for(int i = 4; i <= 6; i++) { //2번째 줄
			jpButtons.add(jbButtons[i]);
		}
		jpButtons.add(jbButtons[14]);
		jpButtons.add(jbButtons[18]);
		
		for(int i = 1; i <= 3; i++) { //3번째 줄
			jpButtons.add(jbButtons[i]);
		}
		jpButtons.add(jbButtons[15]);
		jpButtons.add(jbButtons[19]);
		
		jpButtons.add(jbButtons[0]); //4번째 줄
		jpButtons.add(jbButtons[10]);
		jpButtons.add(jbButtons[11]);
		jpButtons.add(jbButtons[16]);
		jpButtons.add(jbButtons[12]);
		
		jpBackspace.add(jbButtons[20]); //뒤로가기 버튼
		jpControl.add(jbButtons[21]); //CE 버튼
		jpControl.add(jbButtons[21]); //C 버튼
	//└─────────────────────────────────────────────────────────────────────────────────┘
	//┌────────────────────────────────리스너 장착──────────────────────────────────────┐
		for(int i = 0; i < jbButtons.length; i++) {
			jbButtons[i].addActionListener(this);
		}
	//└─────────────────────────────────────────────────────────────────────────────────┘
		Process.clearAll();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		for(int i = 0; i < jbButtons.length; i++) {
			if(e.getSource() == jbButtons[i]) {
				switch(i) {
				case 0: case 1: case 2: case 3: case 4: case 5: case 6: case 7: case 8: case 9:
					Display.addDigitToDisplay(i); break;
				case 10: Process.signChange(); break;
				case 11: Process.addDecimalPoint(); break;
				case 12: Process.equals(); break;
				case 13: Process.operator("/"); break;
				case 14: Process.operator("x"); break;
				case 15: Process.operator("-"); break;
				case 16: Process.operator("+"); break;
				}
			}
		}
	}

}
