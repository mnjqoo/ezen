package sec02.exam03;

public class Button {
	static interface OnClickListener{
		void onClick();
	}
	
	private OnClickListener listener;
	public void setOnClickListener(OnClickListener listener) {
		this.listener = listener;
	}
	
	void touch() {
		listener.onClick();
	}
}
