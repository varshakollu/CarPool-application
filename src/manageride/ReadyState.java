package manageride;

import manageride.InTransitState;

	public class ReadyState implements RideStateInterface{

		private Dispatch dispatch;
			
		public ReadyState(Dispatch d){
				dispatch = d;
		}

		@Override
		public String startRide() {
				// TODO Auto-generated method stub
			dispatch.setRideState(new InTransitState(dispatch));
			return "Received a ride  request";
		}

		@Override
		public String transitRide() {
				// TODO Auto-generated method stub
			return "Must initiate a ride first";
		}
			
		public String endRide() {
				// TODO Auto-generated method stub
			return "Must initiate a ride first";
		}
}