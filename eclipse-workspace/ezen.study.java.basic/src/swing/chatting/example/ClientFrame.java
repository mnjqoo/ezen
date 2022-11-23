package swing.chatting.example;
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.net.Socket;
//===================================================================
public class ClientFrame extends JFrame implements ActionListener {
	
	WriteClass wc;
	Socket socket;
	
	JTextArea txtA = new JTextArea(); //대화 내용 보이는 창
	JTextField txtF = new JTextField(16); //대화 내용 입력 필드
	JButton btnTransfer = new JButton("전송"); //대화 내용 전송 버튼
	JButton btnExit = new JButton("닫기"); //종료 버튼
	JPanel pl = new JPanel(); //메세지 입력, 전송, 닫기 부분을 올릴 판넬
	boolean isFirst = true; //처음 입장인지 확인할 변수
	
	public ClientFrame(Socket socket) {
		super("대화 나누기");
		this.socket = socket;
		wc = new WriteClass(this);
		new Id(wc, this); //로그인 화면 생성
		
		txtA.setFont(new Font("굴림", Font.BOLD, 15));
		txtA.setBackground(Color.orange);
		add("Center", txtA); //contentPane에 borderLayout으로 부착
		
		pl.add(txtF); //판넬에 버튼 부착
		pl.add(btnTransfer);
		pl.add(btnExit);
		add("South", pl); //contentPane에 boderLayout으로 부착
		
		btnTransfer.addActionListener(this); //리스너 장착
		btnExit.addActionListener(this);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setBounds(400, 200, 350, 400);
		setVisible(false); //대화나누기 창을 숨긴다.
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		String id = Id.getId(); //메세지를 전송한 사람의 아이디
		if(e.getSource() == btnTransfer) {
			if(txtF.getText().equals("")){ //메세지가 없이 전송버튼을 눌렀을 경우
				return; //데이터를 전송하지 않는다.
			} 
			txtA.append("[" + id + "]" + txtF.getText() + "\n"); //자신이 입력한 메세지는 자신의 대화창에 바로 보여준다. / 다음 메세지를 받기 위해 미리 줄바꿈을 한다.
			wc.sendMessage(); //내가 입력한 메세지를 서버에 전송한다.
			txtF.setText(""); //메세지 전송 후 입력했던 메세지를 필드에서 지운다.
		} else {
			this.dispose();
		}
	}

}
//===================================================================