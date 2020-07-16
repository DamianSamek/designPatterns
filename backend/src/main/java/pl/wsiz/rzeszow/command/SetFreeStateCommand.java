package pl.wsiz.rzeszow.command;

import pl.wsiz.rzeszow.state.FreeState;
import pl.wsiz.rzeszow.vehicle.Vehicle;

public class SetFreeStateCommand extends Command {

	public SetFreeStateCommand(Vehicle vehicle) {
		super(vehicle);
	}

	@Override
	public void execute() {
		vehicle.setState(new FreeState(vehicle));
	}
	
	
	
	
}
