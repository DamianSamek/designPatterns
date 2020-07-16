package pl.wsiz.rzeszow.vehicle;

public class Car extends Vehicle {
	
	public Car(VehicleDTO dto) {
		super(dto);
	}
	
	@Override
	public VehicleType getType() {
		return VehicleType.CAR;
	}

}
