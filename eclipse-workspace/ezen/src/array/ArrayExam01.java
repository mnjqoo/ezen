package array;

public class ArrayExam01 {

	public static void main(String[] args) {
		int		sum	= 0;	// 총점을 저장하기 위한 변수
		int		avg	= 0;	// 평균을 저장하기 위한 변수
		
		int[] score = {100, 88, 70, 92, 45, 68, 77, 95};
		// System.out.println(score.length);

		for(int i = 0; i < score.length; i++) {
			sum += score[i]; // sum += score[0]; sum += score[1]; .... sum += score[7];
		}
		avg = sum / score.length;
		System.out.println("총점 : " + sum);
		System.out.println("평균 : " + avg);
	}

}












