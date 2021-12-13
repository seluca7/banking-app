package tema4;

public interface BankProc {
	void addPerson(Persoana p);
	void deletePerson(int id);
	void addAccount(Account a);
	void deleteAccount(int idPers,int idCont);
	int existaPersoana(Persoana p);
	int existaContul(Account a);
}
