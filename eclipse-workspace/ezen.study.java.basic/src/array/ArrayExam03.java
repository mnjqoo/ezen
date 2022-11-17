package array;

public class ArrayExam03 {

	public static void main(String[] args) {
		int[] number = new int[10];
		
		for(int i = 0; i < number.length; i++) {
			number[i] = i;	// 배열을 0 ~ 9의 숫자로 초기화한다.
			System.out.print(number[i] + " ");
		}
		System.out.println();
		
		// 0 ~ 9 사이의 임의의 정수를 구해서,
		// 구한 정수에 해당하는 값과 맨처음 방의 값을 교환한다.
		for(int i = 0; i < 100; i++) {
			int random = (int)(Math.random() * 10);
			
			int	imsi		= number[0];
			number[0]		= number[random];
			number[random]	= imsi;
		}
		
		// 섞여진 배열 방의 값을 출력한다.
		for(int i = 0; i < number.length; i++) {
			System.out.print(number[i] + " ");
		}
	}

}




