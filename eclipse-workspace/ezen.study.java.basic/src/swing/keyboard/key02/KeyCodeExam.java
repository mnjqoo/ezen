package swing.keyboard.key02;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
//===================================================================
public class KeyCodeExam extends JFrame {
	
	JPanel contentPane = new JPanel();
	JLabel la = new JLabel();
	
	KeyCodeExam() {
		
		setTitle("F1 : 초록색, % : 노란색");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		setContentPane(contentPane);
		contentPane.addKeyListener(new MyKeyListener());
		contentPane.add(la);
		
		setSize(300, 200);
		setVisible(true);
		
		contentPane.requestFocus(); //Key Event가 발생하려면 컴포넌트가 반드시 포커스를 가지고 있어야 한다.
		contentPane.setFocusable(true);
		
	}
	
	class MyKeyListener extends KeyAdapter {
		
		public void KeyPressed(KeyEvent e) {
			la.setText(e.getKeyText(e.getKeyCode()));
			if(e.getKeyChar() == '%') {
				contentPane.setBackground(Color.CYAN);
			} else if(e.getKeyCode() == KeyEvent.VK_F1) {
				contentPane.setBackground(Color.DARK_GRAY);
			}
		}
	}
	public static void main(String[] args) {
		
		new KeyCodeExam();

	}

}
