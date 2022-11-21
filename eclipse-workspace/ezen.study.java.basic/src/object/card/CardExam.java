package object.card;

class Card{
	String kind; //카드 무늬 - 인스턴스 변수
	int number; //카드 숫자 - 인스턴스 변수
	static int width = 120; //카드 폭 - 클래스 변수
	static int height = 260; //카드 높이 - 클래스 변수
	
}

public class CardExam {

	public static void main(String[] args) {
		
		System.out.println(Card.width);
		System.out.println(Card.height);
		
		Card c1 = new Card();
		c1.kind = "Heart";
		c1.number = 4;
		
		Card c2 = new Card();
		c2.kind = "Diamond";
		c2.number = 9;
		
		System.out.println("c1 => " + c1.kind + ", " + c1.number + ", " + c1.width + ", " + c1.height);
		System.out.println("c1 => " + c2.kind + ", " + c2.number + ", " + c2.width + ", " + c2.height);
		
		c1.width = 100;
		c2.height = 400;
		System.out.println("c1 => " + c1.kind + ", " + c1.number + ", " + c1.width + ", " + c1.height);
		System.out.println("c1 => " + c2.kind + ", " + c2.number + ", " + c2.width + ", " + c2.height);
		
	}

}
