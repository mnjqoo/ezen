package swing.basic;

import java.awt.*;
import javax.swing.*;
//==============================================================
public class BorderLayoutExam extends JFrame {
	
	BorderLayoutExam() {
		setTitle("BorderLayout 공부하기");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Container contentPane = getContentPane();	//작업영역 알아내기
		contentPane.setLayout(new BorderLayout(30, 20)); //수평, 수직 간격
		
		contentPane.add(new JButton("계산"), BorderLayout.CENTER);
		contentPane.add(new JButton("더하기"), BorderLayout.WEST);
		contentPane.add(new JButton("빼기"), BorderLayout.NORTH);
		contentPane.add(new JButton("곱하기"), BorderLayout.EAST);
		contentPane.add(new JButton("나누기"), BorderLayout.SOUTH);
		
		setSize(500, 400);
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new BorderLayoutExam();
	}

}
//==============================================================