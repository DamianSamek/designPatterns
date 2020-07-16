package pl.wsiz.rzeszow;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

import pl.wsiz.rzeszow.vehicle.VehicleDTO;
import pl.wsiz.rzeszow.vehicle.VehicleType;

@Component
public class ApplicationStartup implements ApplicationListener<ApplicationReadyEvent> {

	@Autowired
	VehicleService vehicleService;
	
	@Override
	public void onApplicationEvent(ApplicationReadyEvent event) {
		try {
			init();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void init() {
		
		for(int i=0; i<3; i++) {
			vehicleService.createVehicle(new VehicleDTO("Opel", "Insignia", "W0LOZCF5238"+i, VehicleType.CAR));
		}
		for(int i=0; i<3; i++) {
			vehicleService.createVehicle(new VehicleDTO("Jelcz", "PR110U", "WWFS5CF2231"+i, VehicleType.BUS));
		}
		for(int i=0; i<3; i++) {
			vehicleService.createVehicle(new VehicleDTO("Honda", "Hornet", "AUSZZCF1349"+i, VehicleType.MOTORCYCLE));
		}
		for(int i=0; i<3; i++) {
			vehicleService.createVehicle(new VehicleDTO("Ursus", "C-360", "GGZZXSN2487"+i, VehicleType.TRACTOR));
		}
		
	}
	
}
