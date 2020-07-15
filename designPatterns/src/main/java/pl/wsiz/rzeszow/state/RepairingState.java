package pl.wsiz.rzeszow.state;
import pl.wsiz.rzeszow.core.State;
import pl.wsiz.rzeszow.core.Vehicle;

public class RepairingState extends State {

	private static final String NAME = "WARSZTAT";
	
	public RepairingState(Vehicle vehicle) {
		super(vehicle);
	}

	@Override
	public void _return() {
		vehicle.setState(new FreeState(vehicle));
	}

	@Override
	public void moveToCarWash() {
		vehicle.setState(new WashingState(vehicle));
	}

	@Override
	public String getName() {
		return NAME;
	}
	
	

}
