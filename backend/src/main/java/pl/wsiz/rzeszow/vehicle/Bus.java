package pl.wsiz.rzeszow.vehicle;

public class Bus extends Vehicle {
	
	public Bus(VehicleDTO dto) {
		super(dto);
	}
	
	@Override
	public String getName() {
		return "Autobus";
	}

}
