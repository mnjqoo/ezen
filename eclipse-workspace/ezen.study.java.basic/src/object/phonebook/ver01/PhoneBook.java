package object.phonebook.ver01;
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
		System.out.println("================================================");
		System.out.println("이름: " + name);
		System.out.println("전화번호: " + phoneNumber);
		if(birthday != null) {
			System.out.println("생년월일: " + birthday);
		}
	}
}
//---------------------------------------------------------------------------------
public class PhoneBook {

	public static void main(String[] args) {
		PhoneInfo pInfo1 = new PhoneInfo("이수일", "010-1234-1234", null);
		PhoneInfo pInfo2 = new PhoneInfo("심순애", "010-5678-5678");
		
		pInfo1.showPhoneInfo();
		pInfo2.showPhoneInfo();

	}

}
