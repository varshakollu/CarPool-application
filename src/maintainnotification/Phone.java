package maintainnotification;

//this class notifies through sms not phone

import maintainnotification.Communication;


public class Phone extends Communication{
	

	@Override
	public void notifyCustomer(String message) {
		// TODO Auto-generated method stub
		
		System.out.println("Sending SMS: '" + message + "' to Customer");
	}
	@Override
	public void notifyDriver(String message){
		System.out.println("Sending SMS: '" + message + "' to Driver");
	}
		

}






	
	

	


