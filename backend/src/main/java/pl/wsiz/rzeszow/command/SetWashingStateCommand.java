package pl.wsiz.rzeszow.command;

import pl.wsiz.rzeszow.state.WashingState;
import pl.wsiz.rzeszow.vehicle.Vehicle;

public class SetWashingStateCommand extends Command {

	public SetWashingStateCommand(Vehicle vehicle) {
		super(vehicle);
	}

	@Override
	public void execute() {
		vehicle.setState(new WashingState(vehicle));
	}

}
