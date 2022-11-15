package array;

public class ArrayExam08 {

	public static void main(String[] args) {
		int[]	oldNum	= {1,2,3,4,5};
		int[]	newNum	= new int[10];
		
		for(int i = 0; i < oldNum.length; i++) {
			newNum[i] = oldNum[i]; // 배열 oldNum의 값을 배열 newNum에 저장한다.
		}
		for(int i = 0; i < newNum.length; i++) {
			System.out.print(newNum[i] + " ");
		}
		
		
		// newNum = oldNum; 주소값을 복사한다.
		/*
		newNum = oldNum;
		for(int i = 0; i < 10; i++) {
			System.out.print(newNum[i]);
		}
		*/

	}

}
