package pl.wsiz.rzeszow.command;

import pl.wsiz.rzeszow.state.DamagedState;
import pl.wsiz.rzeszow.vehicle.Vehicle;

public class SetDamagedStateCommand extends Command {

	public SetDamagedStateCommand(Vehicle vehicle) {
		super(vehicle);
	}

	@Override
	public void execute() {
		vehicle.setState(new DamagedState(vehicle));
	}

}
