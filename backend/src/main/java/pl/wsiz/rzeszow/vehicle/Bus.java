package pl.wsiz.rzeszow.vehicle;

public class Bus extends Vehicle {
	
	public Bus(VehicleDTO dto) {
		super(dto);
	}
	
	@Override
	public VehicleType getType() {
		return VehicleType.BUS;
	}

}
