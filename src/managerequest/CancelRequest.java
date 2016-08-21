package managerequest;

import managerequest.StartRequest;
import managerequest.RequestMain;
import managerequest.RequestStateInterface;

public class CancelRequest implements RequestStateInterface {

	private RequestMain request;

	public CancelRequest(RequestMain r) {
		request = r;
	}

	public String receiveRequest(String emailid, String ride, String pickup, String dropoff, String pickuptime,
			int passengers, String model) {
		return "Request cancelled";
	}

	public String receiveRequest(String emailid, String ride) {
		return "Request cancelled";
	}

	public String processRequest(String ride) {
		return "Request cancelled";
	}

	public String endRequest() {
		return "Request cancelled";
	}

	public String cancelRequest() {
		request.setRequestState(new StartRequest(request));
		return "Request cancelled";
	}
}
