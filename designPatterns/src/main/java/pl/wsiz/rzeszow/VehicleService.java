package pl.wsiz.rzeszow;

import java.util.LinkedList;
import java.util.List;

import org.springframework.stereotype.Service;

import pl.wsiz.rzeszow.core.State;
import pl.wsiz.rzeszow.core.Vehicle;
import pl.wsiz.rzeszow.vehicle.Bus;
import pl.wsiz.rzeszow.vehicle.Car;
import pl.wsiz.rzeszow.vehicle.Motorcycle;
import pl.wsiz.rzeszow.vehicle.Tractor;
import pl.wsiz.rzeszow.vehicle.VehicleDTO;
import pl.wsiz.rzeszow.vehicle.VehicleState;

@Service
public class VehicleService {

	static List<Vehicle> vehicles = new LinkedList<>();

	public List<Vehicle> getVehicles() {
		return vehicles;
	}

	// FACTORY METHOD
	public void createVehicle(VehicleDTO dto) {
		switch (dto.getType()) {
		case BUS:
			vehicles.add(new Bus(dto));
			break;
		case CAR:
			vehicles.add(new Car(dto));
			break;
		case MOTORCYCLE:
			vehicles.add(new Motorcycle(dto));
			break;
		case TRACTOR:
			vehicles.add(new Tractor(dto));
			break;
		}
		return;
	}

	//STATE PATTERN
	public void setState(Integer no, VehicleState newState) throws Exception {
		Vehicle vehicle = vehicles.get(no);
		State state = vehicle.getState();

		switch (newState) {
		case BORROWED: {
			state.borrow();
			break;
		}
		case FREE: {
			state._return();
			break;
		}
		case WASHING: {
			state.moveToCarWash();
			break;
		}
		case REPAIRING: {
			state.moveToWorkshop();
			break;
		}
		case DAMAGED: {
			state.setDamaged();
			break;
		}
		case DISPOSED: {
			state.dispose();
			break;
		}
		}
		return;
	}
	
	public void delete(int no) {
		vehicles.remove(no);
	}
}