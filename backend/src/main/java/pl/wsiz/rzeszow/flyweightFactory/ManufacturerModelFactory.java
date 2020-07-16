package pl.wsiz.rzeszow.flyweightFactory;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

public class ManufacturerModelFactory {

	static Set<ManufacturerModel> manufacturerModels = new HashSet<>();

	// FLYWEIGHT PATTERN
	public static ManufacturerModel getManufacturerModel(String manufacturer, String model) {
		Optional<ManufacturerModel> manufacturerModel= manufacturerModels.stream()
				.filter(m -> manufacturer.equals(m.getManufacturer()) && model.equals(m.getModel())).findAny();
		if (manufacturerModel.isPresent()) {
			return manufacturerModel.get();
		}
		ManufacturerModel newManufacturerModel = new ManufacturerModel(manufacturer,model);	
		manufacturerModels.add(newManufacturerModel);
		return newManufacturerModel;
	}

}
