package ma.sqli.vehicules.code.presenters;

import java.util.Set;

import ma.sqli.vehicules.code.entities.Vehicle;

public abstract class VehiclePresenter<V extends Vehicle>
{
	private final V vehicle;
	
	VehiclePresenter (final V vehicle)
	{
		this.vehicle = vehicle;
	}
		
	V getVehicle()
	{
		return vehicle;
	}

	public abstract String present (final Set<Integer> lockedDoors, final double distanceInKilometers);
}
