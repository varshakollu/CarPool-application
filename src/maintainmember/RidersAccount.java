package maintainmember;

import java.sql.SQLException;

public class RidersAccount extends User {

	public RidersAccount(String aName) {
		this();
		username = aName;
	}
	
	public RidersAccount() {
		super();
		usertitle = "Rider";
	}

	public void displayUserName() throws SQLException {
		super.displayUserName();
	}

}