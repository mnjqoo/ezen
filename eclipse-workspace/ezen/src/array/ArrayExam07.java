package array;

public class ArrayExam07 {

	public static void main(String[] args) {

		// score.length(row의 갯수)
		// score[2].length(열의 갯수)
		int[][] score = { 
				{30, 40, 50},	// 1번 학생의 국어,영어,수학 점수
				{60, 70, 80},	// 2번 학생의 국어,영어,수학 점수
				{55, 65, 75},	// 3번 학생의 국어,영어,수학 점수
				{88, 91, 30},	// 4번 학생의 국어,영어,수학 점수
				{30, 45, 92}	// 5번 학생의 국어,영어,수학 점수
		};
		int	korTotal	= 0;	// 국어 점수의 총합을 저장할 변수
		int	engTotal	= 0;	// 영어 점수의 총합을 저장할 변수
		int	matTotal	= 0;	// 수학 점수의 총합을 저장할 변수
		
		System.out.println("번호\t국어\t영어\t수학\t총점\t평균");
		System.out.println("==================================================================");

		// 시험본 학생 수만큼 작업을 한다.
		for(int no = 0; no < score.length; no++) {
			int	sum		 = 0;	// 한명의 학생에 대한 국영수 총점을 저장할 변수
			korTotal	+= score[no][0];
			engTotal	+= score[no][1];
			matTotal	+= score[no][2];
		
			System.out.print(no + 1 + "\t");	// 학생번호
			// 학생 한명이 가지고 있는 국영수 점수들을 모두 작업한다.
			for(int j = 0; j < score[no].length; j++) {
				System.out.print(score[no][j] + "\t");
				sum	+= score[no][j];
			}
			System.out.println(sum + "\t" + sum / score[no].length);
		} // End - for(모든 학생들의 점수 작업이 끝났다)
		
		System.out.println("==================================================================");
		System.out.print("총점:\t" + korTotal + "\t" + engTotal + "\t" + matTotal + "\t");
		System.out.print(korTotal + engTotal + matTotal + "\t");
		System.out.print((korTotal + engTotal + matTotal) / (score.length * 3));
		
	} // End - public static void main(String[] args)

} // End - public class ArrayExam07




























