package managerequest;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import managerequest.DBConnection;

public class DBConnection {
	private static DBConnection DBinstance = new DBConnection();
	public static final String URL = "jdbc:mysql://localhost/a7g79_carpoolproject";
	public static final String USERNAME = "root";
	public static final String PASSWORD = "varsha";
	public static final String DRIVER_CLASS = "com.mysql.jdbc.Driver";
	
	private DBConnection() {
		try {
			Class.forName(DRIVER_CLASS);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	private Connection createConnection() {
		Connection conn = null;
		try {
			conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
		} catch (SQLException e) {
			System.out.println("Issue while connecting to Database.");
		}
		return conn;
	}
	
	public static Connection getConnection() {
		return DBinstance.createConnection();
	}
	
	public static void close(Connection conn) {
		if (conn != null) {
			try {
				conn.close();
			} catch (SQLException e) {
				System.err.println(e);
			}
		}
	}
	
	public static void close(Statement stmt) {
		if (stmt != null) {
			try {
				stmt.close();
			} catch (SQLException e) {
				System.err.println(e);
			}
		}
	}	
}	

