package array;

public class ArrayExam07 {

	public static void main(String[] args) {
		
		int[][] score = {
				{30, 40, 50},  // 1번 학생의 국어, 영어, 수학 점수
				{60, 70, 80},  // 2번 학생의 국어, 영어, 수학 점수
				{55, 65, 45},  // 3번 학생의 국어, 영어, 수학 점수
				{88, 91, 30},  // 4번 학생의 국어, 영어, 수학 점수
				{30, 45, 92}   // 5번 학생의 국어, 영어, 수학 점수				
		};
		
		int korTotal = 0; // 국어 점수의 총합을 저장할 변수
		int engTotal = 0; // 영어 점수의 총합을 저장할 변수
		int matTotal = 0; // 수학 점수의 총합을 저장할 변수
		
		System.out.println("번호\t국어\t영어\t수학\t총점\t평균");
		System.out.println("============================================");
		
		for(int i = 0; i < score.length; i++) {
				
			korTotal += score[i][0];
			engTotal += score[i][1];			
			matTotal += score[i][2];
			int sum1 = (score[i][0] + score[i][1] + score[i][2]);
			System.out.println((i+1) + "\t " + score[i][0] + "\t " + score[i][1] + "\t " + score[i][2] + "\t " + sum1 + "\t " + sum1/3);	
		}
		
		System.out.println("============================================");
		int sum2 = korTotal + engTotal + matTotal;
		System.out.println("총점:\t" + korTotal + "\t " + engTotal + "\t " + matTotal + "\t " + sum2 + "\t " + sum2/15);
		
		System.out.println("============================================");
		
		for(int i = 0; i < score.length; i++) {
			System.out.print((i +1) + "\t");
			int sum3 = 0;
			for (int j = 0; j < score[i].length; j++){
				System.out.print(score[i][j] + "\t" );
				sum3 += score[i][j];
			}
			System.out.print(sum3 + "\t" + sum3/3);
			System.out.println();
		}
		
		System.out.println("============================================");
		System.out.println("총점:\t" + korTotal + "\t " + engTotal + "\t " + matTotal + "\t " + sum2 + "\t " + sum2/(score.length * 3));

	} //	public static void main(String[] args)

} //public class ArrayExam07
