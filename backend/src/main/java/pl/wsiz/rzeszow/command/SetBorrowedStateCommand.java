package pl.wsiz.rzeszow.command;

import pl.wsiz.rzeszow.state.BorrowedState;
import pl.wsiz.rzeszow.vehicle.Vehicle;

public class SetBorrowedStateCommand extends Command {

	public SetBorrowedStateCommand(Vehicle vehicle) {
		super(vehicle);
	}

	@Override
	public void execute() {
		vehicle.setState(new BorrowedState(vehicle));
	}

}
