package pl.wsiz.rzeszow.vehicle;

public class Tractor extends Vehicle {
	
	public Tractor(VehicleDTO dto) {
		super(dto);
	}
	
	@Override
	public VehicleType getType() {
		return VehicleType.TRACTOR;
	}

}
