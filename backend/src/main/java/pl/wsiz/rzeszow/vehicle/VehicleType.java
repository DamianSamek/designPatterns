package pl.wsiz.rzeszow.vehicle;

import com.fasterxml.jackson.annotation.JsonFormat;

@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum VehicleType {
	BUS("Autobus"), CAR("Osobowy"), MOTORCYCLE("Motocykl"), TRACTOR("Traktor");

	private String name;

	private VehicleType(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}
}
