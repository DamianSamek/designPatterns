package pl.wsiz.rzeszow.command;

import pl.wsiz.rzeszow.state.RepairingState;
import pl.wsiz.rzeszow.vehicle.Vehicle;

public class SetRepairingStateCommand extends Command {

	public SetRepairingStateCommand(Vehicle vehicle) {
		super(vehicle);
	}

	@Override
	public void execute() {
		vehicle.setState(new RepairingState(vehicle));
	}

}
