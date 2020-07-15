package pl.wsiz.rzeszow.vehicle;

import pl.wsiz.rzeszow.core.Vehicle;

public class Car extends Vehicle {
	
	public Car(VehicleDTO dto) {
		super(dto);
	}
	
	@Override
	public String getName() {
		return "Osobowy";
	}

}
