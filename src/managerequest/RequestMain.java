package managerequest;

import managerequest.RequestMain;
import managerequest.RequestStateInterface;
import managerequest.StartRequest;

public class RequestMain {

	RequestStateInterface reqState;
	
	protected String ride;
	protected String requeststatus;

	public RequestMain() {
		reqState = new StartRequest(this);
	}
	
	public void receiveRequest(String emailid, String ride, String pickup, String dropoff, String pickuptime, int passengers, String model) {
		
		System.out.println(reqState.receiveRequest(emailid, ride, pickup, dropoff, pickuptime, passengers, model));
		System.out.println(reqState.processRequest(ride));
	}

	public void endRequest() {
		System.out.println(reqState.endRequest());
	}

	public void cancelRequest() {
		System.out.println(reqState.cancelRequest());
	}
	
	public static void InsertRequest() {
	}

	public String getRide() {
		return ride;
	}

	public void setRide(String ride) {
		this.ride = ride;
	}

	public String getRequest_status() {
		return requeststatus;
	}

	public void setRequest_status(String requeststatus) {
		this.requeststatus = requeststatus;
	}	
	
	public RequestStateInterface getRequestState() {
		return reqState;
	}

	public void setRequestState(RequestStateInterface requestState) {
		this.reqState = requestState;
	}
}


