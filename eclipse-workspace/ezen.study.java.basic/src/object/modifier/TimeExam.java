package object.modifier;

//-----------------------------------------------------------------------------------------------------------
// class Time
//-----------------------------------------------------------------------------------------------------------
class Time {
	private	int	hour;
	private	int	minute;
	private	int	second;
	
	Time() {}
	
	Time(int hour, int minute, int second) {
		setHour(hour);
		setMinute(minute);
		setSecond(second);
	}

	public int getHour() {
		return hour;
	}

	public void setHour(int hour) {
		if(hour < 0 || hour > 23)	return;
		this.hour = hour;
	}

	public int getMinute() {
		return minute;
	}

	public void setMinute(int minute) {
		if(minute < 0 || minute > 59)	return;
		this.minute = minute;
	}

	public int getSecond() {
		return second;
	}

	public void setSecond(int second) {
		if(second < 0 || second > 59)	return;
		this.second = second;
	}

	@Override
	public String toString() {
		return "Time [hour=" + hour + ", minute=" + minute + ", second=" + second + "]";
	}
	
} // ENd - class Time
//-----------------------------------------------------------------------------------------------------------
// public class TimeExam
//-----------------------------------------------------------------------------------------------------------
public class TimeExam {
	public static void main(String[] args) {
		Time t1 = new Time(14, 35, 30);
		System.out.println(t1);
		
		// 현재 시간을 17시 24분 45초로 변경을 해보세요.
		t1.setHour(17);
		t1.setMinute(24);
		t1.setSecond(45);
		System.out.println(t1);
		
		// 현재 시간을 1시간 뒤로 설정해주세요.
		System.out.println(t1.getHour() + "시");
		t1.setHour(t1.getHour() + 1);
		System.out.println(t1.getHour() + "시");
	}
} // End - public class TimeExam

















