package swing.event.event03;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
//===================================================================

public class AnonymousClassListenerExam extends JFrame {

	AnonymousClassListenerExam(){
		setTitle("Action Event Listener");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Container c = getContentPane();
		c.setLayout(new FlowLayout());
		
		JButton btn = new JButton("Action");
		btn.addActionListener(new ActionListener() { //익명의 클래스로 Action Event Listener 작성

			@Override
			public void actionPerformed(ActionEvent e) {
				JButton btn = (JButton) e.getSource();
				
				if(btn.getText().equals("Action")) {
					btn.setText("액션");
				} else {
					btn.setText("Action");
				}
			}
			
		}); 
		
		c.add(btn);
		
		setSize(500, 400);
		setVisible(true);
	}
	
	public static void main(String[] args) {
		
		new AnonymousClassListenerExam();

	}

}
