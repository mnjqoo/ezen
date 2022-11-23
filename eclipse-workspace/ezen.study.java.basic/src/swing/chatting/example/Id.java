package swing.chatting.example;

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.net.Socket;
//===================================================================
class Id extends JFrame implements ActionListener {
	
	static JTextField tf = new JTextField(8); //8자를 쓸 수 있는 텍스트창
	JButton btn = new JButton("입장");
	
	WriteClass wt; //입력한 메세지를 서버로 전송하는 클래스
	ClientFrame cf; //채팅창
	
	public Id() {};
	public Id(WriteClass wt, ClientFrame cf) {
		super("아이디");
		this.wt = wt;
		this.cf = cf;
		
		setLayout(new FlowLayout());
		add(new JLabel("아이디"));
		add(tf);
		add(btn);
		
		btn.addActionListener(this);
		
		setBounds(400, 200, 250, 200);
		setVisible(true);
	}
	
	static public String getId() { //입장할 떄 입력한 아이디를 알아내는 메소드
		return tf.getText();
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		wt.sendMessage(); //입장하였다는 메세지를 다른 클라이언트들에게 보낸다.
		cf.isFirst = false; //입장 하였으므로 isFirst를 false로 변경한다.
		cf.setVisible(true); //채팅창을 화면에 보이게 한다.
		this.dispose(); //로그인 창은 사라지게 한다.
	}
	
}
