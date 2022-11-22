package object.tv.tv2;

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
		
		Tv t1 = new Tv();
		Tv t2 = new Tv();
		
		System.out.println("t1의 채널 : " + t1.channel);
		System.out.println("t2의 채널 : " + t2.channel);
		
		t1.channel = 11;
		System.out.println("t1의 채널 : " + t1.channel);
		System.out.println("t2의 채널 : " + t2.channel);

	} //public static void main(String[] args)

} //public class TvExam
