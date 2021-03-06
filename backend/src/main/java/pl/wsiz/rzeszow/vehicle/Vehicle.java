package pl.wsiz.rzeszow.vehicle;

import pl.wsiz.rzeszow.flyweightFactory.ManufacturerModel;
import pl.wsiz.rzeszow.flyweightFactory.ManufacturerModelFactory;
import pl.wsiz.rzeszow.state.FreeState;
import pl.wsiz.rzeszow.state.State;

public class Vehicle {

	private State state;
	private ManufacturerModel manufacturerModel;
	private String vin;
	
	public Vehicle() {
		this.state = new FreeState(this);
	}
	
	// FLYWEIGHT PATTERN
	public Vehicle(VehicleDTO dto) {
		this.state = new FreeState(this);
		this.manufacturerModel = ManufacturerModelFactory.getManufacturerModel(dto.getManufacturer(), dto.getModel());
		this.vin = dto.getVin();
	} 

	public State getState() {
		return state;
	}

	public void setState(State state) {
		this.state = state;
	}

	public ManufacturerModel getManufacturerModel() {
		return manufacturerModel;
	}

	public void setManufacturer(ManufacturerModel manufacturerModel) {
		this.manufacturerModel = manufacturerModel;
	}

	public String getVin() {
		return vin;
	}

	public void setVin(String vin) {
		this.vin = vin;
	}
	
	public VehicleType getType() {
		return null;
	}

}
