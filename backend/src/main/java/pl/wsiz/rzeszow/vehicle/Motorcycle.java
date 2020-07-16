package pl.wsiz.rzeszow.vehicle;

public class Motorcycle extends Vehicle {
	
	public Motorcycle(VehicleDTO dto) {
		super(dto);
	}
	
	@Override
	public VehicleType getType() {
		return VehicleType.MOTORCYCLE;
	}

}
