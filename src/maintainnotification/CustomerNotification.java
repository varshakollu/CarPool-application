package maintainnotification;

import maintainnotification.Communication;
import maintainnotification.NotificationCenter;

public class CustomerNotification extends NotificationCenter {

		private String Message;
		
		public CustomerNotification(Communication com, String message) {
			super(com);
			Message = message;
			// TODO Auto-generated constructor stub
		}

		@Override
		public void notifyMember() {
			notifyCustomer(Message);
			
		}

		

	}
