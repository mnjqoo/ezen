package swing.basic;
import java.awt.*;
import javax.swing.*;
//==============================================================
public class NoLayoutExam extends JFrame {
	
	NoLayoutExam(){
		
		setTitle("배치관리자 없이 절대 위치에 컴포넌트를 배치하기");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container contentPane = getContentPane();
		contentPane.setLayout(null); //배치관리자를 제거한다.
		
		JLabel la = new JLabel("♣How are you?♣");
		la.setLocation(200, 60); //시작 위치(x, y)
		la.setSize(200, 22); //크기(폭, 높이)
		contentPane.add(la);
		
		//1-9개의 버튼을 좌측상단에서 우측하단으로 배치해주세요.
		//각 버튼들은 살짝 겹쳐지게 해주세요.
		
		for(int i = 1; i < 10; i++) {
			String str = Integer.toString(i);
			JButton button = new JButton(str);
			contentPane.add(button);
			button.setLocation((i*50), (i*50));
			button.setSize(200, 100);
		}
		
		setSize(400, 300);
		setVisible(true);
		
	}

	public static void main(String[] args) {
		
		new NoLayoutExam();

	}

}
//==============================================================