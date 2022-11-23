package swing.bingo.bingo1;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
//===================================================================
public class Bingo extends JFrame {
	JPanel contentPane = new JPanel();
	JLabel la = new JLabel();
	final int SIZE = 5; //빙고판의 크기
	JButton[] btnArr = null; //버튼을 가리키기 위한 참조변수
	String[] animal = {//버튼 위에 쓰여질 글자들
			"고양이", "강아지", "거북이", "토끼", "사자",
			"호랑이", "기린", "코끼리", "하마", "코뿔소",
			"부엉이", "돼지", "소", "펭귄", "독수리",
			"타조", "캥거루", "원숭이", "코알라", "다람쥐",
			"수달", "살쾡이", "두루미", "고라니" , "까치"
	};
	
	Bingo(String title) {
		super(title);

		setLayout(new GridLayout(SIZE, SIZE)); //컨텐트팬에 5x5의 작업관리자를 설정한다.
		//이벤트 생성
		MyEventHandler handler = new MyEventHandler();
		addWindowListener(handler);
		
		btnArr = new JButton[SIZE * SIZE]; //25개의 버튼을 담을 객체배열을 만든다.
		//JFrame에 버튼을 생성해서 부착한다.
		for(int i = 0; i < btnArr.length; i ++) {
			//버튼을 만들 때 배열 animal의 값을 버튼의 이름으로 사용한다.
			//버튼을 JFrame에 부착한다.
			btnArr[i] = new JButton(animal[i]);
			btnArr[i].addActionListener(handler);
			add(btnArr[i]);
			btnArr[i].setBackground(Color.pink);
		}
		
		setBounds(500, 200, 500, 500); //x, y, width, height
		setVisible(true);
	}
	
	class MyEventHandler extends WindowAdapter implements ActionListener {

		@Override
		public void windowClosing(WindowEvent e) { //x버튼을 누르면 프로그램을 종료시킨다.
			e.getWindow().setVisible(false);
			e.getWindow().dispose();
			System.exit(0);
		}
		
		@Override
		public void actionPerformed(ActionEvent e) {
			JButton btn = (JButton) e.getSource(); //어떤 버튼이 눌려졌는지 알아낸다.
			System.out.println(btn.getText()); //눌려진 버튼의 글자를 콘솔에 출력한다.
			btn.setBackground(Color.gray); //눌려진 버튼의 배경색을 변경한다.
		}
		
	}

	public static void main(String[] args) {
		
		new Bingo("빙고 게임");

	}

}
//===================================================================