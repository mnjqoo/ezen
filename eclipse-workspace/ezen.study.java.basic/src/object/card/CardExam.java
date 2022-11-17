package object.card;

//-----------------------------------------------------------------------------------------------------------
// class Card
//-----------------------------------------------------------------------------------------------------------
class Card {
	String	kind;					// 카드의 무늬 - 인스턴스 변수
	int		number;					// 카드의 숫자 - 인스턴스 변수
	static	int		width	= 120;	// 카드의 폭   - 클래스   변수
	static	int		height	= 260;	// 카드의 높이 - 클래스   변수
	
	static int plus(int num1, int num2) {
		System.out.println(num1 + "과 " + num2 + "을 더합니다.");
		return num1 + num2;
	}
} // End - Card

//-----------------------------------------------------------------------------------------------------------
// public class CardExam
//-----------------------------------------------------------------------------------------------------------
public class CardExam {
	public static void main(String[] args) {
		System.out.println("카드의 폭   : " + Card.width);
		System.out.println("카드의 높이 : " + Card.height);
		
		int result = Card.plus(1, 10);
		System.out.println("더하기 결과 : " + result);

		Card	c1	= new Card();
		c1.kind		= "Heard";
		c1.number	= 4;
		
		Card	c2	= new Card();
		c2.kind		= "Diamond";
		c2.number	= 9;
		
		System.out.println("C1 => " + c1.kind + "," + c1.number + "," + c1.width + "," + c1.height);
		System.out.println("C2 => " + c2.kind + "," + c2.number + "," + c2.width + "," + c2.height);

		c1.width	= 200;	c1.kind	= "클로버";	c1.number = 10;
		c2.height	= 400;
		
		System.out.println("C1 => " + c1.kind + "," + c1.number + "," + c1.width + "," + c1.height);
		System.out.println("C2 => " + c2.kind + "," + c2.number + "," + c2.width + "," + c2.height);
	}

} // End - public class CardExam




