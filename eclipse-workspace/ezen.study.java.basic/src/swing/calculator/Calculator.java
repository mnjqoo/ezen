package swing.calculator;
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
//===================================================================

public class Calculator extends JFrame implements ActionListener {
 
 //필드
	final int MAX_INPUT_LENGTH = 20; //화면에 보이는 숫자 최대 자리 수
	final int INPUT_MODE = 0; //입력 상태
	final int RESULT_MODE = 1; //출력 상태
	final int ERROR_MODE = 2; //에러 상태
	int displayMode;
	boolean clearOnNextDigit; //계산기가 처음 시작 되거나, 어떤 연산이 끝난 후 값을 true로 한다. 이때 숫자 버튼을 누르면 그 전의 값은 보이지 않게 하고 새로운 숫자를 보여준다.
	double lastNumber; //연산 전의 값을 저장할 변수
	String lastOperator; //지금 누른 연산자 바로 전의 연산자를 저장할 변수 ex) 12 에서 + 를 누르면 lastOperator 는 0, 12 + 3 에서 다음 연산자 - 를 누르면 lastOperator는 + 값을 가진다.
	
	JLabel jlbOutput;
	JButton jbtnButtons[];
	JPanel jplMaster, jplBackspace, jplControl;
	
	Font f12 = new Font("Times New Roman", 0, 22);
	
 //생성자//
	public Calculator() {
		
		setBackground(Color.lightGray); //전체 계산기의 배경색
		
		jplMaster = new JPanel();
		//출력 창 디자인
		jlbOutput = new JLabel("0"); //출력 창 생성
		jlbOutput.setBackground(Color.orange); //출력창 배경 색 지정
		jlbOutput.setOpaque(true); //투명도 조절. true = 불투명, false = 투명
		jlbOutput.setFont(new Font("Serif", Font.PLAIN, 30)); //폰트, 스타일, 크기
		getContentPane().add(jlbOutput, BorderLayout.NORTH); //가장 윗쪽에 출력창을 배치한다.
		//버튼 생성
		jbtnButtons = new JButton[23]; //23개의 모든 버튼을 가리키는 참조 변수 배열 생성
		JPanel jplButtons = new JPanel(); //버튼들이 올라갈 Panel 생성
		for(int i = 0; i <= 9; i++) { //0-9 숫자 버튼 생성
			jbtnButtons[i] = new JButton(String.valueOf(i));
		}
		jbtnButtons[10] = new JButton("+/-"); //각종 기능 버튼 생성
		jbtnButtons[11] = new JButton(".");
		jbtnButtons[12] = new JButton("=");
		jbtnButtons[13] = new JButton("/");
		jbtnButtons[14] = new JButton("x");
		jbtnButtons[15] = new JButton("-");
		jbtnButtons[16] = new JButton("+");
		jbtnButtons[17] = new JButton("sqrt");
		jbtnButtons[18] = new JButton("1/x");
		jbtnButtons[19] = new JButton("%");
		jplBackspace = new JPanel(); //백스페이스 버튼은 별도 Panel에 추가한다.
		jplBackspace.setLayout(new GridLayout(1, 1, 2, 2));
		jbtnButtons[20] = new JButton("Bakcspace");
		jplBackspace.add(jbtnButtons[20]);
		jplControl = new JPanel();; //CE, C 버튼은 별도의 Panel에 추가한다.
		jplControl.setLayout(new GridLayout(1,2,2,2));
		jbtnButtons[21] = new JButton("CE");
		jbtnButtons[22] = new JButton("C");
		jplControl.add(jbtnButtons[21]);
		jplControl.add(jbtnButtons[22]);
		//버튼 디자인
		for(int i = 0; i <jbtnButtons.length; i++) { //숫자 버튼들의 글자색은 파란색, 기능 버튼들의 글자는 마젠타로 한다.
			jbtnButtons[i].setFont(f12);
			if(i < 10) { //숫자버튼
				jbtnButtons[i].setForeground(Color.blue);
			} else { //기능 버튼
				jbtnButtons[i].setForeground(Color.magenta);
			}
		}
		//버튼 부착
		jplButtons.setLayout(new GridLayout(4, 5, 2, 2)); //숫자 버튼을 grid 형태로 배열 설정
		for(int i = 7; i <= 9; i++) { //숫자 7-9 부착
			jplButtons.add(jbtnButtons[i]);
		}
		jplButtons.add(jbtnButtons[13]); //나누기 버튼 부착
		jplButtons.add(jbtnButtons[17]); //sqrt 버튼 부착
		for(int i = 4; i <= 6; i++) { //숫자 4-6 부착
			jplButtons.add(jbtnButtons[i]);
		}
		jplButtons.add(jbtnButtons[14]); //x버튼 부착
		jplButtons.add(jbtnButtons[18]);
		for(int i = 1; i <= 3; i++) { //숫자 1-3 부착
			jplButtons.add(jbtnButtons[i]);
		}
		jplButtons.add(jbtnButtons[15]); //-버튼 부착
		jplButtons.add(jbtnButtons[19]); //%버튼 부착
		jplButtons.add(jbtnButtons[0]); //숫자 0 부착
		jplButtons.add(jbtnButtons[10]); //+/- 부착
		jplButtons.add(jbtnButtons[11]); // . 부착
		jplButtons.add(jbtnButtons[16]); //+ 부착
		jplButtons.add(jbtnButtons[12]); //= 부착
		//판넬들을 하나의 BorderLayout 배열로 생성
		jplMaster.setLayout(new BorderLayout());
		jplMaster.add(jplBackspace, BorderLayout.WEST);
		jplMaster.add(jplControl, BorderLayout.EAST);
		jplMaster.add(jplButtons, BorderLayout.SOUTH);
		//위의 판넬을 최종 배치
		getContentPane().add(jplMaster, BorderLayout.SOUTH);
		
		requestFocus(); //포커스 설정
		getContentPane().setFocusable(true);
		
		for(int i = 0; i <jbtnButtons.length; i++) {
			jbtnButtons[i].addActionListener(this);
		}
		clearAll(); //계산기 초기화
		
		addWindowListener(new WindowAdapter() { //우측 상단 x버튼 활성화
			public void windowCloseing(WindowEvent e) {
				e.getWindow().setVisible(false);
				e.getWindow().dispose();
				System.exit(0);
			}
		});
	}
	
 //메소드	
	void setDisplayString(String s) { //출력창에 문자를 출력한다.
		jlbOutput.setText(s);
	}
	
	String getDisplayString() { //출력창의 문자를 가져온다.
		return jlbOutput.getText();
	}
	
	void clearAll() { //계산기를 초기화 한다.
		setDisplayString("0");
		lastOperator = "0";
		lastNumber = 0;
		displayMode = INPUT_MODE;
		clearOnNextDigit = true;
	}
	void addDigitToDisplay(int digit) { //숫자키를 누르면 현재값 뒤에 붙여서 출력한다. 최대 20자(MAX_INPUT_LENGTH)까지
		if(clearOnNextDigit == true) {
			setDisplayString(""); //출력창을 지운다.
		}
		
		String inputString = getDisplayString();
		if(inputString.indexOf("0") == 0) { //0번째 숫자가 0이면 0 뒤의 모든 값을 가져온다. substring(x, y) : x번째부터 y번째까지의 값
			inputString = inputString.substring(1);
		}
		if((!inputString.equals("0") || digit > 0) & inputString.length() < MAX_INPUT_LENGTH) {
			setDisplayString(inputString + digit);
		}
		displayMode =INPUT_MODE;
		clearOnNextDigit = false;
	}
	void processSignChange() { //출력창의 부호를 바꾼다.
		if(displayMode == INPUT_MODE) { //입력모드
			String input = getDisplayString();
			if(input.length() > 0 && !input.equals("0")) {
				if(input.indexOf("-") == 0) { //"-"가 0번째에 있는지 없으면 -1을 반환
					setDisplayString(input.substring(1)); //"-"를 뺀 뒤의 값을 출력
				} else { //양수면
					setDisplayString("-" + input);; //"-"를 붙여서 출력
				}
			}
		} else if(displayMode == RESULT_MODE) { //결과모드
			double numberInDisplay = getNumberInDisplay();
			if(numberInDisplay != 0) {
				displayResult(-numberInDisplay);
			}
		}
	}
	double getNumberInDisplay() { //출력창의 값을 가져온다.
		String input = jlbOutput.getText();
		return Double.parseDouble(input);
	}
	void displayResult(double result) {
		setDisplayString(Double.toString(result));
		lastNumber = result;
		displayMode = RESULT_MODE;
		clearOnNextDigit = true;
	}
	void addDecimalPoint() {
		displayMode = INPUT_MODE;
		if(clearOnNextDigit) {
			setDisplayString("");
		}
		String inputString = getDisplayString();
		if(inputString.indexOf(".") < 0) { //소수점이 하나도 없으면
			setDisplayString(inputString + ".");
		}
	}
	void processEquals() {
		double result = 0;
		if(displayMode != ERROR_MODE) {
			try {
				result = processLastOperator();
				displayResult(result);
			} catch(DivideByZeroException e) {
				displayError("0으로 나눌 수 없습니다.");
			}
			lastOperator = "0";
		}
	}
	double processLastOperator() throws DivideByZeroException {
		double result = 0;
		double numberInDisplay = getNumberInDisplay(); //첫번째값, 연산자, 두번째값 중 두번째값을 가져온다.
		if(lastOperator.equals("/")) {
			if(numberInDisplay == 0) throw (new DivideByZeroException());
			else result = lastNumber / numberInDisplay;
		}
		if(lastOperator.equals("*")) {
			result = lastNumber * numberInDisplay;
		}
		if(lastOperator.equals("+")) {
			result = lastNumber + numberInDisplay;
		}
		if(lastOperator.equals("-")) {
			result = lastNumber - numberInDisplay;
		}
		return result;
	}
	void displayError(String errorMessage) { //에러 발생 시 메세지 출력
		setDisplayString(errorMessage);
		lastNumber = 0;
		displayMode = ERROR_MODE;
		clearOnNextDigit = true;
	}
	void processOperator(String op) { //사칙연산 버튼을 눌렀을 경우 처리하는 메소드
		if(displayMode != ERROR_MODE) {
			double numberInDisplay = getNumberInDisplay();
			System.out.println("lastOperator: " + lastOperator);
			if(!lastOperator.equals("0")) {
				try {
					double result = processLastOperator();
					displayResult(result);
					lastNumber = result;
				} catch (DivideByZeroException e) {
					e.printStackTrace();
				}
			} else { //화면에 있는 값을 lastNumber에 저장한다.
				lastNumber = numberInDisplay;
			}
			clearOnNextDigit = true;
			lastOperator = op;
		}
	}
	void processSqrt() { //제곱
		if(displayMode != ERROR_MODE) {
			double result = 0;
			try { //root값이 -이면 허수이므로 처리가 안된다.
				if(getDisplayString().indexOf("-") == 0) {
					displayError("SQRT에 -값은 사용할 수 없습니다.");
				} else { //Math.sqrt를 이용해 제곱근을 구한다.
					result = Math.sqrt(getNumberInDisplay());
					displayResult(result);
				}
				
			} catch (Exception e) {
				displayError("SQRT에 유효한 값이 아닙니다.");
				displayMode = ERROR_MODE;
			}
		}
	}
	void processReverse() {
		if(displayMode != ERROR_MODE) {
			try {
				double result = 0;
				if(getNumberInDisplay() == 0) {
					displayError("0으로 나눌 수 없습니다.");
				}
				result = 1 / getNumberInDisplay();
				displayResult(result);
			} catch (Exception e) {
				displayError("0으로 나눌 수 없습니다.");
				displayMode = ERROR_MODE;
			}
		}
	}
	void processPercentage() {
		if(displayMode != ERROR_MODE) {
			try {
				double result = getNumberInDisplay() / 100;
				displayResult(result);
			} catch (Exception e) {
				displayError("유효한 값이 아닙니다.");
				displayMode = ERROR_MODE;
			}
		}
	}
	void processBackspace() { //뒤로가기 버튼을 눌렀을 때
		if(displayMode != ERROR_MODE) { //마지막 글자를 제외한 나머지 글자를 보여준다.
			setDisplayString(getDisplayString().substring(0, getDisplayString().length() - 1));
			if(getDisplayString().length() < 1) {
				setDisplayString("0");
			}
		}
	}
	void clearExisting() {
		setDisplayString("0");
		clearOnNextDigit = true;
		displayMode = INPUT_MODE;
	}
	@Override
	public void actionPerformed(ActionEvent e) { //이벤트 처리
		double result = 0; //연산 결과를 저장할 변수
		
		for(int i = 0; i < jbtnButtons.length; i++) { //각 키 별로 이벤트를 처리하는 반복문
			if(e.getSource() == jbtnButtons[i]) {
				switch(i) {
				case 0: case 1: case 2: case 3: case 4: case 5: case 6: case 7: case 8: case 9:  
					addDigitToDisplay(i); break;
				case 10: processSignChange(); break;
				case 11: addDecimalPoint(); break;
				case 12: processEquals(); break;
				case 13: processOperator("/"); break;
				case 14: processOperator("*"); break;
				case 15: processOperator("-"); break;
				case 16: processOperator("+"); break;
				case 17: processSqrt(); break;
				case 18: processReverse(); break;
				case 19: processPercentage(); break;
				case 20: processBackspace(); break;
				case 21: clearExisting(); break;
				case 22: clearAll(); break;
				}
			} 
		}
		
	}

}
//===================================================================
class DivideByZeroException extends Exception {
	
  //생성자
	public DivideByZeroException() {
		super();
		System.out.println("DivideByZeroException super()");
	}
	public DivideByZeroException(String str) {
		super(str);
		System.out.println("DivideByZeroException super(str)");
	}
}