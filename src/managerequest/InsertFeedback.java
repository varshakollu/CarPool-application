package managerequest;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class InsertFeedback {
	
	int rating;
	public InsertFeedback(int rating)
	{
		this.rating=rating;
	}

public void insertfeed(int rating) throws SQLException {
		
		Connection conn=null;
		Statement stmt=null;
		
		String query = "INSERT INTO feedback(rating) VALUES (" + "\"" + rating +"\"" + ")";
		int status = 0;
		try {
			conn = DBConnection.getConnection();
			stmt = conn.createStatement();
			status = stmt.executeUpdate(query);

		} finally {
			DBConnection.close(stmt);
			DBConnection.close(conn);
		}
		
	}
}