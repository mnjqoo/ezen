package object.basic;

public class ReturnExam {

	public static void main(String[] args) {
		int num1 = 10, num2 = 3, result = 0;
		ReturnExam re = new ReturnExam();
		result = re.plus(num1, num2);
		System.out.println(result);
		result = re.max(num1, num2);
		System.out.println(result);

	}
	
	int plus(int num1, int num2) {
		return num1 + num2;
	}
	
	int max(int num1, int num2) {
		//if(num1 > num2) return num1;
		//else return num2;
		int result = 0;
		if(num1 > num2) result = num1;
		else result = num2;
		return result;
	}

}
