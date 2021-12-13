package tema4;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class NotificationBox {
	JFrame f1 = new JFrame("Notificare");
	JPanel p = new JPanel();
	JLabel l1;
	public NotificationBox() {
		l1 = new JLabel("A aparut o modificare de sold");
		f1.setSize(300,200);
		p.setLayout(null);
		
		l1.setSize(200,100);
		l1.setLocation(30,30);
		
		p.add(l1);
		f1.setContentPane(p);
		f1.setVisible(true);
	}
	public NotificationBox(String s) {
		l1 = new JLabel(s);
		f1.setSize(300,200);
		p.setLayout(null);
		
		l1.setSize(100,30);
		l1.setLocation(30,30);
		
		p.add(l1);
		f1.setContentPane(p);
		f1.setVisible(true);
	}
}
