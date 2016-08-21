package maintainpayment;

import java.sql.SQLException;
import java.util.Calendar;
import java.util.Date;
import maintainnotification.CustomerNotification;
import maintainnotification.DriverNotification;
import maintainnotification.Communication;

public abstract class Payment {

	abstract public int payBill();
	
	public boolean isSurgeHour() throws SQLException {
		
		boolean SurgeHourBill = false;
		Calendar cal = Calendar.getInstance(); 					
		cal.setTime(new Date()); 
		int hour = cal.get(Calendar.HOUR_OF_DAY); 				
		if((hour >=8  && hour <= 11) || (hour >=17  && hour <= 20))             					
			SurgeHourBill = true; 				 		
		return SurgeHourBill;
	}

	public abstract void extraCharges();

	public void notifyCustomer() {
		notifyDispatcher();
		
		Communication communication=null;
		new CustomerNotification(communication, " \nNotifying Customer --> ******* Payment accepted ******* \nThanks for using our service. \n ");
	}

	public void notifyDispatcher() {
		
		Communication communication=null;
		new DriverNotification(communication, "---- Notifying Dispatcher about Successful Payment ----");
		
	}

	public void callSleep(int mseconds) {
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			Thread.currentThread().interrupt();
		}
	}

}







