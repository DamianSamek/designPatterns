package pl.wsiz.rzeszow.command;

import pl.wsiz.rzeszow.state.DisposedState;
import pl.wsiz.rzeszow.vehicle.Vehicle;

public class SetDisposedStateCommand extends Command {

	public SetDisposedStateCommand(Vehicle vehicle) {
		super(vehicle);
	}

	@Override
	public void execute() {
		vehicle.setState(new DisposedState(vehicle));
	}

}
