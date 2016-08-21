package maintainnotification;

import maintainnotification.Communication;

public abstract class NotificationCenter {

	protected Communication com;
	
	public abstract void notifyMember();

	public NotificationCenter(Communication com) {
		this.com = com;
	}
	
	protected void notifyCustomer(String message) {
		this.com.notifyCustomer( message);
	}

	protected void notifyDriver( String message) {
		this.com.notifyDriver( message);
	}


}
