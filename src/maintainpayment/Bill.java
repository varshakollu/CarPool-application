package maintainpayment;

public class Bill extends Payment{

	@Override
	public int payBill() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void extraCharges() {
		// TODO Auto-generated method stub
		System.out.println("This is a Regular hour so no additional charges are applied");
	}

	public boolean isSurgeHour() {
		return true;
	}

}



	