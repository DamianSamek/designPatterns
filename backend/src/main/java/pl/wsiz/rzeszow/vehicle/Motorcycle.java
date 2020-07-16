package pl.wsiz.rzeszow.vehicle;

public class Motorcycle extends Vehicle {
	
	public Motorcycle(VehicleDTO dto) {
		super(dto);
	}
	
	@Override
	public String getName() {
		return "Motocykl";
	}

}
