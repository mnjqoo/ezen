package swing.mouse.mouse01;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
//===================================================================
public class MouseListenerExam extends JFrame {
	
	class MyMouseListener extends MouseAdapter {

		@Override
		public void mousePressed(MouseEvent e) { //마우스 버튼이 눌러질 때
		
			int x = e.getX(); //이벤트가 일어난 곳의 x좌표값
			int y = e.getY();
			la.setLocation(x, y);
		}

	}
	
	JLabel la;
	
	MouseListenerExam() {
		
		setTitle("Mouse Event Example");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel contentPane = new JPanel();
		setContentPane(contentPane);
		setLayout(null);
		
		la = new JLabel("안녕");
		la.setSize(50, 22);
		la.setLocation(30, 22);
		contentPane.add(la);
		
		contentPane.addMouseListener(new MyMouseListener());
		
		setSize(800, 600);
		setVisible(true);
	}
	
	public static void main(String[] args) {
		
		new MouseListenerExam();
		
	}

}
//===================================================================