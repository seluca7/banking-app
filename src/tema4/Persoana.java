package tema4;

import java.io.Serializable;
import java.util.Observable;
import java.util.Observer;

@SuppressWarnings("deprecation")
public class Persoana implements Serializable,Observer{
	private int id;
	private String nume;
	private String adresa;
	private String telefon;
	
	
	public Persoana(int i,String n,String a,String t) {
		this.id = i;
		this.nume = n;
		this.adresa = a;
		this.telefon = t;
	}
	
	
	public void setId(int a) {
		this.id = a;
	}
	public int getId() {
		return this.id;
	}
	public void setNume(String a) {
		this.nume = a;
	}
	public String getNume() {
		return this.nume;
	}
	public void setAdresa(String a) {
		this.adresa = a;
	}
	public String getAdresa() {
		return this.adresa;
	}
	public void setTelefon(String a) {
		this.telefon = a;
	}
	public String getTelefon() {
		return this.telefon;
	}
	
	public void update() {
		
	}


	@Override
	public void update(Observable arg0, Object arg1) {
		//String s = "in contul " + 
		NotificationBox n = new NotificationBox();
		
	}
/*	public void update(Observable arg0, Object arg1,int idCont,int idTitular) {
		String s = "in contul " + idCont + " al persoanei " + idTitular + "a aparut o modificare de sold"; 
		NotificationBox n = new NotificationBox(s);
		
	}*/
	
	
}
