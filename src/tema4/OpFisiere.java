package tema4;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class OpFisiere {
	public Bank b = new Bank();
	String fileName = "banca.txt";
	
	public void scriere() {
		ObjectOutputStream os = null;
		try {
			os = new ObjectOutputStream(new FileOutputStream(fileName));
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			os.writeObject(b);
			os.close();
			System.out.println("scrierea in fisier s-a facut cu succes");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void citire() {
		ObjectInputStream is = null;
	//	Bank b2 = null;
		try {
			 is = new ObjectInputStream(new FileInputStream(fileName));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			 b = (Bank) is.readObject();
			 is.close();
		} catch (ClassNotFoundException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
