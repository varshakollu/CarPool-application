package maintainpayment;

import java.util.Random;

public class PayPalPayment extends Payment{

	@Override
	public int payBill() {
		
		Random rand = new Random();
		int  amount= rand.nextInt(50) + 1;
		System.out.println("Your amount value is $" +amount);
		callSleep(10000);
		
		System.out.println("Paying through your Paypal Account..........");
		callSleep(10000);
		System.out.println("Verifying your PayPal account");
		System.out.println("***** Please wait ******");
		callSleep(20000);
		
		System.out.println("Your PayPal account is verified");
		System.out.println("Payment done!! Thanks for the payment");
		
		int paymentStatus=0;
		return paymentStatus;	
}
		
	@Override
	public void extraCharges() {
		// TODO Auto-generated method stub
		
	}

}





