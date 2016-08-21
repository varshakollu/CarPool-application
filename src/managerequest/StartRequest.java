package managerequest;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import managerequest.RequestMain;
import managerequest.RequestStateInterface;
import manageride.Ride;
import managerequest.DBConnection;

public class StartRequest implements RequestStateInterface {

	private RequestMain request;
	private Connection requestconnection;
	private Statement requeststatement;

	public StartRequest(RequestMain r) {
		request = r;
	}
	
	public String receiveRequest(String emailid, String ride, String pickup, String dropoff,
			String pickuptime, int passengers, String model) {
		// TODO Auto-generated method stub
		try {
			insertRequest(emailid, ride);
			int reqid = getMaxOfRequestId();
			Ride rideobj=new Ride();
			rideobj.insertRide(reqid, ride, pickup, dropoff, pickuptime, passengers, model);
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		request.setRequestState(new ProcessRequest(request));
		System.out.println("");
		return "Received a request";
	}
	
	public String processRequest(String ride) {
		return "Should receive a request first";
	}

	public String endRequest() {
		return "Should receive a request first";
	}

	public String cancelRequest() {
		return "Should receive a request first";
	}

	public void insertRequest(String emailid, String ride) throws SQLException {
		try {
			DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			Date date = new Date();
			String request_date = dateFormat.format(date).toString();
			String statusreq = "Initiated";
			requestconnection = DBConnection.getConnection();
			requeststatement = requestconnection.createStatement();
			
			String sql = "INSERT INTO request (emailid, ride, request_state, date) VALUES ("
					+ "\"" + emailid + "\"" + ","
					+ "\"" + ride + "\"" + ","
					+ "\"" + statusreq + "\"" + ","
					+ "\"" + request_date + "\"" + ")";
			requeststatement.executeUpdate(sql);

		} finally {
			DBConnection.close(requeststatement);
			DBConnection.close(requestconnection);
		}

	}
	
	public int getMaxOfRequestId() throws SQLException {
		int reqid_val = 0;
		String query = "select * from request";
		ResultSet rs = null;
		try {
			requestconnection = DBConnection.getConnection();
			requeststatement = requestconnection.createStatement();
			rs = requeststatement.executeQuery(query);
			while (rs.next()) {
				reqid_val++;
			}
		} finally {
			DBConnection.close(requeststatement);
			DBConnection.close(requestconnection);
		}
		return reqid_val;
	}
}

