package managerules;


public class MemRules extends Rules{
	private String email = null;
	private String mRole = null;
	
	public MemRules(String emailId, String mRole){
		this.email = emailId;
		this.mRole = mRole;
	}
	
	public boolean verifyRule() {
		
		boolean verifyResult = false;
		if(checkNotNull(email, mRole)){
			if(mRole.equalsIgnoreCase("Driver") ||  mRole.equalsIgnoreCase("Rider") || mRole.equalsIgnoreCase("Manager") ){
				if(check_E_Address(email)){
					verifyResult = true;
				}
			}
		}
		return verifyResult;
	}
	
	public boolean checkNotNull(String email, String member_role){
		boolean isNull = true; 
		if(member_role.equalsIgnoreCase("Driver") || member_role.equalsIgnoreCase("Rider") || member_role.equalsIgnoreCase("Manger")){
			if(email == null)
				isNull = false;
		}
		return isNull;
	}
	
	public boolean check_E_Address(String email) {
        String emailPattern = "^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\])|(([a-zA-Z\\-0-9]+\\.)+[a-zA-Z]{2,}))$";
        java.util.regex.Pattern pattern = java.util.regex.Pattern.compile(emailPattern);
        java.util.regex.Matcher matcher = pattern.matcher(email);
        return matcher.matches();
        
	}
	
}
