package managerequest;

import java.sql.SQLException;
import java.util.Scanner;

import maintainlocation.Location;
import maintainmember.ManagerAccount;
import maintainmember.MemberImp;
import maintainmember.AccountClient;
import maintainmember.DriverImp;
import managerequest.SignUp;

public class Main {
	
	public static void main(String args[]) throws Exception{
		
		System.out.println("**********************************************************");
		System.out.println("                Welcome to Carpool Services               ");
		System.out.println("**********************************************************");
		System.out.println("Are you \n 1. Returning user \n 2. New User \n");
		Scanner sc = new Scanner(System.in);
		int mainselection = sc.nextInt();
		
		if (mainselection == 1) {
			MemberImp member =login();
		} 
		else 
		{
			SignUp sign = new SignUp();
			sign.signupform();
			System.out.println("Do you want to \n 1. Login \n 2. SignUp");
			Scanner scanner = new Scanner(System.in);
			int userinput = scanner.nextInt();
			if (userinput == 1){
				MemberImp member1 =login();
			}
			else if(userinput==2){
				sign.signupform();
			}
		}
	}
	
	public static MemberImp login() throws Exception {

		String emailid;
		String password;
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter Email Id:");
		emailid = scanner.nextLine();
		System.out.println("Enter Password:");
		password = scanner.nextLine();
		MemberImp mdao = new MemberImp();
		MemberImp memberinfo = mdao.getMember(emailid);
		if (memberinfo != null) {
			if (memberinfo.getMemberRole().equalsIgnoreCase("rider")) {
				RiderPage(emailid);
			} else if (memberinfo.getMemberRole().equalsIgnoreCase("driver")) {
				DriverPage(emailid);
			} else if (memberinfo.getMemberRole().equalsIgnoreCase("manager")) {
				ManagerPage(emailid);
			}
		} 
		else
			System.out.println("Invalid Credentials");
			return memberinfo;
	}
	
	public static void RiderPage(String emailid) throws SQLException{
		
			RequestMain req = new RequestMain();
			Scanner scanner = new Scanner(System.in);
			String ride, pickup, dropoff, model, pickuptime;
			int passengers;
		
			System.out.println(" Hey! You are successfully logged in");
			System.out.println("Do you want \n");
			System.out.println("1. Taxi");
			System.out.println("2. CarPool");
			String option = scanner.nextLine();
			if (option.equals("1")) 
			{
				ride = "Taxi Ride";
			} 
			else 
			{
				ride = "CarPool Ride";
			}
			
			System.out.println("Enter PickUp Location:");
			pickup = scanner.nextLine();
			
			System.out.println("Enter DropOff Location:");
			dropoff = scanner.nextLine();
					
			System.out.println("Enter PickUp Time(HH:MM):");
			pickuptime = scanner.nextLine();
			System.out.println("Enter No of Passengers:");
			passengers = scanner.nextInt();
			System.out.println("Enter Vehicle Model");
			System.out.println("1. Sports");
			System.out.println("2. Sedan");
			System.out.println("3. SUV");
			int i = scanner.nextInt();

			if (i == 1) {
				model = "Sports";
			} else if (i == 2) {
				model = "Sedan";
			} else {
				model = "SUV";
			}
			System.out.println("Your request is being processed, please wait for some time");
			req.receiveRequest(emailid, ride, pickup, dropoff,pickuptime, passengers, model );
	}
	
	public static void DriverPage(String emailid) throws SQLException {
		
		MemberImp memDAO = new MemberImp();
		MemberImp mem = memDAO.getMember(emailid);
		
		System.out.println(" Hey! You are successfully logged in");
		System.out.println("Your profile is: \n ");
		System.out.println("Name: " + mem.getName());
		System.out.println("Email Id: " + mem.getEmailId());
		System.out.println("Password: " + mem.getPassword());
		System.out.println("Address: " + mem.getAddress());
		System.out.println("Phone number: " + mem.getPhone());
		System.out.println("Payment Card Number: " + mem.getCardNumber());
		System.out.println("Card Expiry Date: " + mem.getExpiry());
		System.out.println("CVV: " + mem.getCvv());
		System.out.println("License Number: " + mem.getLicenseNumber());
		System.out.println("Manager: " + mem.getManager());
   }

	public static void ManagerPage(String emailid) throws Exception {
		
		MemberImp memberDao = new MemberImp();
		MemberImp member = memberDao.getMember(emailid);
		
		System.out.println(" Hey! You are successfully logged in");
		System.out.println("What do you want to do?");
		System.out.println("1. Add location");
		System.out.println("2. Delete driver");
		System.out.println("3. View users");
		Scanner in = new Scanner(System.in);
		int option_selection = in.nextInt();
		
		if(option_selection == 1) {
			Location loc = new Location();
			int i=loc.addLocation();
			if (i == 1) 
				System.out.println("Location added successfully!!");
		}
			
		else if(option_selection==2){
			
			Scanner sc= new Scanner(System.in);
			DriverImp driver = new DriverImp();
			System.out.println("Enter Email Id of the driver you want to delete");
			String id = sc.nextLine();
			
			int i = driver.removeDriver(id);
			if (i == 1) 
				System.out.println("Driver deleted successfully!!");
			else
				{
				System.out.println("Driver could not be deleted. Please try again");
				ManagerPage(emailid);
				}
		} 
		
		else if(option_selection == 3) {
			ManagerAccount manager = new ManagerAccount(member.getName());
			AccountClient.user=manager;
			AccountClient.doClientTasks();
		}
	}	
}