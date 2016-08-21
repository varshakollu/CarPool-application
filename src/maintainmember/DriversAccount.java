package maintainmember;

import java.sql.SQLException;

public class DriversAccount extends User{

		public DriversAccount(String aName) {
		this();
		username = aName;
		}
		
		public DriversAccount() {
		super();
		usertitle = "Driver";
		}

		public void displayUserName() throws SQLException {
			super.displayUserName();
		}
}

