package chap08.sec01.exam05;

import chap08.sec01.exam04.RemoteControl;

public class SmartTelevision implements RemoteControl, Searchable {
	private int volume;
	
	@Override
	public void turnON() {
		System.out.println("티비를 켭니다.");
	}

	@Override
	public void turnOff() {
		System.out.println("티비를 끕니다.");	
	}

	@Override
	public void setVolume(int volume) {
		if(volume > RemoteControl.MAX_VOLUME) {
			this.volume = RemoteControl.MAX_VOLUME;
		} else if(volume < RemoteControl.MIN_VOLUME) {
			this.volume = RemoteControl.MIN_VOLUME;
		} else {
			this.volume = volume;
		}
		System.out.println("현재 티비 볼륨: " + this.volume);
	}

	@Override
	public void search(String url) {
		System.out.println(url + "을 검색합니다.");
	}
	

}
