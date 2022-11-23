package swing.bingo.bingo2;
import javax.swing.*;
import javax.swing.border.LineBorder;

import java.awt.*;
import java.awt.event.*;
//===================================================================
public class Bingo extends JFrame {
  //필드//
	final int SIZE = 5; //빙고판의 가로, 세로 크기
	JButton[] btnArr = null; //버튼을 가리키기 위한 참조변수
	String[] animal = { //버튼 위에 쓰여질 글자들
			"고양이", "강아지", "거북이", "토끼", "사자",
			"호랑이", "기린", "코끼리", "하마", "코뿔소",
			"부엉이", "돼지", "소", "펭귄", "독수리",
			"타조", "캥거루", "원숭이", "코알라", "다람쥐",
			"수달", "살쾡이", "두루미", "고라니" , "까치"
	};
	int[] bigNum = new int[SIZE * SIZE]; //버튼 위치에 숨겨져 있는 숫자를 담을 배열 변수
	int bingoCount = 0; //완성된 라인 수를 저장할 변수
	private boolean[][] btnOX = new boolean[SIZE][SIZE]; //빙고판의 체크 여부를 확인하기 위한 2차원 배열
  //중첩클래스//
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
			for(int i = 0; i < SIZE * SIZE; i++) {
				if((JButton) btn == btnArr[i]) { //눌려진 버튼을 찾았으면
					btnArr[i].setFont(new Font("Arial", Font.BOLD + Font.ITALIC, 28));
					btnArr[i].setText(String.valueOf(bigNum[i]));
					btnOX[i / SIZE][i % SIZE] = true; // 현재 누른 버튼에 해당하는 index값을 2차원으로 바꾼 후 true로 만든다.
				}
			}
			displayOX(); //빙고판별판의 상태를 콘솔에 출력한다.
			btn.setBackground(Color.gray); //눌려진 버튼의 배경색을 변경한다.
			if(checkBingo() == true) { //빙고가 완성되었는지 확인한다.
				System.out.println("빙고!!!!\n축하합니다!!!");
			}
		}
		
	}
  //생성자//
	Bingo(String title){
		super(title);
		setLayout(new GridLayout(SIZE, SIZE)); //컨텐트팬에 5x5의 작업관리자를 설정한다.
		MyEventHandler handler = new MyEventHandler();
		addWindowListener(handler);
		btnArr = new JButton[SIZE * SIZE]; //25개의 버튼을 담을 객체배열을 만든다.
		
		for(int i = 0; i < bigNum.length; i++) { //버튼 위치에 숨겨져있는 배열 변수를 만들고, 중복되지 않는 임의의 정수를 저장한다.
			bigNum[i] = (int)(Math.random() * (SIZE * SIZE) + 1);; //버튼에 랜덤한 정수값을 저장
			for(int j = 0; j <= i; j++) {
				if(i != j) {
					if(bigNum[i] == bigNum[j]) {
						i--;
					}
				}
			}
		}
		
		for(int i = 0; i < btnArr.length; i++) { //JFrame에 버튼을 추가한다.
			btnArr[i] = new JButton(animal[i]);
			btnArr[i].addActionListener(handler); //버튼 하나하나마다 리스너를 장착한다.
			add(btnArr[i]);
			btnArr[i].setBackground(Color.pink);
		}
		
		setBounds(500, 200, 500, 500);
		setVisible(true);
	}
  //메소드//
	public void displayOX() { //빙고판별판
		
		for(int i = 0; i < btnOX.length; i++) {
			for(int j = 0; j < btnOX[i].length; j++) {
//				if(btnOX[i][j] == true) {
//					System.out.print("●");
//				} else {
//					System.out.print("X");
//				}	
				System.out.print(btnOX[i][j] ? "●" : "X");
				
			}
			System.out.println();
		}
	}
	
	public boolean checkBingo() {
		this.bingoCount = 0; //완성된 라인의 갯수
		int garoCount = 0; //가로로 완성된 갯수
		int seroCount = 0; //세로로 완성된 갯수
		int crossCount1 = 0; //우하향 대각선으로 완성된 갯수
		int crossCount2 = 0; //우상향 대각선으로 완성된 갯수
		for(int i = 0; i < btnOX.length; i++) {
			garoCount = 0;
			seroCount = 0;
			for(int j = 0; j < btnOX[i].length; j++){
				if(btnOX[i][j] == true) { //가로 검사
					garoCount++;
				}
				if(btnOX[j][i] == true) { //세로 검사
					seroCount++;
				}
				if(i == j & btnOX[i][j] == true) { //우하향 대각선 검사
					crossCount1++;
				}
				if(i + j == (SIZE - 1) & btnOX[i][j] == true) { //우상향 대각선 검사
					crossCount2++;
				}
			}
			if(garoCount == SIZE) { //가로빙고
				for(int k = i * SIZE ; k < (i * SIZE) + SIZE; k++) {
					btnArr[k].setBackground(Color.yellow);
				}
				bingoCount++;
			}
			if(seroCount == SIZE) { //세로빙고
				for(int k = i ; k <= btnArr.length - (SIZE - i); k += SIZE) {
					btnArr[k].setBackground(Color.yellow);
				}
				bingoCount++;
			}
			if(crossCount1 == SIZE) { //우하향빙고
				for(int k = 0 ; k <= btnArr.length; k += (SIZE + 1)) {
					btnArr[k].setBackground(Color.yellow);
				}
				bingoCount++;
			}
			if(crossCount2 == SIZE) { //우상향빙고
				for(int k = (SIZE - 1) ; k <= SIZE * (SIZE - 1); k += (SIZE - 1)) {
					btnArr[k].setBackground(Color.yellow);
				}
				bingoCount++;
			}
		}
		return (bingoCount >= SIZE);
	}
 //┌─────────────────────────────────────────────────────────────────┐
	public static void main(String[] args) {

		new Bingo("빙고게임");

	}
 //└─────────────────────────────────────────────────────────────────┘
}
//===================================================================