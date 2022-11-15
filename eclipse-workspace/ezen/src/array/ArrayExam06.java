package array;

public class ArrayExam06 {

	public static void main(String[] args) {
		int[]	number	= new int[10];	// 임의의 정수를 저장할 변수
		int[]	counter	= new int[10];	// 각 숫자가 몇개인지를 저장할 변수
		
		// 0 ~ 9 사이의 임의의 정수를 추출하여 number방에 저장한다.
		number[0] = (int)(Math.random() * 10);
		number[1] = (int)(Math.random() * 10);
		number[2] = (int)(Math.random() * 10);
		number[3] = (int)(Math.random() * 10);
		number[4] = (int)(Math.random() * 10);
		number[5] = (int)(Math.random() * 10);
		number[6] = (int)(Math.random() * 10);
		number[7] = (int)(Math.random() * 10);
		number[8] = (int)(Math.random() * 10);
		number[9] = (int)(Math.random() * 10);
		
		// 0 ~ 9 사이의 임의의 정수를 추출하여 number방에 저장한다.
		for(int i = 0; i < number.length; i++)
			System.out.print(number[i] = (int)(Math.random() * 10));
		System.out.println();
		
		// 0 ~ 9 사이의 정수가 각각 몇 개인지 알려주세요.
		for(int i = 0; i < number.length; i++) { // number.length개의 방을 검사한다.
			// number[i];의 값이 counter배열의 방번호이다. 
			// int room = number[i]; 
			// counter[room]++; // counter[room] += 1;
			counter[number[i]]++;
		}
		
		// 0 ~ 9 사이의 정수가 각각 몇 개인지 출력한다.
		for(int i = 0; i < number.length; i++)
			System.out.println(i + "의 개수 : " + counter[i] + "개");
		
	}

}











