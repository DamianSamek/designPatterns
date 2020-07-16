package pl.wsiz.rzeszow;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import pl.wsiz.rzeszow.vehicle.Vehicle;
import pl.wsiz.rzeszow.vehicle.VehicleDTO;
import pl.wsiz.rzeszow.vehicle.VehicleState;

@Component
public class MainFacade {

	@Autowired
	VehicleService vehicleService;

	ObjectMapper mapper = new ObjectMapper();

	public String list() throws JsonProcessingException {
		List<Vehicle> list = vehicleService.getVehicles();
		return mapper.writeValueAsString(list);
	}

	public String createVehicle(VehicleDTO dto) {
		vehicleService.createVehicle(dto);
		return "";
	}

	public String setState(Integer no, VehicleState state) throws Exception {
		vehicleService.setState(no, state);
		return "";
	}

	public String delete(Integer no) {
		vehicleService.delete(no);
		return "";
	}

}
