package condition;

public class Example {
	public static void main(String[] args) {
		
		int[] num1 = new int[6];
		for(int i = 0; i < num1.length; i++) {
			num1[i] = (int)(Math.random() * 45) +1;
			for(int j = 0; j < num1.length; j++) {
				if(i != j) {
					if(num1[i] == num1[j]) {
						i--;
					}
				}
			}
			//System.out.println(num1[i]);
		}
		
		System.out.println("1부터 45 사이의 각기 다른 6개의 숫자를 입력하세요.");
		
		java.util.Scanner s = new java.util.Scanner(System.in);
		int[] myNum = new int[6];
		for(int i = 0; i < myNum.length; i++) {
			myNum[i] = s.nextInt();
			//System.out.println(myNum[i]);
		}
		
		int count1 = 0;
		for(int i = 0; i < num1.length; i++) {
			for(int j = 0; j < myNum.length; j++) {
				if(num1[i] == myNum[j]) {
					count1++;
				}
			}
		}
		
		System.out.println(count1 + "개 맞췄습니다.");
		
		int[] num2 = new int[6];
		
		for(int i = 0; i < num1.length; i++) {
			int count2 = 0;
			for(int j = 0; j < myNum.length; j++) {
				if(num1[i] < num1[j]) {
					count2++;
				}
			}
			switch(count2) {
			case 0 : num2[5] = num1[i];
	                break;
			case 1 : num2[4] = num1[i];
	                break;
			case 2 : num2[3] = num1[i];
	                break;
			case 3 : num2[2] = num1[i];
			        break;
			case 4 : num2[1] = num1[i];
			        break;
	        default :num2[0] = num1[i];
	                break;
			}
		}
		
		System.out.println("당첨 번호는 " + num2[0] + ", " + num2[1] + ", " + num2[2] + ", " + num2[3] + ", " + num2[4] + ", " + num2[5] + "입니다.");
		
		
		
		
		
    }

}		


	


