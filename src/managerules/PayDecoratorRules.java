package managerules;


public class PayDecoratorRules extends DecoratorRules {
	
	private int taxiRate = 1;
	private int carpoolRate = 2;

	public  PayDecoratorRules(Rules rules) {
		super(rules);
		// TODO Auto-generated constructor stub
	}
	
	public void setTaxiRate(int taxiRate) {
		this.taxiRate = taxiRate;
	}
	
	public int getTaxiRate() {
		return taxiRate;
	}

	public void setCarpoolRate(int carpoolRate) {
		this.carpoolRate = carpoolRate;
	}
	
	public int getCarpoolRate() {
		return carpoolRate;
	}
	
	public String add() {
		// TODO Auto-generated method stub
		return null;
	}

	public String remove() {
		// TODO Auto-generated method stub
		return null;
	}
	
	public boolean verifyRule() {
		super.verifyRule();
		return false;
	}
}
