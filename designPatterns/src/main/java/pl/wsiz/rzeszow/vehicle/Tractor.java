package pl.wsiz.rzeszow.vehicle;

import pl.wsiz.rzeszow.core.Vehicle;

public class Tractor extends Vehicle {
	
	public Tractor(VehicleDTO dto) {
		super(dto);
	}
	
	@Override
	public String getName() {
		return "Traktor";
	}

}
