package condition;

public class OneTo10000Number8 {

	public static void main(String[] args) {
		// 1부터 10,000까지의 정수에는 8이라는 숫자가 총 몇 번나오나요?
		// 888 => 3번, 8080 => 2번
		// 답 : 4000번
		
		int	number8	= 0;	// 8이라는 숫자의 갯수를 누적시키는 변수
		int	wonbon	= 0;	// 작업대상이 되는 수를 임시로 저장하는 변수
		
		for(int num = 1; num <= 10000; num++) {
			wonbon = num;	// 작업대상이 되는 수(num)를 변수에 저장한다.
			
			while(num >= 10) {
				if(num % 10 == 8) {
					number8++;
					num /= 10;
				} else {
					num /= 10;
				}
			}
			if(num == 8) { // 1단위에는 8이 오직 하나만 존재한다.
				number8++;
			}
			// 하나의 숫자(num)에 대한 작업이 끝나면 원래 값으로 돌려놓는다.
			num = wonbon; 
		} // End - for
		System.out.println("1 ~ 10,000까지 나오는 8의 개수 : " + number8);
		
		System.out.println("==============================================");
		
		wonbon = 0; number8 = 0;
		for(int num = 1; num <= 10000; num++) {
			wonbon = num;
			while(num > 0) {
				if(num % 10 == 8) {
					number8++;
				}
				num /= 10;
			}
			num = wonbon;
		}
		System.out.println("1 ~ 10,000까지 나오는 8의 개수 : " + number8);

	} // End - public static void main(String[] args)

} // End - public class OneTo10000Number8



