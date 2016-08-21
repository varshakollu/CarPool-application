package manageride;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import maintainpayment.Payment;
import managerequest.DBConnection;

public class Ride extends Dispatch {

	private Connection rideconnection;
	private Statement ridestatement;

	protected int rideid;
	protected int requestid;
	protected String ride;
	protected String pickup;
	protected String dropoff;
	protected String pickuptime;
	protected String endtime;
	protected String ridestate;
	protected int passengers;
	protected String model;

	public Ride(Payment p) {
		super(p);
	}

	public Ride() {
		super();
	}

	public int getRideid() {
		return rideid;
	}

	public void setRideid(int rideid) {
		this.rideid = rideid;
	}

	public int getRequestid() {
		return requestid;
	}

	public void setRequestid(int requestid) {
		this.requestid = requestid;
	}

	public String getRide() {
		return ride;
	}

	public void setRide(String ride) {
		this.ride = ride;
	}

	public String getPickup() {
		return pickup;
	}

	public void setPickup(String pickup) {
		this.pickup = pickup;
	}

	public String getDropof() {
		return dropoff;
	}

	public void setDropoff(String dropoff) {
		this.dropoff = dropoff;
	}

	public String getPickuptime() {
		return pickuptime;
	}

	public void setPickuptime(String pickuptime) {
		this.pickuptime = pickuptime;
	}

	public String getEndtime() {
		return endtime;
	}

	public void setEndtime(String endtime) {
		this.endtime = endtime;
	}

	public String getRidestate() {
		return ridestate;
	}

	public void setRidestate(String ridestate) {
		this.ridestate = ridestate;
	}

	public int getPassengers() {
		return passengers;
	}

	public void setPassengers(int passengers) {
		this.passengers = passengers;
	}

	public String getVehicletype() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public void insertRide(int reqid, String ride, String pickup, String dropoff,
			String pickuptime, int passengers, String model)
			throws SQLException {

		try {
			String stareq = "Initiated";
			rideconnection = DBConnection.getConnection();
			ridestatement = rideconnection.createStatement();
			String sql = "INSERT INTO rideinfo (reqid, ride, pickup, dropoff, pickuptime, passengers, model)"
					+ "VALUES ("
					+ "\"" + reqid + "\"" + ","
					+ "\"" + ride + "\"" + ","
					+ "\"" + pickup + "\"" + ","
					+ "\"" + dropoff + "\"" + ","
					+ "\"" + pickuptime + "\"" + ","
					+ "\"" + String.valueOf(passengers) + "\"" + ","
					+ "\"" + model + "\"" + ")";
			ridestatement.executeUpdate(sql);

		} finally {
			DBConnection.close(ridestatement);
			DBConnection.close(rideconnection);
		}
	}
	
	public Ride getRideDetails(int RideId) throws SQLException {
		String query = "SELECT * FROM rideinfo where rideid=\"" + RideId + "\"";
		ResultSet rs = null;
		Ride ride = null;
		try {
			rideconnection = DBConnection.getConnection();
			ridestatement = rideconnection.createStatement();
			rs = ridestatement.executeQuery(query);
			if (rs.next()) {
				ride = new Ride();
				ride.setRideid(rs.getInt("rideid"));
				ride.setRequestid(rs.getInt("requestid"));
				ride.setRide(rs.getString("ridetype"));
				ride.setPickup(rs.getString("pickuplocation"));
				ride.setDropoff(rs.getString("dropofflocation"));
				ride.setPickuptime(rs.getString("pickuptime"));
				ride.setEndtime(rs.getString("endtime"));
				ride.setRidestate(rs.getString("ridestate"));
				ride.setPassengers(rs.getInt("noofseats"));
				ride.setModel(rs.getString("vehicletype"));

			}
		} finally {
			DBConnection.close(ridestatement);
			DBConnection.close(rideconnection);
		}
		return ride;
	}
	
	public void getAllDriversLocation(String rideType)
			throws SQLException {
		String query = "SELECT * FROM driver WHERE driverstatus=" + "'free'"
				+ " AND driver_type= '" + rideType + "'";
		ResultSet rs = null;
		try {
			rideconnection = DBConnection.getConnection();
			ridestatement = rideconnection.createStatement();
			rs = ridestatement.executeQuery(query);
			if (rs.next()) {
				LocationIdentifier locationid = new LocationIdentifier();
				String[] xandy = rs.getString("driverlocation").split(",");
				locationid.setLat(Integer.parseInt(xandy[0]));
				locationid.setLon(Integer.parseInt(xandy[1]));
			}
		} finally {
			DBConnection.close(ridestatement);
			DBConnection.close(rideconnection);
		}
	}
}








