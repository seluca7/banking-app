package tema4;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class ViewPersoana {
	int id;
	String nume = null;
	String adresa = null;
	String telefon = null;
	OpFisiere o = new OpFisiere();
	Bank b = new Bank();
	
	JFrame f1 = new JFrame("persoana");
	
	JButton b1 = new JButton("adauga");
	JButton b2 = new JButton("editeaza");
	JButton b3 = new JButton("sterge");
	JButton b4 = new JButton("vezi persoane");
	
	JLabel l1 = new JLabel("ID");
	JLabel l2 = new JLabel("Nume");
	JLabel l3 = new JLabel("Adresa");
	JLabel l4 = new JLabel("Telefon");
	
	JTextField t1 = new JTextField();
	JTextField t2 = new JTextField();
	JTextField t3 = new JTextField();
	JTextField t4 = new JTextField();
	
	JPanel p = new JPanel();
	
	public ViewPersoana() {
	//	f1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f1.setSize(330,450);
		
		p.setLayout(null);
		
		b1.setSize(120,30);
		b2.setSize(120,30);
		b3.setSize(120,30);
		b4.setSize(120,30);
		
		b1.setLocation(30,320);
		b2.setLocation(160,320);
		b3.setLocation(30,370);
		b4.setLocation(160,370);
		
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
			id = Integer.parseInt(t1.getText());
			nume = t2.getText();
			adresa = t3.getText();
			telefon = t4.getText();
			Persoana p = new Persoana(id,nume,adresa,telefon);
			o.citire();
			o.b.addPerson(p);
			o.scriere();
			});
		
		b2.addActionListener(e ->{
			id = Integer.parseInt(t1.getText());
			nume = t2.getText();
			System.out.println(nume);
			adresa = t3.getText();
			telefon = t4.getText();
			o.citire();
			for(Persoana p:o.b.h.keySet()) {
				if(p.getId()==id) {
						p.setNume(nume);
						p.setAdresa(adresa);
						p.setTelefon(telefon);
					
				}
			}
			o.scriere();
			});
		b3.addActionListener(e ->{
			o.citire();
			id = Integer.parseInt(t1.getText());
			o.b.deletePerson(id);
			o.scriere();
		});
		b4.addActionListener(e ->{
			o.citire();
			PersonTable pt = new PersonTable(o.b.h);
		});

	}
}
