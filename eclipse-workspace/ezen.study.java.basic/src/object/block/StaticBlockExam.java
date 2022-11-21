package object.block;

class A {
	static int num;
}

public class StaticBlockExam {
	
	static int[] arr = new int[10]; //명시적 초기화를 통해서 배열 arr을 생성한다.
	
	static {
		for(int i = 0; i < arr.length; i++) { //클래스 초기화 블럭을 사용하여 배열의 각 요소들을 임의의 값으로 저장한다.
			arr[i] = (int)(Math.random()*10) + 1;
		}
	}
	
	public static void main(String[] args) {
		
		for(int i = 0; i < arr.length; i++) {
			System.out.println(arr[i]);
		}
		
        //A a = new A();
        //a.num =10;
		A.num = 10;
		
		
	}

}
