package pl.wsiz.rzeszow.vehicle;

import pl.wsiz.rzeszow.core.Vehicle;

public class Bus extends Vehicle {
	
	public Bus(VehicleDTO dto) {
		super(dto);
	}
	
	@Override
	public String getName() {
		return "Autobus";
	}

}
