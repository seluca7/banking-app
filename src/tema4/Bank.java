package tema4;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;

public class Bank implements BankProc,Serializable {
	HashMap<Persoana,ArrayList<Account>> h = new HashMap<Persoana,ArrayList<Account>>();
	
	public void addPerson(Persoana p) {
		assert(this.existaPersoana(p)==0);
		h.put(p, new ArrayList<Account>());
		assert(this.existaPersoana(p)==1);
	}
	public void deletePerson(int id) {
		assert(this.existaPersId(id)==1);
		for(Persoana p:h.keySet()) {
			if(p.getId()==id) {
				h.remove(p);
				break;
			}
		}
		assert(this.existaPersId(id)==0);
	}
	
	public void afiseazaPers() {
		for(Persoana p:h.keySet()) {
			System.out.println("id:"+p.getId()+ " nume:"+p.getNume()+" adresa:"+p.getAdresa()+
					" telefon:"+p.getTelefon());
		}
	}
	public void afiseazaConturi() {
		for(Persoana p:h.keySet()) {
			System.out.println("id:"+p.getId()+ " nume:"+p.getNume()+" adresa:"+p.getAdresa()+
					" telefon:"+p.getTelefon());
			for(Account a:h.get(p)) {
				System.out.println("conturile persoanei "+ p.getId() + ":" + " id:" + a.getIdCont()
				+" sold:"+a.getSold()+" tip:"+a.getTip());
			}
		}
	}
	@Override
	public void addAccount(Account a) {
		assert(this.existaContul(a) == 0);
		for(Persoana p:h.keySet()) {
			if(a.getIdTitular() == (p.getId())) {
				h.get(p).add(a);
				a.addObserver(p);
			}
		}
		assert(this.existaContul(a)==1);
		
	}
	@Override
	public void deleteAccount(int idPers, int idCont) {
		int sters = 0;
		assert(this.existaContId(idCont)==1);
		for(Persoana p:h.keySet()) {
			if(p.getId() == idPers) {
				for(Account a:h.get(p)) {
					if(a.getIdCont()== idCont) {
						h.get(p).remove(a);
						sters = 1;
						break;
					}
				}
			}
		}
		if(sters == 0) {
			System.out.println("contul cu id-ul" + idCont + "apartinand persoanei " + idPers + "nu exista");
		}
		assert(this.existaContId(idCont)==0);
		
	}
	@Override
	public int existaPersoana(Persoana p) {
		int ok = 0;
		for(Persoana a:h.keySet() ) {
			if (p.equals(a)) {
				ok = 1;
			}
		}
		if(ok == 1) {
			System.out.println("persoana " + p.getId() + "." + p.getNume() + " a fost gasita");
		}
		else {
			System.out.println("persoana " + p.getId() + "." + p.getNume() + " nu  a fost gasita");
		}
		return ok;
	}
	@Override
	public int existaContul(Account a) {
		int e = 0;
		for(Persoana p:h.keySet()) {
			for(Account ac:h.get(p)) {
				if(a.equals(ac)) {
					e = 1;
				break;
				}
			}
		}
		return e;
	}
	
	public int existaPersId(int id) {
		int e = 0;
		for(Persoana p:h.keySet()) {
			if(p.getId()== id) {
				e = 1;
			break;
			}
		}
		return e;
	}
	
	public int existaContId(int idCont) {
		int e = 0;
		for(Persoana p:h.keySet()) {
			for(Account a:h.get(p)) {
				if(a.getIdCont() == idCont) {
					e = 1;
					break;
				}
			}
		}
		return e;
	}
	public void depune(int idCont,int suma) {
		for(Persoana p:h.keySet()) {
			for(Account a:h.get(p)) {
				if(a.getIdCont()==idCont) {
					a.depunere(suma);
					break;
				}
			}
		}
	}
	public void retrage(int idCont,int suma) {
		for(Persoana p:h.keySet()) {
			for(Account a:h.get(p)) {
				if(a.getIdCont()==idCont) {
					a.retragere(suma);
					break;
				}
			}
		}
	}
	
	public void notifyObserver() {
		for(Persoana p:h.keySet()) {
			
		}
	}
}
