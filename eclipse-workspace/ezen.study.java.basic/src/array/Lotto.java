package array;

public class Lotto {

	public static void main(String[] args) {
		
		int num = 6; // 볼의 개수
		int[] ball = new int[num]; //랜덤하게 추출한 정수를 저장할 변수
		
		// 1부터 45 사이의 중복되지 않은 6개의 정수를 추출하여 배열에 저장한다.
		
		for(int i = 0; i < num; i++) {
			ball[i] = (int)(Math.random() * 45) +1;
			if(i > 0) {
				for(int j = 0; j < i; j++) {
				    if(ball[i] == ball[j]) {
						i--;
						break;
					}
					
				}
			}	
		}
		
		// 오름차순으로 정렬하여 보여주세요
		
		for(int i = 0; i < num - 1; i++) { //2개의 방씩 비교 하므로 방 갯수 -1 만큼 비교.
			for(int j = 0; j < num - 1 - i; j++) { // 1줄 작업이 끝나면 끝이 방은 비교에서 제외시킨다.
				if(ball[j] > ball[j + 1]) { //왼쪽 방의 값이 오른쪽 방의 값보다 크면 값을 바꾼다.
					int imsi = ball[j];
					ball[j] = ball[j + 1];
					ball[j + 1] = imsi;
					
				}
			}
		}
		
		for(int i = 0; i < num; i++) {
			System.out.print(ball[i] + " ");
		}
		
	}

}
