package pl.wsiz.rzeszow.state;
import pl.wsiz.rzeszow.core.State;
import pl.wsiz.rzeszow.core.Vehicle;

public class FreeState extends State {

	private static final String NAME = "WOLNY";
	
	public FreeState(Vehicle vehicle) {
		super(vehicle);
	}

	@Override
	public void borrow() {
		vehicle.setState(new BorrowedState(vehicle));
	}

	@Override
	public void moveToCarWash() {
		vehicle.setState(new WashingState(vehicle));
	}

	@Override
	public void moveToWorkshop() {
		vehicle.setState(new RepairingState(vehicle));
	}

	@Override
	public String getName() {
		return NAME;
	}
	
	

}
