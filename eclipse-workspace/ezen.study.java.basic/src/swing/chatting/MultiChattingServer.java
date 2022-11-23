package swing.chatting;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Vector;

//===================================================================
public class MultiChattingServer {

	public static void main(String[] args) {
		
		ServerSocket server = null;
		Socket socket = null;
		
		//클라이언트와 연결된 소켓들을 배열처럼 저장할 벡터 객체를 생성한다.
		Vector vec = new Vector<Socket>();
		try {
			server = new ServerSocket(7777); //포트번호를 가지고 서버소켓을 생성한다.
			while(true) {
				System.out.println("클라이언트가 접속하기를 기다리는 중 입니다.");
				socket = server.accept();
				vec.add(socket); //클라이언트와 연결된 소켓의 정보를 벡터에 저장한다.
				new EchoThread(socket, vec).start(); //클라이언트와 통신할 Thread를 구동시킨다.
			}
		} catch (IOException ie) {
			System.out.println(ie.getMessage());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
//===================================================================