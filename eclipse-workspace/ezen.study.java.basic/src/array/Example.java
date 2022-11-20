package array;

public class Example {

	public static void main(String[] args) {
		
		int[] ball = new int[45];
		for(int i = 0; i < ball.length; i++) {
			ball[i] = i + 1;
			//System.out.print(ball[i] + " ");
		}
		
		int imsi = 0; 
		int random = 0;
		
		for (int i = 0; i < 100; i++) {
			random = (int)(Math.random()*45);
			
			
			imsi = ball [0];
			ball[0] = ball[random];
			ball[random] = imsi;
		}
		
        System.out.println("1부터 45 사이의 각기 다른 6개의 숫자를 입력하세요.");
		
		java.util.Scanner s = new java.util.Scanner(System.in);
		int[] myNum = new int[6];
		for(int i = 0; i < myNum.length; i++) {
			myNum[i] = s.nextInt();
			//System.out.println(myNum[i]);
		}
		
		int count = 0;
		for(int i = 0; i < 6; i++) {
			for(int j = 0; j < myNum.length; j++) {
				if(ball[i] == myNum[j]) {
					count++;
				}
			}
		}
		System.out.println(count + "개 맞췄습니다.");
		System.out.print("당첨 번호는 ");
		
		for(int i = 0; i < 5; i++) {
			for(int j = 0; j < 5 - i; j++) {
				if(ball[j] > ball[j + 1]) {
					int imsi2 = ball[j];
					ball[j] = ball[j + 1];
					ball[j + 1] = imsi2;
					
				}
			}
		}
		
		for(int i = 0; i < 6; i++) {
			System.out.print(ball[i] + " ");
		}
		
		System.out.println(" 입니다.");

	}

}
