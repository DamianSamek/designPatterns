package pl.wsiz.rzeszow;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;

import pl.wsiz.rzeszow.vehicle.VehicleDTO;
import pl.wsiz.rzeszow.vehicle.VehicleState;

@RestController
public class MainController {

	@Autowired
	private MainFacade facade;

	@RequestMapping(value = "/list", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public String list() throws JsonProcessingException {
		return facade.list();
	}

	@RequestMapping(value = "/create", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public String create(@RequestBody VehicleDTO dto) throws JsonProcessingException {
		return facade.createVehicle(dto);
	}

	@RequestMapping(value = "/set-state/{no}/{state}", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public String setState(@PathVariable Integer no, @PathVariable VehicleState state) throws Exception {
		return facade.setState(no, state);
	}

	@RequestMapping(value = "/delete/{no}", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public String delete(@PathVariable Integer no) {
		return facade.delete(no);
	}

}
