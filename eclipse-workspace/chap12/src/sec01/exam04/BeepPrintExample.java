package sec01.exam04;

import java.awt.Toolkit;

public class BeepPrintExample {

	public static void main(String[] args) {

		Thread thread = new BeepThread();
		thread.start();
		for(int i = 0; i < 5; i++) {
			System.out.println("띵");
			try {
				Thread.sleep(500);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

	}

}
