package sec01.exam06;

public class Button {
	
	OnClickListener listener;
	
	void setOnClickListener(OnClickListener listener) {
		this.listener = listener;
	}
	
	void click() {
		listener.onClick();
	}
	
	static interface OnClickListener{
		void onClick();
	}
}
