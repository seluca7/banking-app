package tema4;

public class SpendingsAccount extends Account {

	public SpendingsAccount(int s, int c, int t) {
		super(s, c, t);
		this.setTip(2);
	}
	public void depunere(int a) {
		this.setSold(this.getSold()+a);
	}
	public int retragere(int a) {
		int ret = 0;
		if(a<= this.getSold()) {
			ret = a;
			this.setSold(this.getSold()-a);
		}
		else System.out.println("fonduri insuficiente");
		return ret;
	}
}
