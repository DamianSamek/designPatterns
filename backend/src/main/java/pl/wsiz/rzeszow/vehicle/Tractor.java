package pl.wsiz.rzeszow.vehicle;

public class Tractor extends Vehicle {
	
	public Tractor(VehicleDTO dto) {
		super(dto);
	}
	
	@Override
	public String getName() {
		return "Traktor";
	}

}
