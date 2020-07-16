package pl.wsiz.rzeszow.command;

import pl.wsiz.rzeszow.vehicle.Vehicle;

public abstract class Command {

	Vehicle vehicle;
	
	public Command(Vehicle vehicle) {
		this.vehicle = vehicle;
	}
	
	public abstract void execute();
}
