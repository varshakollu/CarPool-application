package maintainmember;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import maintainmember.User;
import managerequest.DBConnection;

public abstract class MSupervisor extends User{
	
	public void displayUserName() throws SQLException {
		Connection conn = null;
		Statement stmt = null;
		String man="Admin";
		String fetchquery = "SELECT name,member_role FROM userinfo where manager=\"" + man + "\"";
		ResultSet rs = null;
		ArrayList<String> reporteesName = new ArrayList<String>();
		ArrayList<String> reporteesRole = new ArrayList<String>();
		try {
			conn = DBConnection.getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(fetchquery);
			if (rs != null) {
				while (rs.next()) {
					reporteesName.add(rs.getString("name"));
					reporteesRole.add(rs.getString("member_role"));
				}
			}else {
				System.out.println("No users at this point of time\n");
				
			}
		} catch(SQLException e){
			System.out.println(e);
		}
			finally {
			DBConnection.close(stmt);
			DBConnection.close(conn);
		}	
		if (reporteesName.size() > 0) {
			System.out.println("Your Users and their respective roles are: ");
			for (int i=0;i<reporteesName.size(); i++)
				System.out.println( reporteesName.get(i) +"\t"+ reporteesRole.get(i) );
			}
		}	
	}
