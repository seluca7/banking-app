package tema4;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Observer;

@SuppressWarnings("deprecation")

public class Account extends java.util.Observable implements Serializable{
	private int sold;
	private int idCont;
	private int idTitular;
	private int tip;
	
	private ArrayList<Observer> users = new ArrayList<Observer>();
	//private ArrayList<Persoana> users = new ArrayList<Persoana>();
	
	public Account(int s,int c,int t) {
		this.sold = s;
		this.idCont = c;
		this.idTitular = t;
	}
	
	public void setSold(int a) {
		this.sold = a;
		notifyObserver();
	}
	public int getSold() {
		return this.sold;
	}
	public void setIdTitular(int a) {
		this.idTitular = a;
	}
	public int getIdTitular() {
		return this.idTitular;
	}
	public void setIdCont(int a) {
		this.idCont = a;
	}
	public int getIdCont() {
		return this.idCont;
	}
	public void setTip(int a) {
		this.tip = a;
	}
	public int getTip() {
		return this.tip;
	}
	public void depunere(int suma) {
		
	}
	public int retragere(int suma) {
		return 0;
	}
	public void addInterest() {
		
	}
	public void addObserver(Observer o) {
		users.add(o);
	}
	public void removeObserver(Observer o) {
		users.remove(o);
	}
	
	public void notifyObserver() {
		for(Observer a:users) {
			a.update(this, a);
			//a.update(this, a,this.getIdCont(),this.getIdTitular());
		}
	}
	//test
}
