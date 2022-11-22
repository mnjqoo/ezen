package object.phonebook.ver03;


public class PhoneBookManager { //전화번호 정보 관리 매소드 : 입력, 조회, 삭제 기능
	
	final int MAX_CNT = 100;
	PhoneBookInfo[] infoStorage = new PhoneBookInfo[MAX_CNT];
	int index = 0; // 데이터가 비어있는 첫번째 방
	public void inputData() {
		System.out.println(">데이터를 입력하세요.");
		System.out.print("이름: ");
		String name = MenuViewer.keyboard.nextLine();
		System.out.print("전화번호: ");
		String num = MenuViewer.keyboard.nextLine();
		System.out.print("생년월일: ");
		String birthday = MenuViewer.keyboard.nextLine();
		infoStorage [index++] = new PhoneBookInfo(name, num, birthday);
		System.out.println(">전화번호 정보 등록이 되었습니다.");
	}
	
	private int searchIndex(String name) {
		for(int i = 0; i < index ; i++) {
			if((name.compareTo(infoStorage[i].name)) == 0) { // 두개의 값이 같으면 값이 0이 나옴
				return i;
			}
		}
		return -1; // 없으면 음수를 리턴
	}
	
	public  void searchData() {
		System.out.println(">이름을 입력하세요.");
		String name = MenuViewer.keyboard.nextLine();
		int data = searchIndex(name);
		if(data >= 0) {
			infoStorage[data].showPhoneInfo();
		} else {
			System.out.println(">정보가 없습니다.");
		}
		
	}
	
	public void deleteData() {
		System.out.println(">삭제할 이름을 입력하세요.");
		String name = MenuViewer.keyboard.nextLine();
		int data = searchIndex(name);
		if(data >= 0) {
			infoStorage[data] = null;
			System.out.println(">정보가 삭제되었습니다.");
			for(int i = data; i < index - 1; i++) {
				infoStorage[i] = infoStorage[i + 1];
				infoStorage[i + 1] = null;
			}
			index--;
		} else {
			System.out.println(">정보가 없습니다.");
		}
		
	}
	
	public void allDataDisplay() {
		System.out.println(">모든 전화번호 정보를 출력합니다.");
		for(int i = 0; i < index ; i++) {
			infoStorage[i].showPhoneInfo();
		}
		System.out.println(">모든 전화번호 정보 출력이 완료되었습니다.");
	}

}
