package swing.event.event04;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
//===================================================================
public class CheckBoxItemEventExam extends JFrame {
	
	JCheckBox[] fruits = new JCheckBox[3];
	String[] names = {"사과" , "포도", "딸기"};
	JLabel sumLabel;
	
	CheckBoxItemEventExam() {
		setTitle("CheckBox 와 ItemEvent");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Container c = getContentPane();
		c.setLayout(new FlowLayout());
		c.add(new JLabel("♣사과 1000원♣포도 2000원♣딸기 3000원♣"));
		c.setBackground(Color.pink);
		
		MyItemListener listener = new MyItemListener();
		
		for(int i = 0; i < fruits.length; i++) {
			fruits[i] = new JCheckBox(names[i]);
			c.add(fruits[i]);
			fruits[i].addItemListener(listener);
			fruits[i].setBorderPainted(true);
		}
		
		sumLabel = new JLabel("현재 0 원입니다.");
		c.add(sumLabel);
		setSize(280, 200);
		setVisible(true);
	}
	
	class MyItemListener implements ItemListener {
		
		int sum = 0;
		
		@Override
		public void itemStateChanged(ItemEvent e) {
			
			if(e.getStateChange() == ItemEvent.SELECTED) { //이벤트의 상태 == 아이템 선택됨
				if(e.getItem() == fruits[0]) {
					sum += 1000;
				} else if(e.getItem() == fruits[1]) {
					sum += 2000;
				} else {
					sum += 3000;
				}
			} else { //아이템 선택됨에서 선택되지 않음으로 돌려 놓음
				if(e.getItem() == fruits[0]) {
					sum -= 1000;
				} else if(e.getItem() == fruits[1]) {
					sum -= 2000;
				} else {
					sum -= 3000;
				}
			}
			
			sumLabel.setText("현재" + sum + "원입니다.");
		}
		
	}

	public static void main(String[] args) {
		
		new CheckBoxItemEventExam();

	}

}
//===================================================================