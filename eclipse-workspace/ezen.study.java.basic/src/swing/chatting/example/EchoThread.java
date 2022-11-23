package swing.chatting.example;

import java.io.*;
import java.net.Socket;
import java.util.Vector;

public class EchoThread extends Thread {
	
	Socket socket;
	Vector<Socket> vec;
	
	public EchoThread (Socket socket, Vector<Socket> vec) {
		this.socket = socket;
		this.vec = vec;
	}
	
	public void sendMessage(String str) {
		try {
			for(Socket socket : vec) { // for(int i = 0; i < vec.size(); i ++)
				if(socket != this.socket) { //데이터를 보내준 클라이언트를 제외하고 //socket은 벡터 명단에서 추출한 socket, this.socket은 Thread와 연결된 socket
					PrintWriter pw = new PrintWriter(socket.getOutputStream(), true); //출력 Stream 생성
					pw.println(str); //Stream을 통해 메세지를 송신한다.
					pw.flush();
					//※여기서 작업하는 socket들은 다른 클라이언트들이므로 닫으면 안된다.
				}
			}
		} catch(IOException ie) {
			System.out.println(ie.getMessage());
		}
	}
	
	@Override
	public void run() { //전송받은 문자열을 다른 클라이언트들에게 보내준다.
		BufferedReader br = null;
		
		try {
			br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			String str = null;
			
			while(true) { //접속된 클라이언트로 부터 메세지가 오면, 접속된 다른 사람들에게 메세지를 보내준다.
				str = br.readLine(); //클라이언트로 부터 문자열 받기
				if(str == null) { //소켓의 젒고이 끊어지면
					vec.remove(socket); //벡터(연결명단)에서 제외시킨다.
					break; //연결된 상대가 없어졌으므로 Thread를 끝낸다.
				}
				sendMessage(str);
			}
		} catch(IOException ie) {
			System.out.println(ie.getMessage());
		} finally {
			try { //하나의 소켓과 연결이 끊어졌으므로 Thread를 종료하기 전에 사용한 자원들을 닫는다.
				if(br != null) br.close();
				if(socket != null) socket.close();
			} catch(IOException ie) {
				System.out.println(ie.getMessage());
			}
		}
	}
}
