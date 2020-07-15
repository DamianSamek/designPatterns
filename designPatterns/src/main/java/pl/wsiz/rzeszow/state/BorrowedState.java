package pl.wsiz.rzeszow.state;
import pl.wsiz.rzeszow.core.State;
import pl.wsiz.rzeszow.core.Vehicle;

public class BorrowedState extends State {

	private static final String NAME = "WYPOŻYCZONY";
	
	public BorrowedState(Vehicle vehicle) {
		super(vehicle);
	}

	@Override
	public void _return() {
		vehicle.setState(new FreeState(vehicle));
	}

	@Override
	public void setDamaged() {
		vehicle.setState(new DamagedState(vehicle));
	}

	@Override
	public String getName() {
		return NAME;
	}	

}
