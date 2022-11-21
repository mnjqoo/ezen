
package object.basic;

public class MemberCallExam {
	
	int iv = 10; //멤버 변수 - 인스턴스 변수
	static int cv = 20; //멤버 변수 - 클래스 변수
	int iv2 = cv;
	//static int cv2 = iv; // 클래스 변수는 인스턴스 변수를 사용할 수 없다.
	static int cv2 = new MemberCallExam().iv;
	
	static void staticMethod1() {
		System.out.println(cv);
		//System.out.println(iv);
		MemberCallExam c = new MemberCallExam();
		System.out.println(c.iv);
	}
	void instanceMethod1() {
		System.out.println(cv);
		System.out.println(iv);
	}
	static void staticMethod2() {
		staticMethod1();
		//instanceMethod1();
		MemberCallExam c = new MemberCallExam();
		c.instanceMethod1();
	}
	void instanceMethod2() {
		staticMethod1();
		instanceMethod1();
	}

}
