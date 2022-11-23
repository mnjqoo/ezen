package swing.chatting.example;

import java.io.IOException;
import java.net.*;

public class MultiChattingClient {

	public static void main(String[] args) {
		
		Socket socket = null;
		ClientFrame cf = null;
		
		try { //클라이언트와 접속할 서버의 IP주소와 PORT 번호로 socket을 생성해서 서버에 연결을 요청한다.
			socket = new Socket("192.168.4.172", 7777);
			System.out.println("서버와의 연결에 성공했습니다.");
			
			cf = new ClientFrame(socket); //채팅 화면을 띄운다.
			new ReadThread(socket, cf).start(); //서버로부터 메세지가 언제 도착할 지 모르므로, 수신하는 부분을 Thread로 구동시킨다.
		} catch(IOException ie) {
			System.out.println(ie.getMessage());
		}

	}

}
