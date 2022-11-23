package swing.event.event02;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

//===================================================================

//===================================================================
public class InnerClassListenerExam extends JFrame {
	
	InnerClassListenerExam(){
		setTitle("Action Event Listener");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Container c = getContentPane();
		c.setLayout(new FlowLayout());
		
		JButton btn = new JButton("Action");
		btn.addActionListener(new MyActionListener()); //Action Event Listener 등록
		c.add(btn);
		
		setSize(500, 400);
		setVisible(true);
	}
	
	private class MyActionListener implements ActionListener{ //내부 클래스로 Action Listener를 작성한다.

		@Override
		public void actionPerformed(ActionEvent e) {
			JButton btn = (JButton) e.getSource();
			
			if(btn.getText().equals("Action")) {
				btn.setText("액션");
			} else {
				btn.setText("Action");
			}
			//타이틀에 Action 또는 액션 이라고 나오게 해주세요.
			setTitle(btn.getText());
		}
		
	}

	public static void main(String[] args) {
		
		new InnerClassListenerExam();

	}

}
//===================================================================