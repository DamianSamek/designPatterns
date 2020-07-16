package pl.wsiz.rzeszow;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import pl.wsiz.rzeszow.command.SetBorrowedStateCommand;
import pl.wsiz.rzeszow.command.SetDamagedStateCommand;
import pl.wsiz.rzeszow.command.SetDisposedStateCommand;
import pl.wsiz.rzeszow.command.SetFreeStateCommand;
import pl.wsiz.rzeszow.command.SetRepairingStateCommand;
import pl.wsiz.rzeszow.command.SetWashingStateCommand;
import pl.wsiz.rzeszow.vehicle.Bus;
import pl.wsiz.rzeszow.vehicle.Car;
import pl.wsiz.rzeszow.vehicle.Motorcycle;
import pl.wsiz.rzeszow.vehicle.Tractor;
import pl.wsiz.rzeszow.vehicle.Vehicle;
import pl.wsiz.rzeszow.vehicle.VehicleDTO;
import pl.wsiz.rzeszow.vehicle.VehicleState;

@Service
public class VehicleService {

	private static Map<VehicleState, List<VehicleState>> ALLOWED_TRANSITIONS = new HashMap<>();
	static {
		ALLOWED_TRANSITIONS.put(VehicleState.FREE, Arrays.asList(VehicleState.BORROWED, VehicleState.WASHING, VehicleState.REPAIRING));
		ALLOWED_TRANSITIONS.put(VehicleState.BORROWED, Arrays.asList(VehicleState.FREE, VehicleState.DAMAGED));
		ALLOWED_TRANSITIONS.put(VehicleState.DAMAGED, Arrays.asList(VehicleState.REPAIRING, VehicleState.DISPOSED));
		ALLOWED_TRANSITIONS.put(VehicleState.REPAIRING, Arrays.asList(VehicleState.FREE, VehicleState.WASHING));
		ALLOWED_TRANSITIONS.put(VehicleState.WASHING, Arrays.asList(VehicleState.FREE, VehicleState.REPAIRING));
		ALLOWED_TRANSITIONS.put(VehicleState.DISPOSED, new ArrayList<>());
	}

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

	// STATE PATTERN / COMMAND PATTERN
	public void setState(Integer no, VehicleState newState) throws Exception {
		Vehicle vehicle = vehicles.get(no);

		checkIfCommandCanBeExecuted(vehicle.getState().getState(), newState);
		switch (newState) {
		case BORROWED: {
			new SetBorrowedStateCommand(vehicle).execute();
			break;
		}
		case FREE: {
			new SetFreeStateCommand(vehicle).execute();
			break;
		}
		case WASHING: {
			new SetWashingStateCommand(vehicle).execute();
			break;
		}
		case REPAIRING: {
			new SetRepairingStateCommand(vehicle).execute();
			break;
		}
		case DAMAGED: {
			new SetDamagedStateCommand(vehicle).execute();
			break;
		}
		case DISPOSED: {
			new SetDisposedStateCommand(vehicle).execute();
			break;
		}
		}
		return;
	}

	public void delete(int no) {
		vehicles.remove(no);
	}

	private void checkIfCommandCanBeExecuted(VehicleState from, VehicleState to) throws Exception {
		if (ALLOWED_TRANSITIONS.get(from).contains(to)) {
			return;
		}
		throw new Exception("Niedozwolona operacja!");

	}
}