package array;

public class ArrayExam06 {

	public static void main(String[] args) {
		
		int[] number = new int[10]; //임의의 정수를 저장할 변수
		int[] counter = new int[10]; // 각 숫자가 몇개인지를 저장할 변수
		
		// 0-9 사이의 임의의 정수를 추출하여 number방에 저장한다.
		
		for(int i = 0; i < number.length; i++) {
			number[i] = (int)(Math.random()* 10);
			System.out.print(number[i] + " ");
		}
		
		System.out.println();
		
		// 0-9 사이의 정수가 각각 몇개인지 알려주세요.
		
		for(int i = 0; i < number.length; i++) {
			for(int j = 0; j <number.length; j++) {
				if(number[j] == i) {
					counter[i]++;	
				}
			}
			System.out.print(counter[i] + " ");
		}
		
		System.out.println();
		System.out.println("===================");
		
		for(int i = 0; i < number.length; i++) {
			number[i] = (int)(Math.random()* 10);
			System.out.print(number[i] + " ");
		}
		
		System.out.println();
		
		for(int i = 0; i < number.length; i++) {
			int room = number[i];
			counter[room] +=1; // number[i]의 값이 counter배열의 방번호이다.
			System.out.print(counter[i] + " ");
		}

	}

}
