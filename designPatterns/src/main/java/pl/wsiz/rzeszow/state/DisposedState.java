package pl.wsiz.rzeszow.state;

import pl.wsiz.rzeszow.core.State;
import pl.wsiz.rzeszow.core.Vehicle;

public class DisposedState extends State{

	private static final String NAME = "ZEZŁOMOWANY";
	
	public DisposedState(Vehicle vehicle) {
		super(vehicle); 
	}

	@Override
	public String getName() {
		return NAME;
	}
	
	

}
