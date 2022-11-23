package swing.basic;

import java.awt.*;

import javax.swing.*;

public class ContentPaneExam extends JFrame {
	
	ContentPaneExam() {
		setTitle("ContentPane 알아보기");
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //닫기 버튼 활성화
		
		Container contentPane = getContentPane();	//작업영역 알아내기
		
		contentPane.setBackground(Color.lightGray);
		
		contentPane.setLayout(new FlowLayout(FlowLayout.LEFT, 50, 70)); //배치 관리자를 FlowLayout으로 한다. (수평간격, 수직간격)
		
		contentPane.add(new JButton("OK"));
		contentPane.add(new JButton("Cancle"));
		contentPane.add(new JButton("Ignore"));
		contentPane.add(new JButton("Reset"));
		contentPane.add(new JButton("buy"));
		
		setSize(400, 200);
		setVisible(true);
	}

	public static void main(String[] args) {
		
		new ContentPaneExam();

	}

}
