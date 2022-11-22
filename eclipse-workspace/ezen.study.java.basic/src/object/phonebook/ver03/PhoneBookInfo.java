package object.phonebook.ver03;

public class PhoneBookInfo {
	String name;
	String phoneNumber;
	String birthday;
	
	public PhoneBookInfo(String name, String num, String birth) {
		this.name = name; phoneNumber = num; birthday = birth;
	}
	public PhoneBookInfo(String name, String num) {
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
