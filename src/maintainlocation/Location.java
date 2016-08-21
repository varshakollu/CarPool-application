package maintainlocation;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import managerequest.DBConnection;

public class Location {
	String place;
	int placevalue;
	Connection conn=null;
	Statement stmt = null;
	
public void checkLocation() 
{

}

public int addLocation() throws SQLException
{
	Scanner scanner=new Scanner(System.in);
	System.out.println("Enter location name:");
	place=scanner.nextLine();

	String query = "INSERT INTO location(place) VALUES (" 
			 + "\"" + place + "\"" +")";
	
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
