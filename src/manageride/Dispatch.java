package manageride;

import maintainpayment.Payment;
import managerequest.RequestMain;

public abstract class Dispatch {

	private RequestMain request;
	private Payment payment;
	private RideStateInterface rsi;

	public Dispatch() {
		rsi = new ReadyState(this);
	}

	public Dispatch(Payment paymentType) {
		this.payment = paymentType;
	}

	public void notifyDriver() {
		System.out.println("Driver Notification: Your customer is waiting");
	}

	public void notifyCustomer() {
		System.out.println("Customer Notification: Your driver is on the way");
	}

	public RideStateInterface getRideState() {
		return rsi;
	}

	public void setRideState(RideStateInterface rideState) {
		this.rsi = rideState;
	}

	public void startRide() {
		this.rsi.startRide();
	}
	
	public void transitRide() {
		this.rsi.transitRide();
	}

	public void endRide() {
		this.rsi.endRide();
	}

	public RequestMain getRequest() {
		return request;
	}

	public void setRequest(RequestMain request) {
		this.request = request;
	}

	public Payment getPayment() {
		return payment;
	}

	public void setPayment(Payment payment) {
		this.payment = payment;
	}
}



