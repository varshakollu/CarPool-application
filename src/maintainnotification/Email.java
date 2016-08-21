package maintainnotification;

import maintainnotification.Communication;

public class Email extends Communication{
	

	@Override
	public void notifyCustomer(String message) {
		// TODO Auto-generated method stub
		
		System.out.println("Notifying via Email: " + message + " to Customer");
	}
	@Override
	public void notifyDriver(String message){
		System.out.println("Notifying via Email: " + message + " to Driver");
	}
	

}








