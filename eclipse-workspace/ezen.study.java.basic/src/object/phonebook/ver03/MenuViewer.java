package object.phonebook.ver03;
import java.util.Scanner;

public class MenuViewer {
	public static Scanner keyboard = new Scanner(System.in);
	
	public static void showMenu() {
		System.out.println("========================================================================================");
		System.out.println("                           ◈◈◈◈◈◈◈◈번호를 선택하세요◈◈◈◈◈◈◈◈");
		System.out.println("1.데이터 입력 || 2. 데이터 검색 || 3. 데이터 삭제 || 4. 모든 데이터 조회 || 0.프로그램 종료");
		System.out.print(">선택: ");
	}
}
