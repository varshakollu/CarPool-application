package maintainmember;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.Statement;

import managerequest.DBConnection;

public class MemberImp {

		protected String name;
		protected String emailid;
		protected String password;
		protected String address;
		protected String phone;
		protected String card_number;
		protected String expiry;
		protected String cvv;
		protected String license_number;
		protected String member_role;
		protected String manager;
		
		private Connection conn;
		private Statement stmt;
		
		public String getCvv() {
			return cvv;
		}

		public void setCvv(String cvv) {
			this.cvv = cvv;
		}

		public String getExpiry() {
			return expiry;
		}

		public void setExpiry(String expiry) {
			this.expiry = expiry;
		}

		public String getManager() {
			return manager;
		}

		public void setManager(String manager) {
			this.manager = manager;
		}

		public String getEmailId() {
			return emailid;
		}

		public void setEmailId(String emailid) {
			this.emailid = emailid;
		}

		public String getPassword() {
			return password;
		}

		public void setPassword(String password) {
			this.password = password;
		}

		public String getMemberRole() {
			return member_role;
		}

		public void setMemberRole(String member_role) {
			this.member_role = member_role;
		}

		public String getAddress() {
			return address;
		}

		public void setAddress(String address) {
			this.address = address;
		}

		public String getCardNumber() {
			return card_number;
		}

		public void setCardNumber(String card_number) {
			this.card_number = card_number;
		}

		public String getLicenseNumber() {
			return license_number;
		}

		public void setLicenseNumber(String license_number) {
			this.license_number = license_number;
		}

		public String getPhone() {
			return phone;
		}

		public void setPhone(String phone) {
			this.phone = phone;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}
		
		public MemberImp getMember(String emailid) throws SQLException {
			String query = "SELECT * FROM userinfo where emailid=\""
					+ emailid + "\"";
			ResultSet rs = null;
			MemberImp member = null;
			try {
				conn = DBConnection.getConnection();
				stmt = conn.createStatement();
				rs = stmt.executeQuery(query);
				if (rs.next()) {
					member = new MemberImp();
					member.setName(rs.getString("name"));
					member.setEmailId(rs.getString("emailid"));
					member.setPassword(rs.getString("password"));
					member.setAddress(rs.getString("address"));
					member.setPhone(rs.getString("phone"));
					member.setCardNumber(rs.getString("card_number"));
					member.setExpiry(rs.getString("expiry"));
					member.setCvv(rs.getString("cvv"));
					member.setLicenseNumber(rs.getString("license_number"));
					member.setMemberRole(rs.getString("member_role"));
					member.setManager(rs.getString("manager"));

				}
			} finally {
				DBConnection.close(stmt);
				DBConnection.close(conn);
			}
			return member;
		}

}
