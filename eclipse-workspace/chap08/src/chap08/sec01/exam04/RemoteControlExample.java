package chap08.sec01.exam04;

public class RemoteControlExample {

	public static void main(String[] args) {
		RemoteControl rc = new Audio();
		rc.turnON();
		rc.setVolume(5);
		rc.setVolume(15);
		rc.turnOff();

	}

}
