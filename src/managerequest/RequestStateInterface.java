package managerequest;

public interface RequestStateInterface {

	public String receiveRequest(String emailid, String ride, String pickup, String dropoff, String pickuptime, int passengers, String model);

	public String processRequest(String ride);

	public String endRequest();

	public String cancelRequest();

}
