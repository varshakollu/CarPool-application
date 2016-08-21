package maintainpayment;

import java.util.Random;

import managerules.PayRules;
import managerules.Rules;

public class CreditCardPayment extends Payment{

	@Override
	public int payBill() {
		
			Random rand = new Random();
			int  amount= rand.nextInt(50) + 1;
			System.out.println("Your amount value is $" +amount);
			callSleep(10000);
			
			System.out.println("Paying through Credit Card..........");
			callSleep(10000);
			System.out.println("Credit Card Verification in process.");
			System.out.println("***** Please wait ******");
			callSleep(20000);
			
			System.out.println("Your Credit Card is verified");
			System.out.println("Payment done!! Thanks for the payment");
			
			int paymentStatus=0;
			return paymentStatus;	
	}
	
	public boolean verifyCard(String cardNumber) {
		Rules paymentRules = new PayRules(cardNumber);
		return paymentRules.verifyRule();
	}

	@Override
	public void extraCharges() {
		// TODO Auto-generated method stub
		
	}
}









