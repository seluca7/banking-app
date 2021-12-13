package tema4;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class TestBanca {
	public Bank b = new Bank();
	public Persoana p = new Persoana(1, "Popescu", "Bucuresti", "09511");
	public SavingsAccount acc1 = new SavingsAccount(760, 1, 1);
	public SpendingsAccount acc2 = new SpendingsAccount(999,2,1);
	
	@Test
	void test() {
		b.addPerson(p);
		b.addAccount(acc1);
		b.addAccount(acc2);
		
	//	assertEquals(acc1.getSold(),760);
	//	assertEquals(b.existaPersoana(p),1);
		assertEquals(b.existaContId(1),1);
	}

}
