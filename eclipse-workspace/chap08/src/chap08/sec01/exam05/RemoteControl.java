package chap08.sec01.exam05;

public interface RemoteControl {
	int MAX_VOLUME = 10;
	int MIN_VOLUME = 0;
	
	void turnOn();
	void turnOff();
	void setVolume();
}
