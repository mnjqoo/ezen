package swing.basic;
//=====================================================================================
import java.awt.*;
import javax.swing.*;
//=====================================================================================
public class MyFirstFrame extends JFrame { //JFrame을 상속받은 MyFirstFrame
	
	MyFirstFrame(){
		setTitle("나의 첫번째 프레임 만들기"); //생성자에서 타이틀을 설정한다.
		setSize(500, 300); //프레임의 크기(폭, 높이)
		setVisible(true); //프레임이 화면에 보이게 한다.
	}

	public static void main(String[] args) {
		
		MyFirstFrame mf = new MyFirstFrame();
		

	}

}
//=====================================================================================