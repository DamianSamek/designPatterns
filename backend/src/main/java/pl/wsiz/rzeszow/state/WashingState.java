package pl.wsiz.rzeszow.state;
import pl.wsiz.rzeszow.vehicle.Vehicle;
import pl.wsiz.rzeszow.vehicle.VehicleState;

public class WashingState extends State {
	
	public WashingState(Vehicle vehicle) {
		super(vehicle);
	}

	@Override
	public VehicleState getState() {
		return VehicleState.WASHING;
	}
	
	

}
