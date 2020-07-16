package pl.wsiz.rzeszow.state;

import pl.wsiz.rzeszow.vehicle.Vehicle;
import pl.wsiz.rzeszow.vehicle.VehicleState;

public class DisposedState extends State{
	
	public DisposedState(Vehicle vehicle) {
		super(vehicle); 
	}

	@Override
	public VehicleState getState() {
		return VehicleState.DISPOSED;
	}
	
	

}
