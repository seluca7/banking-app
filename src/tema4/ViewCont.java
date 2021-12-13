package tema4;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class ViewCont {
	int sold;
	int idCont;
	int idTitular;
	int tip;
	OpFisiere o = new OpFisiere();
	Bank b = new Bank();
	
JFrame f1 = new JFrame("cont");
	
	JButton b1 = new JButton("adauga");
	JButton b2 = new JButton("editeaza");
	JButton b3 = new JButton("sterge");
	JButton b4 = new JButton("dep");
	JButton b5 = new JButton("ret");
	JButton b6 = new JButton("vezi conturi");
	
	
	JLabel l1 = new JLabel("Sold");
	JLabel l2 = new JLabel("ID Cont");
	JLabel l3 = new JLabel("Titular");
	JLabel l4 = new JLabel("Tipul contului");
	
	JTextField t1 = new JTextField();
	JTextField t2 = new JTextField();
	JTextField t3 = new JTextField();
	JTextField t4 = new JTextField();
	
	JPanel p = new JPanel();
	
	public ViewCont() {
	//	f1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f1.setSize(330,500);
		
		p.setLayout(null);
		
		b1.setSize(120,30);
		b2.setSize(120,30);
		b3.setSize(120,30);
		b4.setSize(60,30);
		b5.setSize(60,30);
		b6.setSize(120,30);
		
		b1.setLocation(30,320);
		b2.setLocation(160,320);
		b3.setLocation(30,370);
		b4.setLocation(160,370);
		b5.setLocation(230,370);
		b6.setLocation(95,420);
		
		l1.setSize(200,25);
		l2.setSize(200,25);
		l3.setSize(200,25);
		l4.setSize(200,25);
		
		t1.setSize(200,30);
		t2.setSize(200,30);
		t3.setSize(200,30);
		t4.setSize(200,30);
		
		l1.setLocation(50,30);
		t1.setLocation(50,60);
		l2.setLocation(50,90);
		t2.setLocation(50,120);
		l3.setLocation(50,150);
		t3.setLocation(50,180);
		l4.setLocation(50,210);
		t4.setLocation(50,240);
		
		p.add(b1);
		p.add(b2);
		p.add(b3);
		p.add(b4);
		p.add(b5);
		p.add(b6);
		p.add(l1);
		p.add(t1);
		p.add(l2);
		p.add(t2);
		p.add(l3);
		p.add(t3);
		p.add(l4);
		p.add(t4);
		
		f1.setContentPane(p);
		f1.setVisible(true);
		
		b1.addActionListener(e ->{
			sold = Integer.parseInt(t1.getText());
			idCont = Integer.parseInt(t2.getText());
			idTitular = Integer.parseInt(t3.getText());
			tip = Integer.parseInt(t4.getText());
			if(tip == 1) {
				SavingsAccount acc = new SavingsAccount(sold,idCont,idTitular);
				o.citire();
				o.b.addAccount(acc);
				o.scriere();
			}
			if(tip == 2) {
				SpendingsAccount acc = new SpendingsAccount(sold,idCont,idTitular);
				o.citire();
				o.b.addAccount(acc);
				o.scriere();
			}
		});
		
		b2.addActionListener(e ->{
			sold = Integer.parseInt(t1.getText());
			idCont = Integer.parseInt(t2.getText());
			idTitular = Integer.parseInt(t3.getText());
			tip = Integer.parseInt(t4.getText());
			o.citire();
			for(Persoana p:o.b.h.keySet()) {
				for(Account a:o.b.h.get(p)) {
					if(a.getIdCont() == idCont) {
						a.setSold(sold);
						a.setIdTitular(idTitular);
						a.setTip(tip);
					}
				}
			}
			o.scriere();
		});
		
		b3.addActionListener(e ->{
			idCont = Integer.parseInt(t2.getText());
			idTitular = Integer.parseInt(t3.getText());
			o.citire();
			o.b.deleteAccount(idTitular, idCont);
			o.scriere();
			
		});
		b5.addActionListener(e ->{
			idCont = Integer.parseInt(t2.getText());
			sold = Integer.parseInt(t1.getText());
			o.citire();
			o.b.retrage(idCont, sold);
			o.scriere();
			
		});
		b4.addActionListener(e ->{
			idCont = Integer.parseInt(t2.getText());
			sold = Integer.parseInt(t1.getText());
			o.citire();
			o.b.depune(idCont, sold);
			o.scriere();
			
		});
	
		
		b6.addActionListener(e ->{
			o.citire();
			AccountsTable at = new AccountsTable(o.b.h);
		});
	}
}
