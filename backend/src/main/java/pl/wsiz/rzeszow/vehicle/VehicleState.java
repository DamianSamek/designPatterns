package pl.wsiz.rzeszow.vehicle;

import com.fasterxml.jackson.annotation.JsonFormat;

@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum VehicleState {
	BORROWED("Wypożyczony"), DAMAGED("Uszkodzony"), DISPOSED("Zezłomowany"), FREE("Wolny"), REPAIRING("Warsztat"), WASHING("Myjnia");
	
	private String name;
	
	private VehicleState(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
}
