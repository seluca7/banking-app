package tema4;

import java.util.ArrayList;
import java.util.HashMap;

import java.awt.*;
import javax.swing.*;

public class PersonTable extends JFrame {
	JTable table;
	public PersonTable(HashMap<Persoana,ArrayList<Account>> h) {
		setLayout(new FlowLayout());
		
		String[] columnNames = {"ID","Nume","Adresa","Telefon"};
		Object[][] data = new Object[50][4];
		int i = 0;
		for(Persoana p:h.keySet()) {
			data[i][0] = p.getId();
			data[i][1] = p.getNume();
			data[i][2] = p.getAdresa();
			data[i][3] = p.getTelefon();
			i++;
		}
		table = new JTable(data,columnNames);
		table.setPreferredScrollableViewportSize(new Dimension(500,100));
		table.setFillsViewportHeight(true);
		JScrollPane sp = new JScrollPane(table);
		add(sp);
		this.setSize(600,300);
		this.setVisible(true);
		this.setTitle("Persoane");
		
		
	}
}
