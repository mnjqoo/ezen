package sec01.exam06;

public class ButtonExample {

	public static void main(String[] args) {
		Button btn = new Button();
		
		btn.setOnClickListener(new CallListener());
		btn.click();
		
		btn.setOnClickListener(new MessageListener());
		btn.click();
	}

}
