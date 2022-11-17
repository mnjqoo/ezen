package object.basic;

public class MemberCallExam {

			int	iv	= 10;	// 멤버변수 - 인스턴스 변수
	static	int cv	= 20;	// 멤버변수 - 클래스   변수
	
			int iv2	= cv;	// 가능하다.
	//static	int	cv2 = iv;	// 에러. 클래스 변수는 인스턴스 변수를 사용할 수가 없다.
	static	int	cv2 = new MemberCallExam().iv;	// 이처럼 객체를 생성해야 사용이 가능하다.
	
	static void staticMethod1() {
		System.out.println(cv);
		//System.out.println(iv);	// 에러. 클래스메서드에서 인스턴스 변수 사용불가.
		MemberCallExam c = new MemberCallExam();
		System.out.println(c.iv);	// 객체를 생성한 후에야 인스턴스 변수를 참조할 수 있다.
	}
	
	void instanceMethod1() {
		System.out.println(cv);
		System.out.println(iv);	// 인스턴스 메서드에서 인스턴스변수를 바로 사용이 가능하다.
	}
	
	static void staticMethod2() {
		staticMethod1();
		//instanceMethod1(); // 에러. 클래스메서드에서는 인스턴스메서드를 호출할 수가 없다.
		MemberCallExam c = new MemberCallExam();
		c.instanceMethod1();	// 인스턴스를 생성한 후에 호출할 수가 있다.
	}
	
	void instanceMethod2() {	// 인스턴스 메서드에서는 인스턴스 메서드와 클래스 메서드를
		staticMethod1();		// 모두 인스턴스 생성없이 바로 호출이 가능하다.
		instanceMethod1();
	}
	
	
} // End - public class MemberCallExam














