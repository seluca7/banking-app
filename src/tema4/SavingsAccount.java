package tema4;

public class SavingsAccount extends Account{

		private int dep = 1;
		private int ret = 1;
		
		public SavingsAccount(int a,int b,int c) {
			super(a,b,c);
			this.setTip(1);
		}
		public void setDep(int a) {
			this.dep = 0;
		}
		public int getDep() {
			return this.dep;
		}
		public void setRet(int a) {
			this.ret = a;
		}
		public int getRet() {
			return this.ret;
		}
		
		public void depunere(int a) {
			if(this.getDep()==1) {
			this.setSold(this.getSold() + a);
			this.addInterest();
			this.setDep(0);
			}
			else {
				System.out.println("nu se mai pot face depuneri in contul de economii " + this.getIdCont() + " detinut de clientul " + this.getIdTitular() );	
			}
		}
		public void addInterest() {
			this.setSold(this.getSold() + (2/100*this.getSold()));
		}
		public int retragere(int a) {
			int ret = 0;
			if(a<=this.getSold()) {
				ret = a;
				this.setSold(this.getSold() - a);
			}
			else {
				System.out.println("fonduri insuficiente");
			}
			return ret;
		}

}
