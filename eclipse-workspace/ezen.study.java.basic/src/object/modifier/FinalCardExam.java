package object.modifier;

//-----------------------------------------------------------------------------------------------------------
// final : 상수
//-----------------------------------------------------------------------------------------------------------
class Card {
	final	int		NUMBER;			// 상수를 선언과 함께 초기화하지 않고,
	final	String	KIND;			// 생성자에서 단 한번만 초기화할 수 있다.
	static	int		width	= 100;	// 카드의 폭과 높이는 모든 카드에서 길이가 같으므로
	static	int		height	= 260;	// static을 붙여서 공동으로 사용한다.
			int		score	= 99;	// 인스턴스 변수
	
	Card(String kind, int number) {	// 매개변수로 넘겨받은 값으로
		this.NUMBER	= number;		// 카드의 숫자와 무늬를 초기화한다.
		KIND		= kind;
	}
	
	Card() {
		this("다이아몬드", 7);
	}

	@Override
	public String toString() {
		return "Card [카드의 폭 => " + width + ", 카드의 높이 => " + height 
				+ ", 카드의 숫자 => " + NUMBER + ", 카드의 무늬 => " + KIND + "]";
	}
} // End - class Card
//-----------------------------------------------------------------------------------------------------------
// public class FinalCardExam
//-----------------------------------------------------------------------------------------------------------
public class FinalCardExam {
	public static void main(String[] args) {
		System.out.println("카드의 폭   : " + Card.width);
		System.out.println("카드의 높이 : " + Card.height);
		System.out.println("static이 붙은 변수는 클래스를 생성하지 않고도 사용할 수 있습니다.");
		
		// 인스턴스 변수는 클래스를 생성하고 난 후에 사용할 수가 있다.
		// System.out.println("인스턴스 변수 : " + Card.score);
		
		Card c1 = new Card();
		System.out.println(c1);
		
		Card c2 = new Card("클로버", 5);
		System.out.println(c2);
		
		c2.width = 120;
		System.out.println(c1);	// c1.width => 100
		System.out.println(c2);	// c2.width => 120
		
		// c2.NUMBER = 3; 상수는 값을 변경할 수가 없습니다.
		
	}

} // End - public class FinalCardExam
















