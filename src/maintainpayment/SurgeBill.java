package maintainpayment;

public class SurgeBill extends Payment{
	
	public boolean isSurgeHour() {
		return true;
	}

	@Override
	public int payBill() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void extraCharges() {
		// TODO Auto-generated method stub
		System.out.println("Additional charges are applied due to surge hour");

	}

}








