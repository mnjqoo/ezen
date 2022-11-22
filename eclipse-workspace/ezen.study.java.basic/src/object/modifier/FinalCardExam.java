package object.modifier;
//-------------------------------------------------------------------------------
class Card{
	final int NUMBER; //상수를 선언과 함께 초기화 하지 않고 생성자에서 단 한번만 초기화 할 수 있다. 
	final String KIND;		
	static int width = 100; // 카드의 폭과 높이는 모든 카드에서 같으므로 static을 사용한다.
	static int height = 260;
	int score; // 인스턴스 변수
	Card(String kind, int num){
		KIND = kind; NUMBER = num;
	}
	
	Card(){
		this("다이아몬드", 7);
	}

	@Override
	public String toString() {
		return "Card [NUMBER=" + NUMBER + ", KIND=" + KIND + ", width=" + width + ", height=" + height +"]";
	}
	
	
}
//---------------------------------------------------------------------------
public class FinalCardExam {

	public static void main(String[] args) {
		System.out.println("카드의 폭: " + Card.width);
		System.out.println("카드의 높이: " + Card.height);
		System.out.println("static이 붙은 변수는 클래스를 생성하지 않고도 사용할 수 있습니다.");
		//System.out.println("인스턴스 변수: " + Card.score);
		
		Card c1 = new Card();
		Card c2 = new Card("클로버", 5);
		System.out.println(c2);
		c2.width = 120;
		System.out.println(c1);
		System.out.println(c2);
		
	}

}
//-------------------------------------------------------------------------------------