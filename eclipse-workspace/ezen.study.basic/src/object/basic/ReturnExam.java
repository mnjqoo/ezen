package object.basic;

//-----------------------------------------------------------------------------------------------------------
// public class ReturnExam
//-----------------------------------------------------------------------------------------------------------
public class ReturnExam {

	//-----------------------------------------------------------------------------------------------------------
	public static void main(String[] args) {
		int	num1 = 10, num2 = 3, result = 0;
		
		ReturnExam re = new ReturnExam();
		result = re.plus(num1, num2); // 클래스를 생성해야 인스턴스 메서드를 사용할 수 있다.
		System.out.println("덧셈 결과 : " + result);
		
		result = re.max(num1, num2);
		System.out.println(num1 + "과 " + num2 + " 중에 " + result + "이/가 더 큰 수입니다.");
	}
	//-----------------------------------------------------------------------------------------------------------
	int plus(int num1, int num2) {
		// return "Hello"; 메서드의 선언된 리턴타입과 실제 리턴타입이 같아야 한다.
		return num1 + num2;
	}
	//-----------------------------------------------------------------------------------------------------------
	int max(int num1, int num2) {
		// if(num1 > num2)	return num1;
		// else			return num2;
		int	result = 0;
		if(num1 > num2)	result = num1;
		else			result = num2;
		return result;	// 리턴문은 최소화 하는 것이 좋다.
	}
} // End - public class ReturnExam
















