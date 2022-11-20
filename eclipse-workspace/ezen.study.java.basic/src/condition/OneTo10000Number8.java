package condition;

public class OneTo10000Number8 {

	public static void main(String[] args) {
		// 1부터 10000까지의 정수에는 8이 몇개인가?
		
		int imsi = 0;
		int number8 = 0;
		for(int wonbon = 1 ; wonbon <=10000; wonbon++) {
			int a = wonbon;
			
			while(wonbon != 0) {				
				imsi = wonbon % 10;
				wonbon = wonbon / 10;
				if(imsi == 8) {
					number8++;
				}				
			}
			wonbon = a;
			
		}
		System.out.println(number8);
		
		int num8 = 0;
		int won = 0;
		
		for(int i = 1; i <= 10000; i++) {
			won = i;
			while(i>=10) {
				if(i % 10 == 8) {
					num8++;
					i /= 10;
				} else {
					i /= 10;
				}
			}
			if(i == 8) {
				num8++; // 1단위에는 8이 하나만 존재하니까 따로 뺀다.
			}
			i = won;
		}
		System.out.println(num8);
		System.out.println("====================================");
		
		num8 = 0;
		won = 0;
		
		for(int num = 1; num <= 10000; num++) {
			won = num;
			while(num > 0) {
				if(num % 10 == 8) {
					num8++;
				}
				num /= 10;
			}
			num = won;
		}
		System.out.println(num8);

	}

}
