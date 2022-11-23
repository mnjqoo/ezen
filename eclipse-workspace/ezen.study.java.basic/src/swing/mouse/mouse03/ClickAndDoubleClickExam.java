package swing.mouse.mouse03;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
//===================================================================

public class ClickAndDoubleClickExam extends JFrame {
	
	JPanel contentPane = new JPanel();
	JLabel la = new JLabel();
	
	ClickAndDoubleClickExam() {
		setTitle("Click과 Doublic Click");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		setContentPane(contentPane);
		contentPane.addMouseListener(new MyMouseListener());
		
		setSize(600, 400);
		setVisible(true);
	}
	

	class MyMouseListener extends MouseAdapter {
		
		@Override
		public void mouseClicked(MouseEvent e) {
			if(e.getClickCount() == 2) {
				System.out.println("마우스를 더블 클릭하셨습니다.");
				//0-255사이의 임의의 정수를 추출하여 배경색을 만든다.
				int r = (int)(Math.random() * 256);
				int g = (int)(Math.random() * 256);
				int b = (int)(Math.random() * 256);
				
				JPanel jp = (JPanel) e.getSource();
				jp.setBackground(new Color(r, g, b));
			} else if (e.getClickCount() == 1) {
				
			}
		}
	}

	public static void main(String[] args) {
		
		new ClickAndDoubleClickExam();

	}

}
//===================================================================