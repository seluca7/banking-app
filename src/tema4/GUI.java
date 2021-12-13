package tema4;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


public class GUI {
	JFrame f1 = new JFrame("main");
	JButton b1 = new JButton("persoane");
	JButton b2 = new JButton("conturi");
	JPanel p = new JPanel();
	
	public GUI(){
		f1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f1.setSize(400,400);
		
		p.setLayout(null);
		
		b1.setSize(200,40);
		b2.setSize(200,40);
		
		b1.setLocation(90,130);
		b2.setLocation(90,190);
		
		p.add(b1);
		p.add(b2);
		
		f1.setContentPane(p);
		f1.setVisible(true);
		
		b1.addActionListener(e ->{
			ViewPersoana v = new ViewPersoana();
		});
		
		b2.addActionListener(e ->{
			ViewCont v2 = new ViewCont();
		});
	}
}
