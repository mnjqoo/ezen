package object.tv.tv4;

class Tv{
	boolean power; //전원상태(on/off)
	int channel; //채널
	int volumn;
	
	void power() {
	   power = !power;
	}
	void channelUp() {
		++channel;
	}
	void channelDown() {
		--channel;
	}
}

class CaptionTv extends Tv{
	boolean caption; //자막 상태(on/off)
	
	void displayCaption(String text){
		if(caption) { //자막 상태가 on(true)일 때만 자막을 보여준다.
			System.out.println(text);
		}
	}
	public String toString() {
		return "저는 캡션티비 입니다. 부모님이 주신 것을 오버라이딩 하였습니다.";
	}
}

public class CaptionTvExam {

	public static void main(String[] args) {
		CaptionTv ctv = new CaptionTv();
		System.out.println(ctv);
		ctv.channel = 10; //조상 클래스로 부터 상속받은 멤버변수
		ctv.channelUp(); //조상 클래스로 부터 상속받은 멤버(인스턴스 메소드)
		System.out.println(ctv.channel);
		ctv.caption = true;
		ctv.displayCaption("안녕하세요");
		ctv.volumn = 10;
		

	}

}
