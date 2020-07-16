package pl.wsiz.rzeszow.state;
import pl.wsiz.rzeszow.vehicle.Vehicle;
import pl.wsiz.rzeszow.vehicle.VehicleState;

public class BorrowedState extends State {
	
	public BorrowedState(Vehicle vehicle) {
		super(vehicle);
	}

	@Override
	public VehicleState getState() {
		return VehicleState.BORROWED;
	}	

}
