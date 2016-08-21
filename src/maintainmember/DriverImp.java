package maintainmember;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import managerequest.DBConnection;

public class DriverImp extends MemberImp {
	
	private int vehicleid;
	private String driverlocation;
	private String driverstatus;
	private String service;
	

	public int getVehicleId() {
		return vehicleid;
	}

	public void setVehicleId(int vehicleid) {
		this.vehicleid = vehicleid;
	}

	public String getDriverlocation() {
		return driverlocation;
	}

	public void setDriverlocation(String driverlocation) {
		this.driverlocation = driverlocation;
	}
	
	public String getDriverStatus() {
		return driverstatus;
	}

	public void setDriverStatus(String driverstatus) {
		this.driverstatus = driverstatus;
	}
	
	public String getService() {
		return service;
	}

	public void setService(String service) {
		this.service = service;
	}

	public int removeDriver(String email) throws SQLException{
		
		Connection conn=null;
        Statement stmt=null;
        
		String query = "DELETE FROM driverinfo WHERE emailid=" + "'" + email + "'";
        int status = 0;
        try {
            conn = DBConnection.getConnection();
            stmt = conn.createStatement();
            status = stmt.executeUpdate(query);
            
        } finally {
        	DBConnection.close(stmt);
        	DBConnection.close(conn);
        }
        return status;
    }

}


