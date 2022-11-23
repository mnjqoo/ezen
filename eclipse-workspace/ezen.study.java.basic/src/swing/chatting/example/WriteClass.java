package swing.chatting.example;

import java.io.*;
import java.net.*;

public class WriteClass { //키보드로 전송할 메세지를 받아서 서버로 전송하는 클래스

		Socket socket;
		ClientFrame cf;
		String msg;
		String id;
		
		public WriteClass(ClientFrame cf) {
			this.cf = cf;
			this.socket = cf.socket;
		}
		
		public void getId() { //아이디를 알아내는 메소드
			id = Id.getId();
		}
		
		public void sendMessage() { //메세지를 보내는 메소드
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));//키보드로부터 메세지를 읽어오기 위한 입력 스트림 객체를 생성한다.
			PrintWriter pw = null;
			
			try { 
				pw = new PrintWriter(socket.getOutputStream(), true); //서버로 메세지를 전송하기 위한 출력 스트림 객체를 생성한다.
				if(cf.isFirst) { //처음 입장 할 때 나의 id와 함께 ip주소를 보내준다.
					InetAddress iaddr = socket.getLocalAddress();
					String ip = iaddr.getHostAddress();
					getId(); //입장 할 때 입력한 아이디를 가져온다.
					msg = "[" + id + "] 님이 입장하셨습니다. (" + ip + ")";
				} else {
					msg = "[" + id + "]" + cf.txtF.getText();
					// 입장 할 때 저장된 id 값이 있기 때문에 getId();를 사용하지 않아도 된다.
				}
				
				pw.println(msg); //출력 스트림을 통해 서버로 메세지를 보낸다.
				
			} catch (IOException ie) {
				System.out.println(ie.getMessage());
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				try {
					if(br != null) br.close();
				} catch (IOException ie) {
					System.out.println(ie.getMessage());
				}
			}
		}
}
