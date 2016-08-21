package managerequest;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Scanner;

import managerequest.RequestMain;
import managerequest.RequestStateInterface;
import manageride.Dispatch;
import manageride.Ride;
import maintainmember.DriverImp;
import maintainnotification.Notifications;
import maintainpayment.CashPayment;
import maintainpayment.CreditCardPayment;
import maintainpayment.DebitCardPayment;
import maintainpayment.PayPalPayment;
import managerequest.DBConnection;

public class ProcessRequest implements RequestStateInterface {

	private RequestMain request;
	private Connection requestconnection;
	private Statement requeststatement;

	public ProcessRequest(RequestMain r) {
		request = r;
	}
	
	public String receiveRequest(String emailid, String ride, String pickup, String dropoff, String pickuptime,
			int passengers, String model) {
		return "Request received";
	}

	public String processRequest(String request_type) {
		callSleep(2000);
		System.out.println("Request is getting handled, in processing state");
		
		Dispatch dispatch = new Ride();
		dispatch.startRide();
		dispatch.transitRide();
		callSleep(10000);
		
		Notifications notification = new Notifications();
		notification.sendMessage("Notifying Driver -->  Your customer is ready \n");
		
		callSleep(5000);
	
		Scanner scanner = new Scanner(System.in);
		int driver_option;
		System.out.println("For Driver, \n Enter 1 for vehicle health in good condition and able to take the ride"
				+ " \n Enter 2 for vehicle health in bad condition ");
		
		driver_option = scanner.nextInt();
		
		if(driver_option!=1){
			notification.sendMessage("Notification from Driver --> Vehicle in bad state, Please go for a new ride request \n");
			callSleep(2000);
			System.out.println("Your Ride Request has ended");
			callSleep(2000);
			
			Feedback fb=new Feedback();
			SignUp signup= new SignUp();
			try {
				signup.signupform();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else{
			notification.sendMessage("Notification from Driver --> Your driver is on his way \n");
			callSleep(5000);
			
			dispatch.endRide();
			
			request.setRequestState(new FinishRequest(request));
			
			callSleep(10000);
			System.out.println("Your Ride has ended");
			callSleep(10000);
			System.out.println("calling payment options");
			callSleep(10000);
			String status = showPaymentOptions();
			System.out.println(status);
		
		}		
		return "";	
	}	
	
	public String showPaymentOptions() {
		
		System.out.println("\n=========================================================\n");
		System.out.println("Please choose from the below payment methods.");
		System.out.print("1. Credit Card" + "\n" + "2. Debit Card" + "\n"
				+ "3. Paypal Account" + "\n" + "4. Cash \n");
		
		Scanner in = new Scanner(System.in);
		String menuItemString = in.nextLine();
		int menuItem = Integer.parseInt(menuItemString);
		int paymentStatusCode, amountAfterDiscount;
		switch (menuItem) {
		case 1:
			System.out.println("Paying using credit card..\n");
			CreditCardPayment credit= new CreditCardPayment();
			credit.payBill();

			break;

		case 2:
			System.out.println("Paying using debit card..\n");
			DebitCardPayment debit= new DebitCardPayment();
			debit.payBill();

			break;

		case 3:
			System.out.println("Paying using PayPal Account..\n");
			PayPalPayment paypal = new PayPalPayment();
			paypal.payBill();
			
			break;

		case 4:
			System.out.println("Paying using Cash..\n");
			CashPayment cash = new CashPayment();
			cash.payBill();
			
			break;

		}
		callSleep(5000);
		System.out.println("Ride request has been served successfully and Payment is Done");
		callSleep(5000);
		Feedback fb=new Feedback();
		return "Thanks for using Carpool Services";
	}

	
	public void callSleep(int mseconds) {
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			Thread.currentThread().interrupt();
		}
	}
	
	public String endRequest() {
		return "A request has been received and handling it already";
	}

	public String cancelRequest() {
		return "Request received should be evaluated first";
	}

}