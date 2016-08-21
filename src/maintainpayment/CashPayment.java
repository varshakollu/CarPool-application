package maintainpayment;

import java.util.*;

public class CashPayment extends Payment{

	@Override
	public int payBill() {
		
		Random rand = new Random();
		int  amount= rand.nextInt(50) + 1;
		System.out.println("Your amount value is $" +amount);
		callSleep(10000);
		System.out.println("Paying through Cash..........");
		callSleep(10000);
		System.out.println("***** Please wait ******");
		callSleep(20000);
		
		
		
		System.out.println("Payment done!! Thanks for the payment");
		
		int paymentStatus=0;
		return paymentStatus;	
	}

	@Override
	public void extraCharges() {
		// TODO Auto-generated method stub
	}

}
