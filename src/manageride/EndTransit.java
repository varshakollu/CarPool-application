package manageride;

import java.util.Scanner;
import maintainpayment.Payment;

public class EndTransit implements RideStateInterface {

	Dispatch d1;
	Payment p;
	Scanner in;

	public EndTransit(Dispatch d) {
		Dispatch dispatch = d;
	}

	@Override
	public String startRide() {
		// TODO Auto-generated method stub
		return "Ride is already completed";
	}

	public String transitRide() {
		// TODO Auto-generated method stub
		return "Ride is already completed";
	}

	public String endRide() {
		System.out.println("Entering endRide method");
		Scanner in = new Scanner(System.in);
		System.out.println("Enter the option to stop the ride");
		System.out.println("1.Stop the Ride");
		int menuItem = in.nextInt();
		if (menuItem == 1) {
			System.out.println("Your ride has ended");
		}
		return "";
	 }
	
	 public void callSleep(int mseconds) {
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			Thread.currentThread().interrupt();
		}
	}
}
