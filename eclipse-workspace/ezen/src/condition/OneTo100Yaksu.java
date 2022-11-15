package condition;

public class OneTo100Yaksu {

	public static void main(String[] args) {
		// 1부터 100까지 각 정수들의 약수를 모두 구해봅시다.
		// A라는 수를 B라는 수로 나누어 나머지가 0이면 B는 A의 약수이다.
		
		for(int num = 1; num <= 100; num++) 
		{
			System.out.print(num + "의 약수 : ");
			for(int j = 1; j <= num; j++) 
			{
				if(num % j == 0) 
				{
					if(num == j)	System.out.print(j);
					else			System.out.print(j + ", ");
				}
			}
			// 하나의 숫자에 대해 약수작업이 모두 끝나면 줄을 바꿔준다.
			System.out.println();
		}
	}
}
