package object.card.extend;

//-----------------------------------------------------------------------------------------------------------
// 카드 클래스
//-----------------------------------------------------------------------------------------------------------
class Card {
	static 	final 	int	KIND_MAX	= 4;	// 카드의 무늬 종류 수
	static	final	int	NUM_MAX		= 13;	// 무늬별 카드의 수
	
	static	final	int	SPADE		= 4;
	static	final	int	DIAMOND		= 3;
	static	final	int	HEART		= 2;
	static	final	int	CLOVER		= 1;
	
	int	kind;	// 카드의 무늬
	int	number;	// 카드의 숫자
	
	Card(int kind, int number) {
		this.kind	= kind;
		this.number	= number;
	}
	Card() {
		this(SPADE, 1);
	}
	@Override
	public String toString() {
		String	kind	= "";
		String	number	= "";
		
		switch(this.kind) {
			case 4:		kind = "SPADE";		break;
			case 3:		kind = "DIAMOND";	break;
			case 2:		kind = "HEART";		break;
			case 1:		kind = "CLOVER";	break;
		}
		switch(this.number) {
			case 13:	number = "K";	break;
			case 12:	number = "Q";	break;
			case 11:	number = "J";	break;
			default:	number = this.number + "";
		}
		return "Card [카드의 무늬=>" + kind + ", 카드의 숫자=>" + number + "]";
	}
} // End - class Card
//-----------------------------------------------------------------------------------------------------------
// Deck 클래스
//-----------------------------------------------------------------------------------------------------------
class Deck {
	final	int	CARD_NUM	= 52;	// 카드한벌의 총 개수
	Card	c[]	= new Card[CARD_NUM];
	
	Deck() {	// Deck이 생성될 때 카드한벌을 초기화한다.
		int idx = 0;
		
		for(int k = Card.KIND_MAX; k > 0; k--) {	// 카드 무늬의 개수(4개)
			for(int n = 1; n <= Card.NUM_MAX; n++) {	// 카드 무늬당 13번씩 작업한다.
				c[idx++] = new Card(k, n);
			}
		}
	}
	
	Card pick(int index) {	// 지정된 위치(index)에 있는 카드를 한 장 뽑는다.
		if(0 <= index && index < CARD_NUM) {
			return c[index];
		} else {
			return pick();
		}
	}
	
	Card pick() {	// 임의의 카드를 한 장 선택한다.
		int index = (int)(Math.random() * 52);	// 0 부터 51 사이의 임의의 정수를 추출한다.
		return pick(index);
	}
	
	void shuffle() {	// 카드의 순서를 섞는다.
		for(int n = 0; n < 1000; n++) {	// 섞는 횟수
			int	r = (int)(Math.random() * CARD_NUM);
			Card temp;
			temp	= c[0];
			c[0]	= c[r];
			c[r]	= temp;
		}
	}
	
} // End - class Deck
//-----------------------------------------------------------------------------------------------------------
// public class CardDeckExam
//-----------------------------------------------------------------------------------------------------------
public class CardDeckExam {

	public static void main(String[] args) {

		Deck d	= new Deck();	// (Deck() 생성자를 통해서) 카드 한벌을 Deck에 만들어 놓는다.
		Card c	= d.pick(0);	// 카드를 섞기 전에 맨 위의 카드를 한 장 뽑는다.
		System.out.println(c);
		
		d.shuffle();			// 카드를 섞는다.
		c	= d.pick(0);		// 카드를 섞은 후에 맨 위의 카드를 한 장 뽑는다.
		System.out.println(c);
	}

} // End - public class CardDeckExam












