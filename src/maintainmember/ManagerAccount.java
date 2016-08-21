package maintainmember;

import java.sql.SQLException;

public class ManagerAccount extends MSupervisor {
		
		public ManagerAccount(String aName) {
			this();
			username = aName;
		}

		public ManagerAccount() {
			super();
			usertitle = "Manager";
		}

		public void displayUserName() throws SQLException {
			super.displayUserName();
		}

}
