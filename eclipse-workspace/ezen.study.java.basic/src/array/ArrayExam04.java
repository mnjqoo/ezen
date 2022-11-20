package array;

public class ArrayExam04 {

	public static void main(String[] args) {
		
		// 45개의 정수값을 저장하기 위한 배열을 생성한다.
		int[] ball = new int[45];
		
		//배열의 각 요소에 1-45의 값을 순서대로 저장한다.
		for(int i = 0; i < ball.length; i++) {
			ball[i] = i + 1;
			//System.out.print(ball[i] + " ");
		}
		
		int imsi = 0; // 두 값을 바꾸는데 사용할 변수
		int random = 0; // 임의의 정수를 추출하여 저장할 변수
		
		// 배열에 저장된 값이 잘 섞이도록 충분히 반복횟수를 크게 사용한다.
		// 배열의 첫번째 방의 값과 임의로 추출한 방의 값을 서로 바꾼다.
		// 배열 ball의 앞에서부터 6개 방의 값을 출력한다.
		
		for (int i = 0; i < 100; i++) {
			random = (int)(Math.random()*45);
			
			imsi = ball [0];
			ball[0] = ball[random];
			ball[random] = imsi;
		}
		
		for(int i = 0; i < 6; i++) {
			System.out.print(ball[i] + " ");
		}
		
	
	}

}
