package pl.wsiz.rzeszow.core;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

public class ManufacturerModelFactory {

	static Set<ManufacturerModel> manufacturerModels = new HashSet<>();

	// FLYWEIGHT PATTERN
	public static ManufacturerModel getManufacturerModel(String name, String model) {
		Optional<ManufacturerModel> manufacturerModel= manufacturerModels.stream()
				.filter(m -> name.equals(m.getName()) && model.equals(m.getModel())).findAny();
		if (manufacturerModel.isPresent()) {
			return manufacturerModel.get();
		}
		ManufacturerModel newManufacturerModel = new ManufacturerModel(name,model);	
		manufacturerModels.add(newManufacturerModel);
		return newManufacturerModel;
	}

}
