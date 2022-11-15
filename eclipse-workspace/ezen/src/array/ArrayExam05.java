package array;

public class ArrayExam05 {

	public static void main(String[] args) {
		int[] number = new int[10];
		
		for(int i = 0; i < number.length; i++) {
			System.out.print(number[i] = (int)(Math.random() * 10));
		}
		System.out.println();

		// 작은 숫자가 왼쪽에 오도록 정렬해주세요(오름차순)
		// (세로방향) 전체 작업은 2개씩 비교하므로 number.length보다 1작은 만큼만 한다.
		for(int i = 0; i < number.length-1; i++) {
			// (가로방향) number.length보다 1작은 만큼 작업을 하는데,
			//            한번 작업이 끝나면 작업 횟수를 1씩 감소시킨다.
			// -i => 가로방향의 작업이 한 번 끝나면 마지막 방은 다음 작업에서 제외시킨다.
			
			boolean changed = false;	// 자리 바꿈이 발생했는지를 체크하는 변수
			for(int j = 0; j < number.length-1-i; j++) {
				// 내림차순은 비교를 반대로 하면 된다. : if(number[j] < number[j+1]) {
				if(number[j] > number[j+1]) { // 오른쪽 방의 값이 왼쪽 방의 값보다 크면 교환한다.
					int	imsi		= number[j];
					number[j]		= number[j+1];
					number[j+1]		= imsi;
					changed			= true;
				}
			} // End - 가로방향
			if(!changed) break;	// 자리바꿈이 하나라도 없으면 반복문(세로방향)을 벗어나게 한다.
			
			for(int k = 0; k < number.length; k++)
				System.out.print(number[k]);
			System.out.println();
		} // End - 세로방향
		
	}

}





