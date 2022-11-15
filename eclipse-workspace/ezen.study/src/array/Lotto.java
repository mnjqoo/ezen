package array;

public class Lotto 
{

	public static void main(String[] args) 
	{
		int		num		= 6;			// 볼의 개수
		int[]	ball	= new int[num];	// 랜덤하게 추출한 정수를 저장할 변수
		
		for(int i = 0; i < num; i++)
			System.out.print(ball[i] + "\t");
		System.out.println();

		// 1 부터 45 사이의 정수(1포함, 45포함)
		// 1. 중복되지 않은 6개의 정수를 추출하여 배열에 저장한다.
		for(int room = 0; room < num; room++) {
			// 임의의 정수를 추출하여 배열 ball에 저장한다.
			ball[room] = (int)(Math.random() * 45 + 1);
			if(room > 0) { // 첫 번째 방은 비교할 대상이 없으므로 중복작업검사에서 제외시킨다.
				for(int j = 0; j < room; j++) {
					if(ball[j] == ball[room]) {
						room--;	// room = room - 1;
						break;
					}
				}
			}
		}
		
		for(int i = 0; i < num; i++)
			System.out.print(ball[i] + "\t");
		
		// 2. 오름차순으로 정렬하여 보여주세요!
		for(int i = 0; i < ball.length-1; i++) { // 2방씩 비교하므로 방크기-1 만큼만 비교한다.
			for(int j = 0; j < ball.length-1-i; j++) { // 1줄 작업이 끝나면 끝의 방은 비교에서 제외시킨다.
				if(ball[j] > ball[j+1]) { // 왼쪽 방의 값이 오른쪽 방의 값보다 크면 값을 서로 바꾼다.
					int	imsi	= ball[j];
					ball[j]		= ball[j+1];
					ball[j+1]	= imsi;
				}
			}
		}
		
		// 3. 정렬이 끝난 내용을 출력한다.
		System.out.println();
		for(int i = 0; i < num; i++)
			System.out.print(ball[i] + "\t");
		
	} // End - public static void main(String[] args)

} // End - public class Lotto











