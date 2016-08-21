package managerules;


public class PayRules extends Rules {
	
	private String card_Number;

	public PayRules(String cardNumber){
		this.card_Number = cardNumber;
	}
	
	public boolean verifyRule() {

		long sum =0;
		boolean checkStatus = false;
		checkStatus= isValidCard(card_Number);
		return checkStatus;
	}
	
	public double calculatePay(int x,int y){
		double sum = 0;
		sum = (x+y)*1.75;
		return sum;
	}
	
	public boolean isValidCard(String card_Number){
		
		if ((card_Number.length()) == 16 )
		{
			return true;
		}
		else 
			return false;
		
	}
	
	public PayRules() {
		// TODO Auto-generated constructor stub
	}
	
}


