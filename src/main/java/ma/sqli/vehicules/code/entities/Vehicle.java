package ma.sqli.vehicules.code.entities;

import java.util.Set;

import ma.sqli.vehicules.code.FuelType;
import ma.sqli.vehicules.code.presenters.VehiclePresenterFactory;

public abstract class Vehicle
{
	private final FuelType fuelType;
	private final int numberOfDoors;
	
	Vehicle(final FuelType fuelType, final int numberOfDoors)
	{
		this.fuelType = fuelType;
		this.numberOfDoors = numberOfDoors;
	}

	public FuelType getFuelType()
	{
		return fuelType;
	}

	public int getNumberOfDoors()
	{
		return numberOfDoors;
	}
	
	public final String move(Set<Integer> lockedDoors, double distanceInKilometers)
	{
		return VehiclePresenterFactory.getVehiclePresenter(this).present(lockedDoors, distanceInKilometers);
	}
}
