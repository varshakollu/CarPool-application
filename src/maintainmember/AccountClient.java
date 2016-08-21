package maintainmember;

import java.sql.SQLException;

public class AccountClient {

		public static User user;
		
		public static void doClientTasks() throws SQLException {
			user.displayUserName();
		}
}

