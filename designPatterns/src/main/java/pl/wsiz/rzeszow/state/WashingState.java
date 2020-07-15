package pl.wsiz.rzeszow.state;
import pl.wsiz.rzeszow.core.State;
import pl.wsiz.rzeszow.core.Vehicle;

public class WashingState extends State {

	private static final String NAME = "MYJNIA";
	
	public WashingState(Vehicle vehicle) {
		super(vehicle);
	}

	@Override
	public void _return() {
		vehicle.setState(new FreeState(vehicle));
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
