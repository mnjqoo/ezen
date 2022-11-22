package object.phonebook.ver02;
import java.util.Scanner;
//---------------------------------------------------------------------------------
class PhoneInfo{
	String name;
	String phoneNumber;
	String birthday;
	
	public PhoneInfo(String name, String num, String birth) {
		this.name = name; phoneNumber = num; birthday = birth;
	}
	public PhoneInfo(String name, String num) {
		this.name = name; phoneNumber = num; this.birthday = null;
	}
	
	public void showPhoneInfo() {
		System.out.println("==========================================");
		System.out.println("▷▷이름: " + name);
		System.out.println("▷▷전화번호: " + phoneNumber);
		if(birthday != null) {
			System.out.println("▷▷생년월일: " + birthday);
		}
	}
}
//---------------------------------------------------------------------------------
public class PhoneBook {
	static Scanner keyboard = new Scanner(System.in);
	
	public static void showMenu() {
		System.out.println("==========================================");
		System.out.println("◈◈◈◈◈◈◈◈번호를 선택하세요◈◈◈◈◈◈◈◈");
		System.out.println("1.데이터 입력 ||| 0.프로그램 종료");
		System.out.print("선택: ");
	}
	public static void inputData() {
		System.out.println("데이터를 입력하세요.");
		System.out.print("이름: ");
		String name = keyboard.nextLine();
		System.out.print("전화번호: ");
		String num = keyboard.nextLine();
		System.out.print("생년월일: ");
		String birthday = keyboard.nextLine();
		PhoneInfo pInfo1 = new PhoneInfo(name, num, birthday);
		pInfo1.showPhoneInfo();
		
		
	}
	public static void main(String[] args) {
		int choice = 0; // 작업을 선택한 값을 저장할 변수
		while(true) {
			showMenu();
			choice = keyboard.nextInt();
			keyboard.nextLine();
			switch(choice) {
			case 1: inputData(); break;
			case 0: System.out.println("프로그램이 종료됩니다."); return ;
			}
			
		}
	}

}
