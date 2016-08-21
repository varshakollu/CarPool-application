package managerequest;

import managerequest.RequestMain;
import managerequest.RequestStateInterface;
import managerequest.StartRequest;

public class FinishRequest implements RequestStateInterface {

	private RequestMain request;

	public FinishRequest(RequestMain r) {
		request = r;
	}
	public String receiveRequest(String emailid, String ride, String pickup, String dropoff, String pickuptime,
			int passengers, String model) {
		return "Request processed";
	}

	public String processRequest(String ride) {
		return "Request processed";
	}

	public String endRequest() {
		request.setRequestState(new StartRequest(request));
		return "Request successful";
	}

	public String cancelRequest() {
		request.setRequestState(new StartRequest(request));
		return "Request cancelled";
	}
}
