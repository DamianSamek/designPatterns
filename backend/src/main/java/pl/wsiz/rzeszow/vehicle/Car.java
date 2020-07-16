package pl.wsiz.rzeszow.vehicle;

public class Car extends Vehicle {
	
	public Car(VehicleDTO dto) {
		super(dto);
	}
	
	@Override
	public String getName() {
		return "Osobowy";
	}

}
