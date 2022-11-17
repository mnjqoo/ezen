package array;

public class ArrayExam02 {

	public static void main(String[] args) {
		int[] score = {100, 79, 45, 88, 65, 97, 33};

		int max = score[0];	// 배열의 첫 번째 값으로 최대값을 초기화한다.
		int min = score[0]; // 배열의 첫 번째 값으로 최소값을 초기화한다.
		
		// 제일 높은 점수와 제일 낮은 점수를 구하세요!
		for(int i = 1; i < score.length; i++) {
			if(score[i] > max)	max = score[i];
			if(score[i] < min)	min = score[i];
		}
		
		System.out.println("제일 낮은 점수 : " + min);
		System.out.println("제일 높은 점수 : " + max);
	}

}
