package swing.mouse.mouse02;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
//===================================================================
public class MouseListenerAllExam extends JFrame {
	
	JPanel contentPane = new JPanel();
	JLabel la = new JLabel();
		
	MouseListenerAllExam() {
		setTitle("MouseListener와 MouseMotionListener 연습");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setContentPane(contentPane);
		contentPane.addMouseListener(new MyMouseListener());
		contentPane.addMouseMotionListener(new MyMouseListener());
		
		la = new JLabel("No Mouse Event");
		contentPane.add(la);
		
		setSize(400, 240);
		setVisible(true);
	}
	
	class MyMouseListener implements MouseListener, MouseMotionListener {

		@Override
		public void mouseDragged(MouseEvent e) {
			la.setText("MouseDragged ▶ " + e.getX() + ", " + e.getY());
			JPanel jp = (JPanel) e.getSource();
			jp.setBackground(Color.yellow);
		}
		@Override
		public void mouseMoved(MouseEvent e) {
			la.setText("MouseMoved ▶ " + e.getX() + ", " + e.getY());
			JPanel jp = (JPanel) e.getSource();
			jp.setBackground(Color.CYAN);
		}
		//
		@Override
		public void mouseClicked(MouseEvent e) {}
		@Override
		public void mousePressed(MouseEvent e) {
			la.setText("MousePress ▶ " + e.getX() + ", " + e.getY());
			JPanel jp = (JPanel) e.getSource();
			jp.setBackground(Color.RED);
		}
		@Override
		public void mouseReleased(MouseEvent e) {
			la.setText("MouseRealeased ▶ " + e.getX() + ", " + e.getY());
			JPanel jp = (JPanel) e.getSource();
			jp.setBackground(Color.green);
		}
		@Override
		public void mouseEntered(MouseEvent e) {
			JPanel jp = (JPanel) e.getSource();
			jp.setBackground(Color.pink);
		}
		@Override
		public void mouseExited(MouseEvent e) {
			JPanel jp = (JPanel) e.getSource();
			jp.setBackground(Color.yellow);
		}		
	}
	public static void main(String[] args) {
		
		new MouseListenerAllExam();

	}

}
//===================================================================