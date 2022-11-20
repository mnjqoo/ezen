package array;

public class ArrayExam03 {

	public static void main(String[] args) {
		
		int[] number = new int[10];
		
		for(int i = 0; i < number.length; i++) {
			number[i] = i; // 배열을 0-9의 숫자로 초기화 한다.
		}
		
		// 0-9사이의 임의의 정수를 구해서 그 값을 배열에 순서대로 대입힌다.
		
		for (int i = 0; i < number.length; i++) {
			int num = (int)(Math.random()*10);
			int a = 0;
			
			if(i == num) {
				i--;
			} else {
			a = number[i];
			//System.out.print(number[i] + ", ");
			number[i] = number[num];
			//System.out.print(number[i] + ", ");
			number[num] = a;
			//System.out.println(number[num]);
			}
		
			
		}
		
		for(int i = 0; i < number.length; i++) {
			System.out.print(number[i] + " ");
		}
		System.out.println();
		
		for (int i = 0; i < 100; i++) {
			int num = (int)(Math.random()*10);
			
			int imsi = number [0];
			number[0] = number[num];
			number[num] = imsi;
		}
		
		for(int i = 0; i < number.length; i++) {
			System.out.print(number[i] + " ");
		}
		

	}

}
