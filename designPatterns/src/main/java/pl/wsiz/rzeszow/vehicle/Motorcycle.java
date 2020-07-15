package pl.wsiz.rzeszow.vehicle;

import pl.wsiz.rzeszow.core.Vehicle;

public class Motorcycle extends Vehicle {
	
	public Motorcycle(VehicleDTO dto) {
		super(dto);
	}
	
	@Override
	public String getName() {
		return "Motocykl";
	}

}
