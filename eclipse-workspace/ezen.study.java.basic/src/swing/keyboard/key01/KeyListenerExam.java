package swing.keyboard.key01;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
//===================================================================
public class KeyListenerExam extends JFrame {
	
	JPanel contentPane = new JPanel();
	JLabel[] keyMessage;
	
	KeyListenerExam() {
		
		setTitle("KeyListener Example");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		setContentPane(contentPane);
		contentPane.addKeyListener(new MyKeyListener());
		
		keyMessage = new JLabel[3];
		keyMessage[0] = new JLabel(" getKeyCode() ");
		keyMessage[1] = new JLabel(" getKeyChar() ");
		keyMessage[2] = new JLabel(" getKeyText() ");
		
		for(int i = 0; i < keyMessage.length; i++) {
			contentPane.add(keyMessage[i]);
			keyMessage[i].setOpaque(true); //컴포넌트에 배경색을 지정하기 위해서 컴포넌트가 불투명함을 설정
			keyMessage[i].setBackground(Color.orange);
		}
		
		setSize(300, 200);
		contentPane.setBackground(Color.pink);
		setVisible(true);
		contentPane.requestFocus(); //Panel에 포커스를 준다.
	}
	
	class MyKeyListener extends KeyAdapter {
		
		public void keyPressed(KeyEvent e) {
			int keyCode = e.getKeyCode();
			char keyChar = e.getKeyChar();
			
			keyMessage[0].setText(Integer.toString(keyCode));
			keyMessage[1].setText(Character.toString(keyChar));
			keyMessage[2].setText(e.getKeyText(keyCode));
		}
	}
	
	public static void main(String[] args) {
		
		new KeyListenerExam();

	}

}
//===================================================================