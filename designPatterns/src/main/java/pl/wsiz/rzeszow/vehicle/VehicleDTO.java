package pl.wsiz.rzeszow.vehicle;

public class VehicleDTO {

	String manufacturer;
	String model;
	String vin;
	VehicleType type;

	public VehicleDTO(String manufacturer, String model, String vin, VehicleType type) {
		this.manufacturer = manufacturer;
		this.model = model;
		this.vin = vin;
		this.type = type;
	}

	public String getManufacturer() {
		return manufacturer;
	}

	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getVin() {
		return vin;
	}

	public void setVin(String vin) {
		this.vin = vin;
	}

	public VehicleType getType() {
		return type;
	}

	public void setType(VehicleType type) {
		this.type = type;
	}

}
