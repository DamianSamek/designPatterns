package pl.wsiz.rzeszow.core;

public abstract class State {

	protected Vehicle vehicle;

	public State(Vehicle vehicle) {
		this.vehicle = vehicle;
	}
	
	public abstract String getName();

	public void borrow() throws Exception {
		throw new Exception("Niedozwolona operacja!");
	};

	public void _return() throws Exception {
		throw new Exception("Niedozwolona operacja!");
	};

	public void moveToCarWash() throws Exception {
		throw new Exception("Niedozwolona operacja!");
	};

	public void moveToWorkshop() throws Exception {
		throw new Exception("Niedozwolona operacja!");
	};
	
	public void dispose() throws Exception {
		throw new Exception("Niedozwolona operacja!");
	}
	
	public void setDamaged() throws Exception {
		throw new Exception("Niedozwolona operacja!");
	}

	@Override
	public String toString() {
		return getName();
	}

}
