package pl.wsiz.rzeszow.state;
import pl.wsiz.rzeszow.vehicle.Vehicle;
import pl.wsiz.rzeszow.vehicle.VehicleState;

public class RepairingState extends State {
	
	public RepairingState(Vehicle vehicle) {
		super(vehicle);
	}

	@Override
	public VehicleState getState() {
		return VehicleState.REPAIRING;
	}
	
	

}
