package condition;

public class OneTo100Yaksu {

	public static void main(String[] args) {
		// 1- 100의 약수 구하기\
		
		for(int a = 1; a <= 100; a++) {
			System.out.print(a + "의 약수: ");
			int b = 1;
			for(b = 1; b <= a; b++) {
				if(a % b == 0 ) {
					if(a == b) {
					 System.out.print( b );
					} 
					else {
					 System.out.print( b + ", " );
					} 
				}
				
			} 
			 System.out.println();
		}
				

	}

}
