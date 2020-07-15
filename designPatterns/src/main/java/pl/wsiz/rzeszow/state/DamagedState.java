package pl.wsiz.rzeszow.state;
import pl.wsiz.rzeszow.core.State;
import pl.wsiz.rzeszow.core.Vehicle;

public class DamagedState extends State {

	private static final String NAME = "USZKODZONY";
	
	public DamagedState(Vehicle vehicle) {
		super(vehicle);
	}

	@Override
	public void moveToWorkshop() {
		vehicle.setState(new RepairingState(vehicle));
	}

	@Override
	public void dispose() {
		vehicle.setState(new DisposedState(vehicle));
	}

	@Override
	public String getName() {
		return NAME;
	}
	
	

}
