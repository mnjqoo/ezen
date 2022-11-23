package swing.event.event01;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
//===================================================================
class MyActionListener implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent e) {
		JButton btn = (JButton) e.getSource();
		
		if(btn.getText().equals("Action")) {
			btn.setText("액션");
		} else {
			btn.setText("Action");
		}
	}
	
}
//====================================================================
public class IndependentClassListenerExam extends JFrame {
	
	IndependentClassListenerExam() {
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
	
	public static void main(String[] args) {
		
		new IndependentClassListenerExam();

	}

}
//====================================================================