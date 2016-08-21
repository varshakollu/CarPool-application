package managerequest;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;
import managerequest.DBConnection;
import maintainmember.MemberImp;
import managerules.MemRules;
import managerules.Rules;

public class SignUp {
	private Connection SignUpconnection;
	private Statement SignUpstatement;
	
	public void signupform() throws SQLException {
		Scanner scanner = new Scanner(System.in);
		String name, emailid, password, phone, address, member_role, card_number, expiry, cvv, license_number=null, manager = "Admin", service, model;
		int num_of_seats;
		
		System.out.println("*****Register here***** \n");
		System.out.println("Who are you? Enter your choice");
		System.out.println("1. Rider");
		System.out.println("2. Driver");
		member_role = scanner.nextLine();
		
		if (member_role.equals("1")) {
			
			System.out.println("Enter Name:");
			name = scanner.nextLine();
		
			System.out.println("Enter EmailId:");
			emailid = scanner.nextLine();
			
			System.out.println("Enter Password:");
			password = scanner.nextLine();
			
			System.out.println("Enter Address:");
			address = scanner.nextLine();
			
			System.out.println("Enter Mobile number:");
			phone = scanner.nextLine();
					
			System.out.println("Enter Payment Card No:");
			card_number = scanner.nextLine();
				
			System.out.println("Enter Card Expiry Date(MMYY):");
			expiry = scanner.nextLine();
		
			System.out.println("Enter CVV:");
			cvv = scanner.nextLine();
			
			member_role = "rider";
			license_number=null;
			
			insertUser(name,emailid,password,address,phone,card_number,expiry,cvv,license_number,member_role,manager);
				
		} 
		else if (member_role.equals("2")) {
			
			System.out.println("Enter Name:");
			name = scanner.nextLine();
		
			System.out.println("Enter EmailId:");
			emailid = scanner.nextLine();
			
			System.out.println("Enter Password:");
			password = scanner.nextLine();
			
			System.out.println("Enter Address:");
			address = scanner.nextLine();
			
			System.out.println("Enter Mobile number:");
			phone = scanner.nextLine();
			
			System.out.println("Enter Payment Card No:");
			card_number = scanner.nextLine();
				
			System.out.println("Enter Card Expiry Date(MMYY):");
			expiry = scanner.nextLine();
			
			System.out.println("Enter CVV:");
			cvv = scanner.nextLine();		
			
			System.out.println("Enter License Number:");
			license_number = scanner.nextLine();
			
			System.out.println("Enter Vehicle Model: Sports/Sedan/SUV");
			model = scanner.nextLine();
			
			System.out.println("Enter No of Seats:");
			num_of_seats = scanner.nextInt();
			
			member_role = "driver";
			
			System.out.println("What type of service do you want to provide?");
			System.out.println("1. Taxi Service");
			System.out.println("2. Carpool Service");
			
			int value = scanner.nextInt();
			
			if (value==1) {
				service = "Taxi Ride";
			}
			else
			{
				service = "Ride Share";
			}
			
			int vehicle_id = (int)Math.random();
			insertDriver(emailid, address, service);
			insertUser(name,emailid,password,address,phone,card_number,expiry,cvv,license_number,member_role,manager);
		} 
		else{
				System.out.println("Invalid Choice");
					
		    }
		}

	public void insertUser(String name, String emailid, String password, String address, String phone, String card_number, String expiry, String cvv, String license_number, String member_role, String manager) throws SQLException{
		Rules memberrules = new MemRules(emailid, member_role);
		if (memberrules.verifyRule()) {
			try {
				SignUpconnection = DBConnection.getConnection();
				SignUpstatement = SignUpconnection.createStatement();
								
				String sql = "INSERT INTO userinfo(name,emailid,password,address,phone,card_number,expiry,cvv,"
				+ "license_number, member_role, manager) VALUES ("
				+ "\"" + name + "\"" + "," 
				+ "\"" + emailid + "\"" + ","
				+ "\"" + password + "\"" + ","
				+ "\"" + address + "\"" + ","
				+ "\"" + phone + "\"" + ","
				+ "\"" + card_number + "\"" + ","
				+ "\"" + expiry + "\"" + ","
				+ "\"" + cvv + "\"" + ","
				+ "\"" + license_number + "\"" + ","
				+ "\"" + member_role + "\"" + ","
				+ "\"" + manager + "\"" + ")";

		SignUpstatement.executeUpdate(sql);		
		System.out.println("Hurray!! You are registered.");
		
			} 
			catch(SQLException e)
			{
				System.out.println(e);
			}
			finally {
				DBConnection.close(SignUpstatement);
				DBConnection.close(SignUpconnection);
			}
	}
		else
		{
			System.out.println("Rule validation failed. Please verify your details");
			signupform();
		}
	}

	public int insertVehicle(String model, int num_of_seats) throws SQLException {
		String insertquery = "INSERT INTO vehicle(model, num_of_seats) VALUES ("
				+ "\"" + model + "\"" + ","
				+ "\"" + num_of_seats +"\"" + ")";
		int status = 0;
		try {
			SignUpconnection = DBConnection.getConnection();
			SignUpstatement = SignUpconnection.createStatement();
			status = SignUpstatement.executeUpdate(insertquery);

		} finally {
			DBConnection.close(SignUpstatement);
			DBConnection.close(SignUpconnection);
		}
		return status;
	}
	
	public int insertDriver(String emailid, String address, String service) throws SQLException {
		String location = getlocationvalue();
		String driveravailability = "free";
		String insert_query = "INSERT INTO driverinfo(emailid,address,driverstatus,service) VALUES ("
				+ "\"" + emailid + "\"" + ","
				+ "\"" + address + "\"" + ","
				+ "\"" + driveravailability + "\"" + ","
				+ "\"" + service + "\"" + ")";
				
		int status = 0;
		try {
			SignUpconnection = DBConnection.getConnection();
			SignUpstatement = SignUpconnection.createStatement();
			status = SignUpstatement.executeUpdate(insert_query);

		} finally {
			DBConnection.close(SignUpstatement);
			DBConnection.close(SignUpconnection);
		}
		return status;
	}
	
	public String getlocationvalue() {
		int upper = 20;
		int lower = 10;

		int x = (int) (Math.random()) + lower;

		int y = (int) (Math.random()) + upper;

		String locationval = x + "," + y;
		return locationval;
	}

}


