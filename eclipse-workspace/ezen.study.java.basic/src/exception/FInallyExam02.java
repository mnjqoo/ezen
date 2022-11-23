package exception;

public class FInallyExam02 {

	public static void main(String[] args) {

		try {
			startInstall(); //프로그램 설치를 시작한다.
			copyFiles(); //파일들을 복사한다.
			throw new Exception("프로그램 설치 중 문제가 발생하였습니다.");
			//deleteTemporaryFiles(); //프로그램 설치에 사용된 임시파일들을 삭제한다.
		} catch (Exception e) {
			e.printStackTrace(); //프로그램 설치 중 문제가 생기면
			deleteTemporaryFiles(); //프로그램 설치에 사용된 임시파일들을 삭제한다.
		} 

	}
	
	static void startInstall() {
		System.out.println("프로그램을 설치합니다.");
	}
	
	static void copyFiles() {
		System.out.println("파일을 복사합니다.");
	}
	static void deleteTemporaryFiles() {
		System.out.println("임시파일들을 삭제합니다.");
	}
}
