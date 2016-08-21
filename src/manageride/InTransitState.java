package manageride;

import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Scanner;

public class InTransitState implements RideStateInterface {

	private Dispatch dispatch;
	private int sTime;

	public InTransitState(Dispatch d) {
		dispatch = d;
	}

	@Override
	public String startRide() {
		// TODO Auto-generated method stub
		return "Already received a ride request";
	}

	@Override
	public String transitRide() {
		// TODO Auto-generated method stub
		
		Scanner in = new Scanner(System.in);
		System.out.println("Enter 1 to start the ride");
		int menuItem = in.nextInt();
		if (menuItem == 1) {
			
			System.out.println("Your ride has started");
		}
		return "";
	 }
		
	public String endRide() {
			// TODO Auto-generated method stub
			return "Ride should be completed first";
	 }
}
