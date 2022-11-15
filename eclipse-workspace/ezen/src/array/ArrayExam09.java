package array;

public class ArrayExam09 {

	public static void main(String[] args) {

		char[]	abc	= {'A', 'B', 'C', 'D'};		// abc.length
		char[]	num	= {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9'}; // num.length
		
		char[]	result = new char[abc.length + num.length];
		
		System.arraycopy(abc, 0, result, 0, abc.length);
		System.out.println(new String(result));
		
		System.arraycopy(num, 0, result, abc.length, num.length);
		System.out.println(result);
		
	} // End - public static void main(String[] args)

} // End - public class ArrayExam09







