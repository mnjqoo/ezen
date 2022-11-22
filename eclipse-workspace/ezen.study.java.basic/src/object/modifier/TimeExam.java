package object.modifier;
//-----------------------------------------------------------------------------
class Time{
	private int hour;
	private int minute;
	private int second;
	Time(){}
	Time(int hour, int minute, int second){
		setHour(hour);
		setMinute(minute);
		setSecond(second);
	}
	public int getHour() {
		return hour;
	}
	public void setHour(int hour) {
		if(hour < 0 || hour > 23) return;
		this.hour = hour;
	}
	public int getMinute() {
		return minute;
	}
	public void setMinute(int minute) {
		if(minute < 0 || minute > 59) return;
		this.minute = minute;
	}
	public int getSecond() {
		return second;
	}
	public void setSecond(int second) {
		if(second < 0 || second > 59) return;
		this.second = second;
	}
	@Override
	public String toString() {
		return "Time [" + hour + "시 " + minute + "분 " + second + "초]";
	}
	
}
//-----------------------------------------------------------------------------
public class TimeExam {

	public static void main(String[] args) {
		Time t1 = new Time(14, 35, 30);
		System.out.println(t1);
		//현재 시간을 17시 24분 45초로 변경해보세요.
		t1.setHour(17);
		t1.setMinute(24);
		t1.setSecond(45);
		System.out.println(t1);
		//현재 시간을 1시간 뒤로 설정해주세요.
		t1.setHour(t1.getHour() + 1);
//		Time t2 = new Time(t1.getHour() + 1, t1.getMinute(), t1.getSecond());
//		t1 = t2;
		System.out.println(t1);
		

	}

}
//-----------------------------------------------------------------------------