package pl.wsiz.rzeszow.state;

import pl.wsiz.rzeszow.vehicle.Vehicle;
import pl.wsiz.rzeszow.vehicle.VehicleState;

public abstract class State {

	protected Vehicle vehicle;

	public State(Vehicle vehicle) {
		this.vehicle = vehicle;
	}
	
	public abstract VehicleState getState();

}
