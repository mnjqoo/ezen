package object.phonebook.ver03;


public class PhoneBook {
	
	public static void main(String[] args) {
		
		PhoneBookManager manager = new PhoneBookManager(); //전화번호 관리 클래스를 생성한다.
		int choice = 0;
		while(true) {
			MenuViewer.showMenu();
			choice = MenuViewer.keyboard.nextInt(); MenuViewer.keyboard.nextLine();
			switch(choice) {
			case 1: manager.inputData(); break;
			case 2: manager.searchData(); break;
			case 3: manager.deleteData(); break;
			case 4: manager.allDataDisplay(); break;
			case 0: System.out.println(">프로그램을 종료합니다."); return;
			default : System.out.println(">잘못된 번호 입니다.");
			}
			
		}
		

	}
}
