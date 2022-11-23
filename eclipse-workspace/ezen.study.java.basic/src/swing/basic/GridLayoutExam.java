package swing.basic;
import java.awt.*;
import javax.swing.*;
//==============================================================
public class GridLayoutExam extends JFrame {
	GridLayoutExam(){
		super("GridLayout 배워보기");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Container contentPane = getContentPane();	//작업영역 알아내기
		contentPane.setLayout(new GridLayout(1, 10)); 
		
		for(int i = 1; i <= 10; i++) {
			String j = String.valueOf(i);
			JButton button = new JButton(j);
			contentPane.add(button);
		}
		
		
		setSize(500, 400);
		setVisible(true);
	}
	public static void main(String[] args) {
		new GridLayoutExam();

	}

}
//==============================================================