package chap08.sec01.exam04;

public interface RemoteControl {
	int MAX_VOLUME = 10;
	int MIN_VOLUME = 0;
	
	void turnON();
	void turnOff();
	void setVolume(int volume);
}
