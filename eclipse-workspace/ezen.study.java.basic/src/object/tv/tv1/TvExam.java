package object.tv.tv1;

class Tv{
	// 멤버 변수
	String color; //색깔
	boolean power; //on/off
	int channel; //채널
	// 기능
	void power() { power =! power; }
	void channelUp() { ++channel; }
	void channelDown() { --channel; }
} //class Tv
//===================================================================================

public class TvExam {

	public static void main(String[] args) {
		
		Tv t;
		t = new Tv();
		
		System.out.println("채널 : " + t.channel);
		t.channel = 11;
		System.out.println("현재 채널은 " + t.channel + "입니다.");
		t.channelDown();
		System.out.println("현재 채널은 " + t.channel + "입니다.");
		t.channelUp();
		System.out.println("현재 채널은 " + t.channel + "입니다.");

	} //public static void main(String[] args)

} //public class TvExam
