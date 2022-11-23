package swing.chatting.example;

import java.io.*;
import java.net.*;

public class ReadThread extends Thread { //서버가 보내오는 문자열을 전송받는 Thread
	
	Socket socket;
	ClientFrame cf;
	
	public ReadThread(Socket socket, ClientFrame cf) {
		this.socket = socket;
		this.cf = cf;
	}
	
	@Override
	public void run() {
		BufferedReader br = null;
		
		try {
			br = new BufferedReader(new InputStreamReader(socket.getInputStream())); //서버로부터 전송되는 문자열을 받는 입력 스트림 객체 생성
			while(true) { 
				String msg = br.readLine(); //소켓으로 부터 문자열을 읽는다.
				if(msg == null) { //접속이 끊기면 Thread를 종료한다.
					System.out.println("접속이 끊겼습니다."); break;
				}
				cf.txtA.append(msg + "\n"); //전송 받은 문자열을 채팅창에 보여준다.
			}
		} catch (IOException ie) {
			System.out.println(ie.getMessage());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
