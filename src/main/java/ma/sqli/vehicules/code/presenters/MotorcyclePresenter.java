package ma.sqli.vehicules.code.presenters;

import java.util.Locale;
import java.util.Set;

import ma.sqli.vehicules.code.entities.Motorcycle;

final class MotorcyclePresenter extends VehiclePresenter<Motorcycle>
{

	MotorcyclePresenter(Motorcycle vehicle)
	{
		super(vehicle);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String present(Set<Integer> lockedDoors, double distanceInKilometers)
	{
		if (getVehicle().getNumberOfDoors() == lockedDoors.size())
		{
			return String.format(Locale.US, "DOORS OK, MOVING. The MOTORCYCLE will consume %.2f L", getVehicle().getFuelType().willConsumeLiters(distanceInKilometers));
		}
		
		throw new UnsupportedOperationException("Motorcycle with unlocked doors is not yet supported");
	}
	
}
