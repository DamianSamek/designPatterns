package pl.wsiz.rzeszow.state;
import pl.wsiz.rzeszow.vehicle.Vehicle;
import pl.wsiz.rzeszow.vehicle.VehicleState;

public class DamagedState extends State {
	
	public DamagedState(Vehicle vehicle) {
		super(vehicle);
	}

	@Override
	public VehicleState getState() {
		return VehicleState.DAMAGED;
	}
	
	

}
