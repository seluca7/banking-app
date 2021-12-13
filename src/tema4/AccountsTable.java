package tema4;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class AccountsTable extends JFrame {
	JTable table;
	public AccountsTable(HashMap<Persoana,ArrayList<Account>> h) {
		setLayout(new FlowLayout());
		
		String[] columnNames = {"ID Cont"," ID Titular","Sold","Tipul contului"};
		Object[][] data = new Object[50][4];
		int i = 0;
		for(Persoana p:h.keySet()) {
			for(Account a:h.get(p)) {
				data[i][0] = a.getIdCont();
				data[i][1] = a.getIdTitular();
				data[i][2] = a.getSold();
				if(a.getTip()==1) {
					data[i][3] = "cont de economii";}
				else if(a.getTip()==2) {
					data[i][3] = "cont de cheltuieli";
				}
				i++;
			}
		}
		table = new JTable(data,columnNames);
		table.setPreferredScrollableViewportSize(new Dimension(500,100));
		table.setFillsViewportHeight(true);
		JScrollPane sp = new JScrollPane(table);
		add(sp);
	//	this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(600,300);
		this.setVisible(true);
		this.setTitle("Conturi");
		
		
	}
}
