package pl.wsiz.rzeszow.state;
import pl.wsiz.rzeszow.vehicle.Vehicle;
import pl.wsiz.rzeszow.vehicle.VehicleState;

public class FreeState extends State {
	
	public FreeState(Vehicle vehicle) {
		super(vehicle);
	}

	@Override
	public VehicleState getState() {
		return VehicleState.FREE;
	}
	
	

}
