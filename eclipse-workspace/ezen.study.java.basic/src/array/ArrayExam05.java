package array;

public class ArrayExam05 {

	public static void main(String[] args) {
		
		int[] number = new int[10];
		
//		for(int i = 0; i < number.length; i++) {
//			number[i] = (int)(Math.random() * 10);
//			System.out.print(number[i] + " ");
//		}
//		// 작은 숫자가 왼쪽에 오도록 정렬해주세요(오름차순)
//		System.out.println();
//		
//		for(int i = 0; i < number.length - 1; i++) {
//			for(int j = 0; j < number.length - 1; j++) {
//				if(number[j] > number[j + 1]) {
//					int imsi = number[j];
//					number[j] = number[j + 1];
//					number[j + 1] = imsi;
//				}
//			}
//		}
//		for(int i = 0; i < number.length; i++) {
//			System.out.print(number[i] + " ");
//		}
//		
//		System.out.println();
//		
		for(int i = 0; i < number.length; i++) {
			number[i] = (int)(Math.random() * 10);
			System.out.print(number[i] + " ");
		}
		
		System.out.println();
		
		
		for(int i = 0; i < number.length - 1; i++) {
			// (가로방향) number.length 보다 1 작은 만큼 작업을 하는데 한번 작업이 끝나면 작업 횟수를 1씩 감소시킨다.
			// i > 가로방향의 작업이 한번 끝나면 마지막 방은 다음 작업에서 제외시킨다.
			boolean changed = false; //자리 바꿈이 발생했는지를 체크하는 변수
			
			for(int j = 0; j < number.length - 1 - i; j++) {
				if(number[j] > number[j + 1]) {
					int imsi = number[j];
					number[j] = number[j + 1];
					number[j + 1] = imsi;
					changed = true;
					
				}
				
			}
			if(!changed) break;
			
			for(int k = 0; k < number.length; k++) {
			System.out.print(number[k]);
			}
			System.out.println();
			
		    
		}
		
		
		
		
	}

}
